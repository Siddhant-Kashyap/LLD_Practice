package Entity;

import Interface.Commentable;
import Interface.Votable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Question implements Votable, Commentable {
    private final String id;
    private final String title;
    private final String description;
    private final User author;

    private final List<Tag> tags;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final List<Vote> votes;

    private  Answer acceptedAnswer;
    private final LocalDateTime createdAt;

    public Question(String id, String title, String description, User author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.tags = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
    }

    public void addTags(Tag tag){
        this.tags.add(tag);
    }
    public void addAnswer(Answer answer){
        this.answers.add(answer);
    }

    @Override
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }


    @Override
    public List<Comment> getComments() {
        return List.of();
    }

    @Override
    public void addVote(Vote vote) {
        this.votes.add(vote);
    }
    public void acceptAnswer(Answer answer,User user){

    }

    @Override
    public int getScore() {
        int score =0;
        for(Vote vote :votes){
            if(vote.getVoteType() == VoteType.UPVOTE){
            score++;
            }else{
            score--;
            }
        }
        return score;
    }

    @Override
    public void removeVote(Vote vote) {
        this.votes.remove(vote);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getAuthor() {
        return author;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
