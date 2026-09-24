package Interface;

import Entity.Vote;

public interface Votable {
    void addVote(Vote vote);
    int getScore();
    void removeVote(Vote vote);

}
