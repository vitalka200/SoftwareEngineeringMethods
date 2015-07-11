package il.ac.afeka.electionsystem.ui;

import il.ac.afeka.electionsystem.bu.db.external.lists.BallotList;
import il.ac.afeka.electionsystem.bu.db.external.lists.PartyList;
import il.ac.afeka.electionsystem.bu.db.external.objects.Ballot;
import il.ac.afeka.electionsystem.bu.db.external.objects.Citizen;
import il.ac.afeka.electionsystem.bu.db.external.objects.Party;
import il.ac.afeka.electionsystem.bu.election.Election;
import il.ac.afeka.electionsystem.bu.election.ElectionImpl;
import il.ac.afeka.electionsystem.bu.electorslist.ElectorsList;
import il.ac.afeka.electionsystem.bu.electorslist.ElectorsListImpl;
import il.ac.afeka.electionsystem.bu.exceptions.AuthenticationException;
import il.ac.afeka.electionsystem.bu.exceptions.AuthorizationException;
import il.ac.afeka.electionsystem.bu.exceptions.PartyNotExistException;
import il.ac.afeka.electionsystem.bu.voting.Voting;
import il.ac.afeka.electionsystem.bu.voting.VotingImpl;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;



public class UI {
	private Scanner scaner;
	private ElectorsList electorsList;
	private Voting votingSystem;
	private Election election;
	
	public UI() {
		prepareSystem();
	}
	
	
	public void startUI() {
		// Start Main Menu
		mainMenu();
	}

	private void mainMenu() {
		boolean menuFlag = true;
		while(menuFlag) {
			System.out.println("\n\n\n\n");
			System.out.println("1. Voting.");
			System.out.println("2. Statistics.");
			System.out.println("3. Exit.\n");
			System.out.print("Please choose option: ");
			switch (scaner.nextLine()) {
				case "1":
					votingMenu();
					break;
				case "2":
					statisticsMenu();
					break;
				case "3":
					System.out.println("System Exiting...");
					menuFlag = false;
					break;
				default:
					System.out.println("No such option.");
					break;
			}
		}
	}
	
	private String getAnswer() {
		return scaner.nextLine();
	}
	
	private void votingMenu() {
		String answer;
		System.out.print("Please enter your ID: ");
		answer = getAnswer();
		try {
			long citizenId = Long.parseLong(answer);
			try {
				electorsList.AuthenticateCitizen(citizenId);
				Citizen citizen = electorsList.getCitizen(citizenId);
				System.out.println("Welcome " + citizen.getLastName() + ", " + citizen.getFirstName());
				
				electorsList.AuthorizeCitizen(citizenId, citizen.getBallotId());
				Ballot ballot = BallotList.getInstance().getBallot(citizen.getBallotId());
				System.out.print("You voting in Ballot #" + ballot.getId());
				System.out.println(" Ballot name: " + ballot.getName() + "\n\n");
				
				printPartyList();
				answer = getAnswer();
				long partyId = Long.parseLong(answer);
				
				votingSystem.vote(citizenId, ballot.getId(), partyId);
				System.out.println("Thank you for your vote!");
			} catch (AuthenticationException e) {
				System.out.println(e.getMessage());
			} catch (AuthorizationException e) {
				System.out.println(e.getMessage());
			}  catch (PartyNotExistException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Party ID should be a number.");
			}
			
		} catch (NumberFormatException e) {
			System.out.println("ID should be a number.");
		}
	}
	
	private void printPartyList() {
		for (Party p : PartyList.getInstance().getPartyList()) {
			System.out.print("Party id: " + p.getId());
			System.out.println(" name: " + p.getName());
		}
		System.out.print("Please choose a party: ");
	}
	
	private void statisticsMenu() {
		boolean menuFlag = true;
		String answer;
		while (menuFlag) {
			System.out.println("1. Show votes per ballot.");
			System.out.println("2. Show votes per party.");
			System.out.println("3. Show votes per party per ballot.");
			System.out.println("4. Exit");
			System.out.print("Please choose option: ");
			answer = getAnswer();
			
			switch (answer) {
				case "1" :
					printVotesPerBallot();
					break;
				case "2" : 
					printVotesPerParty();
					break;
				case "3" :
					printVotesPerPartyPerBallot();
					break;
				case "4" :
					menuFlag = false;
					break;
				default:
					System.out.println("No such option.");
					break;
			}
		}
	}
	
	private void printVotesPerBallot() {
		Map<Ballot, Long> map = election.getVotesPerBallot();
		for (Entry<Ballot, Long> entry: map.entrySet()) {
			System.out.print("Ballot #" + entry.getKey().getId());
			System.out.println(" votes: " + entry.getValue());
		}
		System.out.println("Done printing votes per ballot.");
	}
	private void printVotesPerParty() {
		Map<Party, Long> map = election.getVotesPerParty();
		for (Entry<Party, Long> entry: map.entrySet()) {
			System.out.print("Party name: " + entry.getKey().getName());
			System.out.println(" votes: " + entry.getValue());
		}
		System.out.println("Done printing votes per party.");
	}
	
	private void printVotesPerPartyPerBallot() {
		Map<Party, Map<Ballot, Long>> map = election.getVotesPerPartyPerBallot();
		for (Entry<Party, Map<Ballot, Long>> entry: map.entrySet()) {
			System.out.println("Party name: " + entry.getKey().getName());
			Map<Ballot, Long> m = entry.getValue();
			System.out.println("Votes per ballot.");
			for (Entry<Ballot, Long> e : m.entrySet()) {
				System.out.print("Ballot #" + e.getKey());
				System.out.println(" votes: " + e.getValue());
			}
		}
		System.out.println("Done printing votes per party per ballot.");
	}
	
	private void prepareSystem() {
		scaner = new Scanner(System.in);
		electorsList = ElectorsListImpl.getInstance();
		votingSystem = VotingImpl.getInstance();
		election     = ElectionImpl.getInstance();
	}
	
}
