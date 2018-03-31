package tunglt;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class Server implements Runnable {
    public ServerThread clients[];
    public ServerUI ui;
    public ModelUser db;
    public ServerSocket server;
    public Thread thread = null;
    public int clientCount = 0;
    
    public Server(ServerUI frame) {
        clients = new ServerThread[50];
        ui = frame;
        db = new ModelUser();
        
        try{
            server = new ServerSocket(13000);
//            start();
            thread = new Thread(this);
	    thread.start();
        }
        catch(IOException ioe){
            JOptionPane.showMessageDialog(ui, "Khởi động Server thất bại.");
            System.exit(0);
	}
    }

    @Override
    public void run() {
        while (thread != null){  
            try{
	        addThread(server.accept());
	    }
	    catch(Exception ioe){ 
                ui.taServer.append("Server bị lỗi\n");
	    }
        }
    }
    
//    public void start(){
//    	if (thread == null){  
//            thread = new Thread(this);
//	    thread.start();
//	}
//    }
    
    private void addThread(Socket socket) {
        ui.taServer.append(ui.nowTime()+": "+socket+" đang kết nối...\n");
	if (clientCount < clients.length) {
	    clients[clientCount] = new ServerThread(this, socket);
	    try {
	      	clients[clientCount].open();
	        clients[clientCount].start();
	        clientCount++;
	    }
	    catch(IOException ioe) {
	      	ui.taServer.append("Lỗi " + ioe + ".\n");
	    } 
	}
        else {
            ui.taServer.append(ui.nowTime()+": "+socket+" bị từ chối kết nối (tối đa "+clients.length+" client truy cập).\n");
            //chưa báo hiệu cho client truy cập full
	}
    }
    
    //server kiem tra message nhan duoc
    public synchronized void handle(int ID, Data msg){
        //Xử lí yêu cầu đăng nhập
        if(msg.type.equals("login")){
            //User đúng
            if(db.checkLogin(msg.sender, msg.content) == 0){
                //User chưa được người dùng khác sử dụng
                if(findUserThread(msg.sender) == null){
                    clients[findClient(ID)].username = msg.sender;
                    clients[findClient(ID)].send(new Data("login", "server", "wellcome", msg.sender));
                    sendAll("newuser", "server", msg.sender);
                    SendUserList(msg.sender);
                    ui.defaultListModel.addElement(msg.sender);
                    ui.taServer.append(ui.nowTime()+": Client "+msg.sender+" đã đăng nhập.\n");
                }
                //User đã sử dụng bởi người dùng khác
                else{
                    clients[findClient(ID)].send(new Data("login", "server", "exist", msg.sender));
                }
            }
            else if(db.checkLogin(msg.sender, msg.content) == 1){
                clients[findClient(ID)].send(new Data("login", "server", "user", msg.sender));
            }
            else if(db.checkLogin(msg.sender, msg.content) == 2){
                clients[findClient(ID)].send(new Data("login", "server", "pass", msg.sender));
            }
            else if(db.checkLogin(msg.sender, msg.content) == 3){
                clients[findClient(ID)].send(new Data("login", "server", "error", msg.sender));
            }
        }
        else if(msg.type.equals("register")){
            if(!db.userExists(msg.sender)){
                db.addUser(msg.sender, msg.content);
                clients[findClient(ID)].send(new Data("register", "server", "true", msg.sender));
                ui.taServer.append(ui.nowTime()+": "+clients[findClient(ID)]+" đã đăng ký tài khoản thành công với Username: "+msg.sender+"và Password: "+msg.content+".\n");
            }
            else{
                clients[findClient(ID)].send(new Data("register", "server", "false", msg.sender));
            }
        }
        else if(msg.type.equals("exit")){
            ui.taServer.append(ui.nowTime()+": Client "+msg.sender+" đã thoát.\n");
            sendAll("exit", msg.sender, "exit");
            ui.defaultListModel.removeElement(msg.sender);
            remove(ID);
        }
        else if(msg.type.equals("message")){
            ui.taServer.append(ui.nowTime()+": ["+msg.sender+" -> "+msg.recipient1+"] "+msg.content+"\n");
            if(!msg.recipient1.equals("SERVER")) {
                findUserThread(msg.recipient1).send(new Data("message", msg.sender, msg.content, msg.recipient1));
            }
        }
        else if(msg.type.equals("newgroup")){
            String newGroup = new String(msg.sender+" đã tạo Group "+msg.content+" gồm các thành viên: "+msg.sender);
            findUserThread(msg.sender).send(new Data("newgroup","server",msg.content,msg.recipient1,msg.recipient2,msg.recipient3,msg.recipient4));
            if(!msg.recipient1.isEmpty()){
                findUserThread(msg.recipient1).send(new Data("newgroup","server",msg.content,msg.sender,msg.recipient2,msg.recipient3,msg.recipient4));
                newGroup += ", " +msg.recipient1;
                if(!msg.recipient2.isEmpty()){
                    findUserThread(msg.recipient2).send(new Data("newgroup","server",msg.content,msg.sender,msg.recipient1,msg.recipient3,msg.recipient4));
                    newGroup += ", " +msg.recipient2;
                    if(!msg.recipient3.isEmpty()){
                        findUserThread(msg.recipient3).send(new Data("newgroup","server",msg.content,msg.sender,msg.recipient1,msg.recipient2,msg.recipient4));
                        newGroup += ", " +msg.recipient3;
                        if(!msg.recipient4.isEmpty()){
                            findUserThread(msg.recipient4).send(new Data("newgroup","server",msg.content,msg.sender,msg.recipient1,msg.recipient2,msg.recipient3));
                            newGroup += ", " +msg.recipient4;
                        }
                    }
                }
            }
            ui.taServer.append(ui.nowTime()+": "+newGroup+".\n");
        }
        else if(msg.type.equals("messagegroup")){
            if(msg.recipient1.equals("All")) {
                ui.taServer.append(ui.nowTime()+": ["+msg.sender+" -> All] "+msg.content+"\n");
                sendAll("messagegroup", msg.sender, msg.content);
            }
            ui.taServer.append(ui.nowTime()+": ["+msg.sender+" -> Group:"+msg.recipient1+"] "+msg.content+"\n");
            if(!msg.recipient2.isEmpty()){
                findUserThread(msg.recipient2).send(new Data("messagegroup",msg.sender,msg.content,msg.recipient1));
                if(!msg.recipient3.isEmpty()){
                    findUserThread(msg.recipient3).send(new Data("messagegroup",msg.sender,msg.content,msg.recipient1));
                    if(!msg.recipient4.isEmpty()){
                        findUserThread(msg.recipient4).send(new Data("messagegroup",msg.sender,msg.content,msg.recipient1));
                        if(!msg.recipient5.isEmpty()){
                            findUserThread(msg.recipient5).send(new Data("messagegroup",msg.sender,msg.content,msg.recipient1));
                        }
                    }
                }
            }
        }
    }
    
    public ServerThread findUserThread(String usr){
        for(int i = 0; i < clientCount; i++){
            if(clients[i].username.equals(usr)){
                return clients[i];
            }
        }
        return null;
    }
    
    private int findClient(int ID){  
    	for (int i = 0; i < clientCount; i++){
            if (clients[i].getID() == ID){
                return i;
            }
	}
	return -1;
    }
    
    public void sendAll(String type, String sender, String content){
        Data msg = new Data(type, sender, content, "All");
        for(int i = 0; i < clientCount; i++) {
            clients[i].send(msg);
        }
    }
    
    public void SendUserList(String toWhom){
        for(int i = 0; i < clientCount; i++){
            findUserThread(toWhom).send(new Data("newuser", "server", clients[i].username, toWhom));
        }
    }
    
    public synchronized void remove(int ID){
        int pos = findClient(ID);
        if (pos >= 0){  
            ServerThread toTerminate = clients[pos];
	    if (pos < clientCount-1){
                for (int i = pos+1; i < clientCount; i++){
                    clients[i-1] = clients[i];
	        }
	    }
	    clientCount--;
	    try{  
	      	toTerminate.close(); 
	    }
	    catch(IOException ioe){  
	    }
	    toTerminate.stop(); 
	}
    }
    
    public void removeAll() {
        if(clientCount > 0){
            for (int i = 0; i < clientCount; i++) {
                try {
                    clients[i].close();
                }
                catch(IOException ioe){}
            }
            clientCount = 0;
        }
    }
    
    public void stop(){  
        if (thread != null){  
            thread.stop(); 
	    thread = null;
	}
        for(int i = 0; i < clientCount; i++) {
            clients[i].stop();
        }
        server = null;
    }
}

