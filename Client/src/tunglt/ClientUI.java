package tunglt;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.DefaultListModel;

public class ClientUI extends JFrame {
    public Client client;
    public Thread clientThread;
    DefaultListModel<String> defaultListModelContact;
    DefaultListModel<String> defaultListModelGroup;
    public User user[];
    public int userCount = 0;
    public JCheckBox cbFriend[];
    public Group group[];
    public int groupCount = 0;
    
    public ClientUI() {
        initComponents();
        setResizable(false);
        setSize(495, 200);
        jPanel3.setVisible(false);
        jPanel1.setVisible(false);
        setLocationRelativeTo(null);
        jPanel2.setSize(570, 270);
        jPanel1.setSize(590, 360);
        taContent.setEditable(false);
        bLeaveGroup.setVisible(false);
        lConfirm.setVisible(false);
        pfConfirm.setVisible(false);
        lMsg.setVisible(false);
        jLabel1.setVisible(false);
        defaultListModelContact = new DefaultListModel<>();
        defaultListModelContact.addElement("SERVER");
        lContacts.setModel(defaultListModelContact);
        lContacts.setSelectedIndex(0);
        defaultListModelGroup = new DefaultListModel<>();
        defaultListModelGroup.addElement("All");
        lGroup.setModel(defaultListModelGroup);
        lGroup.setSelectedIndex(0);
        spGroup.setVisible(false);
        jPanel10.setLayout(new BoxLayout(jPanel10, BoxLayout.Y_AXIS));
        cbFriend = new JCheckBox[50];
        
        
        this.addWindowListener(new WindowListener() {
            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosing(WindowEvent e) {
                try{
                    client.send(new Data("exit", lName.getText(), "exit", "server"));
                    System.exit(0);
                }
                catch(Exception ex){}
            }
            @Override public void windowClosed(WindowEvent e) {}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {}
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        spGroup = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        bCloseGroup = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfGroupName = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        bCreateGroup2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lContacts = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lGroup = new javax.swing.JList<>();
        bCreateGroup = new javax.swing.JButton();
        bLeaveGroup = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        lName = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        lAvatarFriend = new javax.swing.JLabel();
        lNameFriend = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bFile = new javax.swing.JButton();
        bSend = new javax.swing.JButton();
        tfChat = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        taContent = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lMsg = new javax.swing.JLabel();
        lConfirm = new javax.swing.JLabel();
        lUser = new javax.swing.JLabel();
        lPass = new javax.swing.JLabel();
        tUser = new javax.swing.JTextField();
        bLogin = new javax.swing.JButton();
        cbRemember = new javax.swing.JCheckBox();
        pfConfirm = new javax.swing.JPasswordField();
        pfPass = new javax.swing.JPasswordField();
        lRegister = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lLogin = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        bConnect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WELLCOME");
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(221, 236, 255));
        jPanel4.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(null);

        bCloseGroup.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bCloseGroup.setText("Close");
        bCloseGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseGroupActionPerformed(evt);
            }
        });
        jPanel9.add(bCloseGroup);
        bCloseGroup.setBounds(203, 10, 60, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Group Name");
        jPanel9.add(jLabel4);
        jLabel4.setBounds(10, 30, 150, 40);

        tfGroupName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel9.add(tfGroupName);
        tfGroupName.setBounds(50, 70, 210, 40);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(null);
        jPanel9.add(jPanel10);
        jPanel10.setBounds(30, 130, 200, 220);

        bCreateGroup2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bCreateGroup2.setText("Create Group");
        bCreateGroup2.setToolTipText("");
        bCreateGroup2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCreateGroup2ActionPerformed(evt);
            }
        });
        jPanel9.add(bCreateGroup2);
        bCreateGroup2.setBounds(40, 370, 190, 30);

        spGroup.setViewportView(jPanel9);

        jPanel4.add(spGroup);
        spGroup.setBounds(0, 180, 270, 420);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jPanel6.setLayout(null);

        lContacts.setBackground(new java.awt.Color(221, 236, 255));
        lContacts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Online", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 102, 255))); // NOI18N
        lContacts.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lContacts.setToolTipText("");
        lContacts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lContactsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lContacts);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(0, -1, 270, 390);

        jTabbedPane1.addTab("CONTACTS", jPanel6);

        jPanel7.setBackground(new java.awt.Color(221, 236, 255));
        jPanel7.setLayout(null);

        lGroup.setBackground(new java.awt.Color(221, 236, 255));
        lGroup.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lGroup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lGroupMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lGroup);

        jPanel7.add(jScrollPane2);
        jScrollPane2.setBounds(10, 60, 250, 320);

        bCreateGroup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bCreateGroup.setText("Create Group");
        bCreateGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCreateGroupActionPerformed(evt);
            }
        });
        jPanel7.add(bCreateGroup);
        bCreateGroup.setBounds(10, 10, 120, 40);

        bLeaveGroup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bLeaveGroup.setText("Leave Group");
        jPanel7.add(bLeaveGroup);
        bLeaveGroup.setBounds(150, 10, 110, 40);

        jTabbedPane1.addTab("GROUP", jPanel7);

        jPanel4.add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 180, 270, 420);
        jTabbedPane1.getAccessibleContext().setAccessibleName("CONTACTS");

        jPanel4.add(jSeparator1);
        jSeparator1.setBounds(10, 160, 250, 12);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tunglt/iconMe.png"))); // NOI18N
        jPanel4.add(jLabel3);
        jLabel3.setBounds(10, 10, 106, 130);

        lName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel4.add(lName);
        lName.setBounds(120, 10, 120, 50);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(0, 0, 270, 600);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);
        jPanel5.add(jSeparator2);
        jSeparator2.setBounds(10, 95, 600, 10);

        lAvatarFriend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tunglt/iconFriend.png"))); // NOI18N
        jPanel5.add(lAvatarFriend);
        lAvatarFriend.setBounds(50, 10, 75, 75);

        lNameFriend.setBackground(new java.awt.Color(255, 255, 255));
        lNameFriend.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel5.add(lNameFriend);
        lNameFriend.setBounds(150, 30, 430, 20);

        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("online");
        jPanel5.add(jLabel1);
        jLabel1.setBounds(160, 60, 440, 14);

        bFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tunglt/iconFile.jpg"))); // NOI18N
        jPanel5.add(bFile);
        bFile.setBounds(460, 520, 60, 60);

        bSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tunglt/iconSend.png"))); // NOI18N
        bSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSendActionPerformed(evt);
            }
        });
        jPanel5.add(bSend);
        bSend.setBounds(540, 520, 60, 60);

        tfChat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel5.add(tfChat);
        tfChat.setBounds(20, 530, 410, 40);

        taContent.setColumns(20);
        taContent.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        taContent.setRows(5);
        jScrollPane3.setViewportView(taContent);

        jPanel5.add(jScrollPane3);
        jScrollPane3.setBounds(20, 110, 580, 390);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(280, 0, 620, 600);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 900, 600);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(null);

        lMsg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lMsg.setForeground(new java.awt.Color(255, 0, 0));

        lConfirm.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lConfirm.setText("Confirm Password");

        lUser.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lUser.setText("Username");

        lPass.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lPass.setText("Password");

        tUser.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        bLogin.setBackground(java.awt.Color.cyan);
        bLogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bLogin.setForeground(new java.awt.Color(255, 255, 255));
        bLogin.setText("SIGN IN");
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });

        cbRemember.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbRemember.setText("Remember me");

        pfConfirm.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        pfConfirm.setToolTipText("");

        pfPass.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lUser)
                .addGap(120, 120, 120)
                .addComponent(tUser, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lPass, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(pfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(pfConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(cbRemember))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(bLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(cbRemember)
                .addGap(15, 15, 15)
                .addComponent(bLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 80, 570, 360);

        lRegister.setBackground(new java.awt.Color(255, 255, 255));
        lRegister.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lRegister.setForeground(new java.awt.Color(255, 255, 255));
        lRegister.setText("REGISTER");
        lRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lRegisterMouseClicked(evt);
            }
        });
        jPanel1.add(lRegister);
        lRegister.setBounds(290, 20, 200, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("|");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(260, 10, 30, 50);

        lLogin.setBackground(new java.awt.Color(255, 255, 255));
        lLogin.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lLogin.setForeground(java.awt.Color.cyan);
        lLogin.setText("LOGIN");
        lLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lLoginMouseClicked(evt);
            }
        });
        jPanel1.add(lLogin);
        lLogin.setBounds(130, 20, 130, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 590, 450);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(null);

        bConnect.setBackground(java.awt.Color.cyan);
        bConnect.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bConnect.setForeground(new java.awt.Color(255, 255, 255));
        bConnect.setText("CONNECT SERVER");
        bConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConnectActionPerformed(evt);
            }
        });
        jPanel8.add(bConnect);
        bConnect.setBounds(92, 49, 300, 50);

        getContentPane().add(jPanel8);
        jPanel8.setBounds(0, 0, 490, 180);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
        //Khi nhấn button login
        if(bLogin.getText()=="SIGN IN"){
            //Check validation
            if(tUser.getText().trim().isEmpty() | pfPass.getText().trim().isEmpty()){
                if(tUser.getText().trim().isEmpty()){
                    messageErrorForLogin("Username không được để trống.");
                }
                else if(pfPass.getText().trim().isEmpty()){
                    messageErrorForLogin("Password không được để trống.");
                }
            }
            //Gửi thông tin đăng nhập
            else{
                try{
                    client.send(new Data("login", tUser.getText(), pfPass.getText(), "server"));
                }
                catch(Exception ex){
                    messageErrorForLogin("Mất kết nối với máy chủ.");
                    System.exit(0);
                    new ClientUI().setVisible(true);
                }
            }
        }
        //Khi nhấn button register
        else if(bLogin.getText()=="SIGN UP"){
            //Check validation
            if(tUser.getText().trim().isEmpty() | pfPass.getText().trim().isEmpty() | !pfPass.getText().equals(pfConfirm.getText())){
                if(tUser.getText().trim().isEmpty()){
                    messageErrorForRegister("Username không được để trống.");
                }
                else if(pfPass.getText().trim().isEmpty()){
                    messageErrorForRegister("Password không được để trống.");
                }
                else if(!pfPass.getText().equals(pfConfirm.getText())){
                    messageErrorForRegister("Confirm Password không đúng.");
                }
            }
            //Gửi thông tin đăng ký
            else{
                try{
                    client.send(new Data("register", tUser.getText(), pfPass.getText(), "server"));
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_bLoginActionPerformed

    //Hiển thị trang register từ trang login
    private void lRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRegisterMouseClicked
        lLogin.setForeground(Color.WHITE);
        lRegister.setForeground(Color.CYAN);
        lConfirm.setVisible(true);
        pfConfirm.setVisible(true);
        bLogin.setText("SIGN UP");
        cbRemember.setVisible(false);
        jPanel2.setSize(570, 290);
        jPanel1.setSize(590, 380);
        setSize(595, 410);
        setTitle("REGISTER");
        lMsg.setVisible(false);
    }//GEN-LAST:event_lRegisterMouseClicked

    //Hiển thị trang login từ trang register
    private void lLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lLoginMouseClicked
        setPageLoginFromRegister();
    }//GEN-LAST:event_lLoginMouseClicked

    //Kết nối với server, tạo quá trình gửi - nhận từ server, lắng nghe tin nhắn từ server và xữ lý
    private void bConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConnectActionPerformed
        try {
            client = new Client(this);
            clientThread = new Thread(client);
            clientThread.start();
            
            jPanel8.setVisible(false);
            jPanel1.setVisible(true);
            setSize(595, 390);
            reloadPage();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Quá trình kết nối xảy ra lỗi. Vui lòng thử lại.");
        }
    }//GEN-LAST:event_bConnectActionPerformed

    private void lContactsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lContactsMouseClicked
        lNameFriend.setText(lContacts.getSelectedValue());
        jLabel1.setVisible(true);
        jLabel1.setText("Online");
        taContent.setText(client.findUser(lContacts.getSelectedValue()).chat);
    }//GEN-LAST:event_lContactsMouseClicked

    private void bSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSendActionPerformed
        int i = jTabbedPane1.getSelectedIndex();
        if(jTabbedPane1.getTitleAt(i).equals("CONTACTS")){
            if(!tfChat.getText().isEmpty()){
                client.send(new Data("message", lName.getText(), tfChat.getText(), lContacts.getSelectedValue()));
                client.findUser(lContacts.getSelectedValue()).chat += lName.getText()+": "+tfChat.getText()+"\n";
                taContent.setText(client.findUser(lContacts.getSelectedValue()).chat);
                tfChat.setText("");
            }
        }
        else if (jTabbedPane1.getTitleAt(i).equals("GROUP")){
            if(!tfChat.getText().isEmpty()){
                if(lGroup.getSelectedValue().equals("All")){
                    Group temp = client.findGroup(lGroup.getSelectedValue());
                    client.send(new Data("messagegroup",lName.getText(),tfChat.getText(),lGroup.getSelectedValue(),temp.member1,temp.member2,temp.member3,temp.member4));
//                    client.findGroup(lGroup.getSelectedValue()).chat += lName.getText()+": "+tfChat.getText()+"\n";
//                    taContent.setText(client.findGroup(lGroup.getSelectedValue()).chat);
                    tfChat.setText("");
                }
                else{
                    Group temp = client.findGroup(lGroup.getSelectedValue());
                    client.send(new Data("messagegroup",lName.getText(),tfChat.getText(),lGroup.getSelectedValue(),temp.member1,temp.member2,temp.member3,temp.member4));
                    client.findGroup(lGroup.getSelectedValue()).chat += lName.getText()+": "+tfChat.getText()+"\n";
                    taContent.setText(client.findGroup(lGroup.getSelectedValue()).chat);
                    tfChat.setText("");
                }
            }
        }
    }//GEN-LAST:event_bSendActionPerformed

    private void bCreateGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreateGroupActionPerformed
        spGroup.setVisible(true);
        jTabbedPane1.setVisible(false);
    }//GEN-LAST:event_bCreateGroupActionPerformed

    private void bCloseGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseGroupActionPerformed
        jTabbedPane1.setVisible(true);
        spGroup.setVisible(false);
    }//GEN-LAST:event_bCloseGroupActionPerformed

    private void bCreateGroup2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreateGroup2ActionPerformed
        if(tfGroupName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Tên Group không được phép để trống.");
        }
        else {
            
            String memberGroup[] = new String[4];
            memberGroup[0] = "";
            memberGroup[1] = "";
            memberGroup[2] = "";
            memberGroup[3] = "";
            
//            for(int i=0; i<4; i++){
//                memberGroup[i] = "";
//            }
            int memberGroupCount = 0;
            for(int i = 1; i < userCount; i++) {
                if(cbFriend[i].isSelected()){
                    memberGroup[memberGroupCount] = cbFriend[i].getText();
                    System.out.println(memberGroup[memberGroupCount]);
                    memberGroupCount++;
                    cbFriend[i].setSelected(false);
                }
            }
            try{
                client.send(new Data("newgroup",lName.getText(),tfGroupName.getText(),memberGroup[0],memberGroup[1],memberGroup[2],memberGroup[3]));
            }
            catch(Exception e){
            }
            tfGroupName.setText("");
            JOptionPane.showMessageDialog(this,"Tạo nhóm thành công.");
            jTabbedPane1.setVisible(true);
            spGroup.setVisible(false);
        }
        
    }//GEN-LAST:event_bCreateGroup2ActionPerformed

    private void lGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lGroupMouseClicked
        lNameFriend.setText(lGroup.getSelectedValue());
        if(lGroup.getSelectedValue().equals("All")){
            jLabel1.setVisible(false);
//            String a = new String(client.findGroup(lGroup.getSelectedValue()).toString());
            jLabel1.setText(client.findGroup(lGroup.getSelectedValue()).toString());
            taContent.setText(client.findGroup(lGroup.getSelectedValue()).chat);
        }
        else{
            jLabel1.setVisible(true);
            jLabel1.setText(client.findGroup(lGroup.getSelectedValue()).toString());
            taContent.setText(client.findGroup(lGroup.getSelectedValue()).chat);
        }
    }//GEN-LAST:event_lGroupMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientUI().setVisible(true);
            }
        });
    }
    
    //Hiển thị message thông báo lỗi cho trang login
    public void messageErrorForLogin (String msgError){
        lMsg.setText(msgError);
        lMsg.setVisible(true);
        jPanel2.setSize(570, 300);
        jPanel1.setSize(590, 390);
        setSize(595, 420);
    }
    
    //Hiển thị message thông báo lỗi cho trang register
    public void messageErrorForRegister (String msgError){
        lMsg.setText(msgError);
        lMsg.setVisible(true);
        jPanel2.setSize(570, 320);
        jPanel1.setSize(590, 410);
        setSize(595, 440);
    }

    //Hiển thị trang login từ trang register
    public void setPageLoginFromRegister(){
        lLogin.setForeground(Color.CYAN);
        lRegister.setForeground(Color.WHITE);
        lConfirm.setVisible(false);
        pfConfirm.setVisible(false);
        bLogin.setText("SIGN IN");
        jPanel2.setSize(570, 270);
        jPanel1.setSize(590, 360);
        setSize(595, 390);
        cbRemember.setVisible(true);
        setTitle("LOGIN");
        lMsg.setVisible(false);
    }
    
    //Load lại trang, setup vị trí hiển thị
    public void reloadPage(){
        setVisible(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
//    public String nowTime(){
//        return new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(new Date().getTime());
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bCloseGroup;
    public javax.swing.JButton bConnect;
    public javax.swing.JButton bCreateGroup;
    public javax.swing.JButton bCreateGroup2;
    private javax.swing.JButton bFile;
    public javax.swing.JButton bLeaveGroup;
    public javax.swing.JButton bLogin;
    private javax.swing.JButton bSend;
    public javax.swing.JCheckBox cbRemember;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JLabel lAvatarFriend;
    public javax.swing.JLabel lConfirm;
    public javax.swing.JList<String> lContacts;
    public javax.swing.JList<String> lGroup;
    public javax.swing.JLabel lLogin;
    public javax.swing.JLabel lMsg;
    public javax.swing.JLabel lName;
    public javax.swing.JLabel lNameFriend;
    public javax.swing.JLabel lPass;
    public javax.swing.JLabel lRegister;
    public javax.swing.JLabel lUser;
    public javax.swing.JPasswordField pfConfirm;
    public javax.swing.JPasswordField pfPass;
    public javax.swing.JScrollPane spGroup;
    public javax.swing.JTextField tUser;
    public javax.swing.JTextArea taContent;
    public javax.swing.JTextField tfChat;
    public javax.swing.JTextField tfGroupName;
    // End of variables declaration//GEN-END:variables
}
