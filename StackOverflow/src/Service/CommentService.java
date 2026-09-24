package Service;

import Entity.Comment;
import Entity.User;
import Interface.Commentable;

import java.util.UUID;

public class CommentService {

    public Comment addComment(User user, Commentable target,String content){
        if(user ==null || content==null){
            throw new IllegalArgumentException("Not valid comment");
        }
        Comment comment = new Comment(UUID.randomUUID().toString(),content,user);
        target.addComment(comment);
        return comment;
    }

}
