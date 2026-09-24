package Entity;

import java.time.LocalDateTime;

public class Comment {
    private final String id;
    private final String content;
    private final User author;
    private final LocalDateTime createdAt;

    public Comment(String id, String content, User author) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
