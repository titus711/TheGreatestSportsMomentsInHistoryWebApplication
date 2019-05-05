package beans;

import java.util.ArrayList;

public class GreatestSportsMoments {
	
	ArrayList<GreatestSportsMoment> theMoments = new ArrayList<GreatestSportsMoment>();
	
	public void add(GreatestSportsMoment bt){
		theMoments.add(bt);
	}
	
	
	public void printAll() {
		System.out.println("=========These are a few of my greatest sports moments in history========" );
	
		for(GreatestSportsMoment moment :theMoments) {
			 System.out.println("ID = " + moment.id + " sporting_moment = " + moment.sporting_moment + " moment_description = " + moment.moment_description + " moment_year = " + moment.moment_year + " team_or_individual_name_outstanding = " + moment.team_or_individual_name_outstanding + " moment_rating = " + moment.moment_rating);
		}
		System.out.println("=========End of the list========" );

	}
}
