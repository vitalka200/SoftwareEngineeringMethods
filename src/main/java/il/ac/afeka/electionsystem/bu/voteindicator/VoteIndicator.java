package il.ac.afeka.electionsystem.bu.voteindicator;

public interface VoteIndicator {
	public boolean isVoted(long voterId);
	public void setVoted(long voterId);
}
