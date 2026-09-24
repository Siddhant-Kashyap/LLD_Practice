package Entity;

public class Vote {
    private  String id;
    private VoteType voteType;
    private User voter;

    public Vote(String id, VoteType voteType, User voter) {
        this.id = id;
        this.voteType = voteType;
        this.voter = voter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }

    public User getVoter() {
        return voter;
    }

    public void setVoter(User voter) {
        this.voter = voter;
    }
}