class ServerThread extends Thread {
    public Server server = null;
    public Socket socket = null;
    public int ID = -1;
    public String username = "";
    public ObjectInputStream streamIn  =  null;
    public ObjectOutputStream streamOut = null;
    public ServerUI ui;

    public ServerThread(Server _server, Socket _socket) {
    	super();
        server = _server;
        socket = _socket;
        ID     = socket.getPort();
        ui = _server.ui;
    }
    
    @SuppressWarnings("deprecation")
    public void run(){
        while (true){
    	    try{  
                Data msg = (Data) streamIn.readObject();
    	    	server.handle(ID, msg);
            }
            catch(Exception ioe){
                server.remove(ID);
                stop();
            }
        }
    }
    
    public void open() throws IOException {  
        streamOut = new ObjectOutputStream(socket.getOutputStream());
        streamOut.flush();
        streamIn = new ObjectInputStream(socket.getInputStream());
    }
    
    public int getID(){  
	    return ID;
    }
    
    public void send(Data msg){
        try {
            streamOut.writeObject(msg);
            streamOut.flush();
        } 
        catch (IOException ex) {
            System.out.println("Lỗi gửi socket máy khách");
        }
    }
    
    public void close() throws IOException {  
    	if (socket != null)    socket.close();
        if (streamIn != null)  streamIn.close();
        if (streamOut != null) streamOut.close();
    }
}
