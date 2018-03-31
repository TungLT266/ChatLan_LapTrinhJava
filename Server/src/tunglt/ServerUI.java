package tunglt;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerUI extends JFrame {
    public Server server;
    DefaultListModel<String> defaultListModel;
    
    public ServerUI() {
        initComponents();
        setSize(495, 200);
        jPanel1.setVisible(false);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        taServer.setEditable(false);
        defaultListModel = new DefaultListModel<>();
        defaultListModel.addElement("All");
        lOnline.setModel(defaultListModel);
        lOnline.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taServer = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        lOnline = new javax.swing.JList<>();
        tfSend = new javax.swing.JTextField();
        bSend = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        bStartServer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WELLCOME");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        taServer.setColumns(20);
        taServer.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        taServer.setRows(5);
        jScrollPane1.setViewportView(taServer);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 580, 500);

        lOnline.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Online", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 102, 255))); // NOI18N
        jScrollPane2.setViewportView(lOnline);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(610, 10, 170, 500);
        jPanel1.add(tfSend);
        tfSend.setBounds(10, 520, 450, 40);

        bSend.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bSend.setText("Send");
        bSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSendActionPerformed(evt);
            }
        });
        jPanel1.add(bSend);
        bSend.setBounds(480, 520, 110, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(610, 520, 170, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 810, 630);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        bStartServer.setBackground(java.awt.Color.cyan);
        bStartServer.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bStartServer.setForeground(new java.awt.Color(255, 255, 255));
        bStartServer.setText("START SERVER");
        bStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartServerActionPerformed(evt);
            }
        });
        jPanel2.add(bStartServer);
        bStartServer.setBounds(100, 50, 300, 50);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 490, 180);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSendActionPerformed
        if(!tfSend.getText().isEmpty()) {
            if(lOnline.getSelectedValue().equals("All")) {
                server.sendAll("message", "SERVER", tfSend.getText());
                taServer.append(nowTime()+": [SERVER -> All] "+tfSend.getText());
            }
            else {
                server.findUserThread(lOnline.getSelectedValue()).send(new Data("message","SERVER",tfSend.getText(),lOnline.getSelectedValue()));
                taServer.append(nowTime()+": [SERVER -> "+lOnline.getSelectedValue()+"] "+tfSend.getText());
            }
            tfSend.setText("");
        }
    }//GEN-LAST:event_bSendActionPerformed

    private void bStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartServerActionPerformed
        server = new Server(this);
        
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        setTitle("SERVER");
        setSize(800, 600);
        taServer.append(nowTime() + ": Server đã khởi động.\n");

        setVisible(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }//GEN-LAST:event_bStartServerActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(lOnline.getSelectedValue().equals("All")) {
            taServer.append(nowTime()+": Đã remove tất cả Client.\n");
            defaultListModel.removeAllElements();
            defaultListModel.addElement("All");
            server.sendAll("remove", "SERVER", "remove");
            server.removeAll();
        }
        else {
            server.findUserThread(lOnline.getSelectedValue()).send(new Data("remove","SERVER","remove",lOnline.getSelectedValue()));
            taServer.append(nowTime()+": Đã remove Client "+lOnline.getSelectedValue()+".\n");
            server.sendAll("exit", lOnline.getSelectedValue(), "exit");
            defaultListModel.removeElement(lOnline.getSelectedValue());
            server.remove(server.findUserThread(lOnline.getSelectedValue()).getID());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerUI().setVisible(true);
            }
        });
    }
    
    public String nowTime(){
        return (new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(new Date().getTime()));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bSend;
    private javax.swing.JButton bStartServer;
    private javax.swing.JButton jButton2;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JList<String> lOnline;
    public javax.swing.JTextArea taServer;
    public javax.swing.JTextField tfSend;
    // End of variables declaration//GEN-END:variables
}
