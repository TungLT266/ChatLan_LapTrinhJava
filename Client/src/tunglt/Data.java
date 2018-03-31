package tunglt;

import java.io.Serializable;

public class Data implements Serializable{
    private static final long serialVersionUID = 1L;
    public String type, sender, content, recipient1;
    public String recipient2 = null;
    public String recipient3 = null;
    public String recipient4 = null;
    public String recipient5 = null;
    
    public Data(String type, String sender, String content, String recipient1){
        this.type = type;
        this.sender = sender;
        this.content = content;
        this.recipient1 = recipient1;
    }
    
    public Data(String type, String sender, String content, String recipient1, String recipient2, String recipient3, String recipient4){
        this.type = type;
        this.sender = sender;
        this.content = content;
        this.recipient1 = recipient1;
        this.recipient2 = recipient2;
        this.recipient3 = recipient3;
        this.recipient4 = recipient4;
    }
    
    public Data(String type, String sender, String content, String recipient1, String recipient2, String recipient3, String recipient4, String recipient5){
        this.type = type;
        this.sender = sender;
        this.content = content;
        this.recipient1 = recipient1;
        this.recipient2 = recipient2;
        this.recipient3 = recipient3;
        this.recipient4 = recipient4;
        this.recipient4 = recipient5;
    }
}