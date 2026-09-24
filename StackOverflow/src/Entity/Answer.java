package Entity;

import Interface.Commentable;
import Interface.Votable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Answer implements Votable, Commentable {
    private final String id;
    private final String content;
    private final User author;
    private final Question question;
    private List<Comment> comments ;
    private List<Vote> votes ;

    private LocalDateTime createdAt;

    public Answer(String id, String content, User author, Question question) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.question = question;
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void addVote(Vote vote) {
        votes.add(vote);
    }

    @Override
    public int getScore() {
        return votes.stream()
                .mapToInt(vote->vote.getVoteType() ==VoteType.UPVOTE?1:-1).sum();
    }

    @Override
    public void removeVote(Vote vote) {
        votes.remove(vote);
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

    public Question getQuestion() {
        return question;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
