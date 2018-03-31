package tunglt;

public class User {
    public String username;
    public String chat;
    
    public User (String username) {
        this.username = username;
        chat = "";
    }
    
    public void addChat(String chat) {
        this.chat += chat;
    }
}
