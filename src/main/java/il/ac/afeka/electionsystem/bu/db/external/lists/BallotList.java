package il.ac.afeka.electionsystem.bu.db.external.lists;

import il.ac.afeka.electionsystem.bu.db.external.objects.Ballot;
import il.ac.afeka.electionsystem.bu.db.internal.DB;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BallotList {

	private static Map<Long, Ballot> ballotList;
	private static BallotList instance;
	
	public static BallotList getInstance() {
		if (instance == null) {
			instance = new BallotList();
		}
		return instance;
	}
	
	private BallotList() {
		Collection<Ballot> list = DB.getInstance().getBallots();
		ballotList = new HashMap<>();
		for (Ballot element: list) {
			ballotList.put(element.getId(), element);
		}
	}
	
	public Ballot getBallot(long id) {
		return ballotList.get(id);
	}
	
	public void updateBallotList(Ballot b) {
		if (! ballotList.containsKey(b.getId())) {
			ballotList.put(b.getId(), b);
			DB.getInstance().saveBallots(ballotList.values());
		}
	}
}
