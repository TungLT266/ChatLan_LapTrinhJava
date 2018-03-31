package tunglt;

import java.io.*;
import java.net.*;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class Client implements Runnable {
    public Socket server;
    public ClientUI ui;
    public ObjectInputStream In;
    public ObjectOutputStream Out;
    
    public Client(ClientUI frame) throws IOException{
        ui = frame; //Truyền vào tất cả từ giao diện
        server = new Socket("localhost", 13000); //Kết nối với server
        Out = new ObjectOutputStream(server.getOutputStream()); //Tạo quá trình gửi dữ liệu đến server
        Out.flush(); //Làm sạch dữ liệu gửi đi
        In = new ObjectInputStream(server.getInputStream()); //Tạo quá trình nhận dữ liệu từ server
        ui.user = new User[50];
        ui.group = new Group[50];
    }
    
    @Override
    public void run() {
        while(true){
            try{
                //Nhận tin nhắn từ server
                Data msg = (Data) In.readObject();
                
                //Nhận phản hồi từ quá trình login
                if(msg.type.equals("login")){
                    if(msg.content.equals("wellcome")){
                        ui.jPanel1.setVisible(false);
                        ui.jPanel3.setVisible(true);
                        ui.setSize(905, 630);
                        ui.lName.setText(msg.recipient1);
                        ui.reloadPage();
                        
                        ui.user[ui.userCount] = new User("SERVER");
                        ui.userCount++;
                        
                        ui.group[ui.groupCount] = new Group("All");
                        ui.groupCount++;
                    }
                    else if(msg.content.equals("exist")){
                        ui.messageErrorForLogin("Tài khoản đã được đăng nhập bởi một người dùng khác.");
                    }
                    else if(msg.content.equals("user")){
                        ui.messageErrorForLogin("Tài khoản không tồn tại.");
                    }
                    else if(msg.content.equals("pass")){
                        ui.messageErrorForLogin("Mật khẩu bạn nhập không đúng.");
                    }
                    else if(msg.content.equals("error")){
                        JOptionPane.showMessageDialog(ui, "Quá trình đăng nhập xảy ra lỗi. Vui lòng đăng nhập lại.");
                    }
                }
                //nhận phản hồi từ quá trình đăng ký
                else if(msg.type.equals("register")){
                    if(msg.content.equals("true")){
                        JOptionPane.showMessageDialog(ui, "Đăng ký tài khoản thành công. Quay lại trang đăng nhập.");
                        ui.setPageLoginFromRegister();
                    }
                    else if(msg.content.equals("false")){
                        ui.messageErrorForRegister("Username đã tồn tại.");
                    }
                }
                else if(msg.type.equals("newuser")){
                    if(!msg.content.equals(ui.lName.getText())){
                        ui.defaultListModelContact.addElement(msg.content);
                        ui.user[ui.userCount] = new User(msg.content);
                        ui.cbFriend[ui.userCount] = new JCheckBox(msg.content);
                        ui.jPanel10.add(ui.cbFriend[ui.userCount]);
                        ui.userCount++;
                    }
                }
                else if(msg.type.equals("exit")){
                    ui.defaultListModelContact.removeElement(msg.sender);
                    ui.jPanel10.remove(ui.cbFriend[findUserCount(msg.sender)]);
                    //thieu chinh userCount
                }
                else if(msg.type.equals("message")){
                    findUser(msg.sender).chat += msg.sender+": "+msg.content+"\n";
                    ui.lContacts.setSelectedValue(msg.sender, true);
                    ui.taContent.setText(findUser(msg.sender).chat);
                    ui.jTabbedPane1.setSelectedIndex(0);
                    ui.jLabel1.setVisible(true);
                    ui.jLabel1.setText("Online");
                    ui.taContent.setText(findUser(msg.sender).chat);
                    ui.lNameFriend.setText(msg.sender);
                }
                else if(msg.type.equals("remove")) {
                    JOptionPane.showMessageDialog(ui, "Mất kết nối với máy chủ.");
                    System.exit(0);
                }
                else if(msg.type.equals("newgroup")){
                    ui.defaultListModelGroup.addElement(msg.content);
                    ui.group[ui.groupCount] = new Group(msg.content);
                    if(!msg.recipient1.isEmpty()){
                        ui.group[ui.groupCount].member1 = msg.recipient1;
                        if(!msg.recipient2.isEmpty()){
                            ui.group[ui.groupCount].member2 = msg.recipient2;
                            if(!msg.recipient3.isEmpty()){
                                ui.group[ui.groupCount].member3 = msg.recipient3;
                                if(!msg.recipient4.isEmpty()){
                                    ui.group[ui.groupCount].member4 = msg.recipient4;
                                }
                            }
                        }
                    }
                    ui.groupCount++;
                }
                else if(msg.type.equals("messagegroup")){
//                    if(!msg.sender.equals(ui.lName)){
                        findGroup(msg.recipient1).chat += msg.sender+": "+msg.content+"\n";
                        ui.lGroup.setSelectedValue(msg.recipient1, true);
                        ui.taContent.setText(findGroup(msg.recipient1).chat);
//                    }
                        ui.jTabbedPane1.setSelectedIndex(1);
                        ui.jLabel1.setVisible(true);
                        ui.jLabel1.setText(findGroup(msg.recipient1).toString());
                        ui.taContent.setText(findGroup(msg.recipient1).chat);
                        ui.lNameFriend.setText(msg.recipient1);
                }
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(ui, "Mất kết nối với máy chủ.");
                System.exit(0);
            }
        }
    }
    
    //gửi tin nhắn đến server
    public void send(Data msg){
        try {
//            System.out.println(msg.type+msg.sender+msg.content+msg.recipient1+msg.recipient2+msg.recipient3+msg.recipient4);
            Out.writeObject(msg);
            Out.flush();
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(ui, "Mất kết nối với máy chủ.");
            ui.client.send(new Data("exit", ui.lName.getText(), "exit", "server"));
            System.exit(0);
        }
    }
    
    public User findUser(String username){
        for(int i = 0; i < ui.userCount; i++){
            if(ui.user[i].username.equals(username)){
                return ui.user[i];
            }
        }
        return null;
    }
    
    public int findUserCount (String username){
        for(int i = 0; i < ui.userCount; i++){
            if(ui.user[i].username.equals(username)){
                return i;
            }
        }
        return 0;
    }
    
    public Group findGroup(String groupname) {
        for(int i = 0; i < ui.userCount; i++) {
            if(ui.group[i].groupName.equals(groupname)) {
                return ui.group[i];
            }
        }
        return null;
    }
}