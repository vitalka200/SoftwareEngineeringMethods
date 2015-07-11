package il.ac.afeka.electionsystem;

import il.ac.afeka.electionsystem.bu.db.external.objects.Address;
import il.ac.afeka.electionsystem.bu.db.external.objects.Ballot;
import il.ac.afeka.electionsystem.bu.db.external.objects.Citizen;
import il.ac.afeka.electionsystem.bu.db.external.objects.Party;
import il.ac.afeka.electionsystem.bu.db.internal.DB;
import il.ac.afeka.electionsystem.ui.UI;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class App {

	
	public static void main(String[] args) {
		fillTestData();
		UI ui = new UI();
		ui.startUI();
	}
	
	private static void fillTestData() {
		// For filling data we'll use direct DB access
		// It will be much quicker
		createBallots();
		createParties();
		createCitizens();
		createVotersDB();
		createSlipsDB();
		System.out.println("System is ready!!!");
	}
	
	private static void createBallots() {
		System.out.print("Generating Ballots...");
		List<Ballot> list = new LinkedList<>();
		for (long i = 1; i < 10000; i++) {
			list.add(new Ballot(i, "Some Ballot Name #" + i, 
					new Address("GenericTown #" + ((i % 500) + 1),
							"GenericStreet #" + i, (int)((i % 200)+1))));
		}
		DB.getInstance().saveBallots(list);
		System.out.println("Done.");
	}
	
	private static void createParties() {
		System.out.print("Generating Parties...");
		List<Party> list = new LinkedList<>();
		for (long i = 1; i < 15; i++) {
			list.add(new Party(i, "SomeParty # "+ i));
		}
		DB.getInstance().saveParties(list);
		System.out.println("Done.");
	}
	
	private static void createCitizens() {
		System.out.print("Generating Citizens...");
		List<Citizen> list = new LinkedList<>();
		for (long i = 1; i < 500000; i++) {
			list.add(new Citizen(i, "GenericFName #" + i, "GenericLName #" + i,
					new Address("GenericTown #" + ((i % 500) + 1),
							"GenericStreet #" + i, (int)((i % 200)+1)),
					(50*Math.random()+17), (int)(495*Math.random()+2)));
		}
		DB.getInstance().saveCitizens(list);
		System.out.println("Done.");
	}
	
	private static void createVotersDB() {
		try {
			File f = new File("voters.db");
			if (!f.exists()) {
				PrintWriter writer = new PrintWriter(f);
				writer.write("[]");
				writer.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void createSlipsDB() {
		try {
			File f = new File("slips.db");
			if (!f.exists()) {
				PrintWriter writer = new PrintWriter(f);
				writer.write("[]");
				writer.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
