package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class GreatestSportsMoment {
	int id;
	String sporting_moment;
	String moment_description;
	String moment_year;
	String team_or_individual_name_outstanding;
	int moment_rating;
	
	public GreatestSportsMoment() {
		
	}
	
	

	public GreatestSportsMoment(int id, String sporting_moment, String moment_description, String moment_year,
			String team_or_individual_name_outstanding, int moment_rating) {
		super();
		this.id = id;
		this.sporting_moment = sporting_moment;
		this.moment_description = moment_description;
		this.moment_year = moment_year;
		this.team_or_individual_name_outstanding = team_or_individual_name_outstanding;
		this.moment_rating = moment_rating;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSporting_moment() {
		return sporting_moment;
	}

	public void setSporting_moment(String sporting_moment) {
		this.sporting_moment = sporting_moment;
	}

	public String getMoment_description() {
		return moment_description;
	}

	public void setMoment_description(String moment_description) {
		this.moment_description = moment_description;
	}

	public String getMoment_year() {
		return moment_year;
	}

	public void setMoment_year(String moment_year) {
		this.moment_year = moment_year;
	}

	public String getTeam_or_individual_name_outstanding() {
		return team_or_individual_name_outstanding;
	}

	public void setTeam_or_individual_name_outstanding(String team_or_individual_name_outstanding) {
		this.team_or_individual_name_outstanding = team_or_individual_name_outstanding;
	}

	public int getMoment_rating() {
		return moment_rating;
	}

	public void setMoment_rating(int moment_rating) {
		this.moment_rating = moment_rating;
	}

	
	

}
