package yuhan.mvc.javara.reviewDto;

public class MovieDto {

	
	private int movie_no;
	private String movie_title;
	private String movie_date_y;
	private String movie_date_m;
	private String movie_date_d;
	private String movie_directors;
	private String movie_actor;
	private String movie_genre;
	private String movie_content;
	private String movie_length;
	private String movie_grade;
	private String movie_url;
	

	public MovieDto(int movie_no, String movie_title, String movie_date_y, String movie_date_m, String movie_date_d,
			String movie_directors, String movie_actor, String movie_genre, String movie_content, String movie_length,
			String movie_grade, String movie_url) {
	
		this.movie_no = movie_no;
		this.movie_title = movie_title;
		this.movie_date_y = movie_date_y;
		this.movie_date_m = movie_date_m;
		this.movie_date_d = movie_date_d;
		this.movie_directors = movie_directors;
		this.movie_actor = movie_actor;
		this.movie_genre = movie_genre;
		this.movie_content = movie_content;
		this.movie_length = movie_length;
		this.movie_grade = movie_grade;
		this.movie_url = movie_url;
	}


	public int getMovie_no() {
		return movie_no;
	}


	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}


	public String getMovie_title() {
		return movie_title;
	}


	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}


	public String getMovie_date_y() {
		return movie_date_y;
	}


	public void setMovie_date_y(String movie_date_y) {
		this.movie_date_y = movie_date_y;
	}


	public String getMovie_date_m() {
		return movie_date_m;
	}


	public void setMovie_date_m(String movie_date_m) {
		this.movie_date_m = movie_date_m;
	}


	public String getMovie_date_d() {
		return movie_date_d;
	}


	public void setMovie_date_d(String movie_date_d) {
		this.movie_date_d = movie_date_d;
	}


	public String getMovie_directors() {
		return movie_directors;
	}


	public void setMovie_directors(String movie_directors) {
		this.movie_directors = movie_directors;
	}


	public String getMovie_actor() {
		return movie_actor;
	}


	public void setMovie_actor(String movie_actor) {
		this.movie_actor = movie_actor;
	}


	public String getMovie_genre() {
		return movie_genre;
	}


	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}


	public String getMovie_content() {
		return movie_content;
	}


	public void setMovie_content(String movie_content) {
		this.movie_content = movie_content;
	}


	public String getMovie_length() {
		return movie_length;
	}


	public void setMovie_length(String movie_length) {
		this.movie_length = movie_length;
	}


	public String getMovie_grade() {
		return movie_grade;
	}


	public void setMovie_grade(String movie_grade) {
		this.movie_grade = movie_grade;
	}


	public String getMovie_url() {
		return movie_url;
	}


	public void setMovie_url(String movie_url) {
		this.movie_url = movie_url;
	}
	

}
