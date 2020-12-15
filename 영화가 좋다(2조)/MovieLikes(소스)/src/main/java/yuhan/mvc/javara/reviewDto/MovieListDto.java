package yuhan.mvc.javara.reviewDto;

public class MovieListDto {

	private int Movie_no;
	private String Movie_title;

	public MovieListDto(int movie_no, String movie_title) {
	
		Movie_no = movie_no;
		Movie_title = movie_title;
	}
	public int getMovie_no() {
		return Movie_no;
	}
	public void setMovie_no(int movie_no) {
		Movie_no = movie_no;
	}
	public String getMovie_title() {
		return Movie_title;
	}
	public void setMovie_title(String movie_title) {
		Movie_title = movie_title;
	} 
	
	
	
}
