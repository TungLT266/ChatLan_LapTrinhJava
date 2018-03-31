package tunglt;

public class Group {
    public String groupName;
    public String chat = "";
    public String member1 = "";
    public String member2 = "";
    public String member3 = "";
    public String member4 = "";
    public String member5 = "";
    
    public Group (String groupName) {
        this.groupName = groupName;
    }
    
    public String toString(){
        String temp = new String("");
        if(!member1.isEmpty()){
            temp += member1;
            if(!member2.isEmpty()){
                temp += ", " + member2;
                if(!member3.isEmpty()){
                    temp += ", " + member3;
                    if(!member4.isEmpty()){
                        temp += ", " + member4;
                    }
                }
            }
        }
        return temp;
    }
    
    public void addChat(String chat) {
        this.chat += chat;
    }
}
