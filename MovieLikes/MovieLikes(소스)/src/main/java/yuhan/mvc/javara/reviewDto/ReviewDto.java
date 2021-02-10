package yuhan.mvc.javara.reviewDto;

import java.sql.Timestamp;

public class ReviewDto {

	private int review_no;
	private String review_content;
	private String review_star;
	Timestamp review_date;
	private String user_id;
	private String user_pwd;
	private int movie_no;
	public ReviewDto(int review_no, String review_content, String review_star, Timestamp review_date, String user_id,
			String user_pwd, int movie_no) {
		
		this.review_no = review_no;
		this.review_content = review_content;
		this.review_star = review_star;
		this.review_date = review_date;
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.movie_no = movie_no;
	}

	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public String getReview_star() {
		return review_star;
	}
	public void setReview_star(String review_star) {
		this.review_star = review_star;
	}
	public Timestamp getReview_date() {
		return review_date;
	}
	public void setReview_date(Timestamp review_date) {
		this.review_date = review_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public int getMovie_no() {
		return movie_no;
	}
	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}
	
	
	
	
}
