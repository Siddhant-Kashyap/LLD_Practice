package Entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String email;
    private int reputation;
    private LocalDateTime createdAt;

    public User(String name, String email, LocalDateTime createdAt) {
        this.id = getId();
        this.name = name;
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }
    public String getId(){
        return "U"+ UUID.randomUUID();
    }
    public void addReputation(int reputation){
        this.reputation += reputation;
    }
    public int getReputation(){
        return this.reputation;
    }
    public void subsReputation(int reputation){
        this.reputation-=reputation;
    }
    public String getName(){
        return this.name;
    }
}
