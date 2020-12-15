package yuhan.mvc.javara.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import yuhan.mvc.javara.reviewDto.MovieListDto;
import yuhan.mvc.javara.reviewDto.ReviewDto;



public class ReviewDao {

	
	DataSource dataSource;
	
	public ReviewDao()
	{
		try {
			Context context = new InitialContext();
			
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/orcl");
			System.out.println("db정상연결");
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("db연결실패");
		}
	}
	
	public ArrayList<ReviewDto> review(String movieno) {
		ArrayList<ReviewDto>dtos=new ArrayList<ReviewDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
	
		try {
			
			 connection = dataSource.getConnection(); //connection객체 생성
			 String query = "select * from mr_review where movie_no = ?  order by review_no desc";
			 
			 preparedStatement = connection.prepareStatement(query);//스테이트먼트 객체 생성
			 preparedStatement.setInt(1, Integer.parseInt(movieno));
			 resultSet= preparedStatement.executeQuery();
			 
			 while (resultSet.next()) {
				int review_no = resultSet.getInt("review_no");
				String review_content = resultSet.getNString("review_content");
				String review_star = resultSet.getNString("review_star");
				String user_id = resultSet.getNString("user_id");
				String user_pwd = resultSet.getNString("user_pwd");
				Timestamp review_date = resultSet.getTimestamp("review_date");
				int movie_no = resultSet.getInt("movie_no");
				
				
				ReviewDto dto =new ReviewDto(review_no, review_content, review_star, review_date, user_id, user_pwd, movie_no);
				dtos.add(dto);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection !=null) connection.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return dtos;
	}
	
	public void write(String User_id,String user_pwd, String review_content, String review_star, String movie_no) {
		Connection connection= null; 
		PreparedStatement preparedStatement= null;
		
		
		try {
			connection= dataSource.getConnection();
			String query="insert into mr_review(review_no,user_id, user_pwd, review_content, review_star,movie_no) values(MR_REVIEW_SEQ.nextval,? ,?, ?,? ,?)";
			preparedStatement = connection.prepareStatement(query);//스테이트먼트 객체 생성
			preparedStatement.setString(1, User_id);
			preparedStatement.setString(2, user_pwd);
			preparedStatement.setString(3, review_content);
			preparedStatement.setString(4, review_star);
			preparedStatement.setInt(5, Integer.parseInt(movie_no));
			
			int rn = preparedStatement.executeUpdate();
			System.out.println(User_id +user_pwd + review_content + review_star + movie_no);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			System.out.println(User_id +user_pwd + review_content + review_star + movie_no);
		}
		finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection !=null) connection.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public double getStar(String movie_no) {

		double star = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		
		try {
			 connection = dataSource.getConnection(); //connection객체 생성
			 String query = "select round(avg(review_star)) from mr_review where movie_no = ?";
			 preparedStatement = connection.prepareStatement(query);//스테이트먼트 객체 생성
			 preparedStatement.setString(1, movie_no);
			 resultSet= preparedStatement.executeQuery();
			 
			 while (resultSet.next()) {
				 star = resultSet.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection !=null) connection.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return star;
	}
	public void delete(String review_no) {
		Connection connection= null; 
		PreparedStatement preparedStatement= null;
		
		try {
			connection= dataSource.getConnection();
			String query="delete from mr_review  where review_no=?";
			 preparedStatement = connection.prepareStatement(query);//스테이트먼트 객체 생성
				preparedStatement.setInt(1, Integer.parseInt(review_no));
			
				int rn = preparedStatement.executeUpdate();
						
						
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection !=null) connection.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

}
	public String pwdcheck(String reviewno) {
		String pass="";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
	
		try {
			
			 connection = dataSource.getConnection(); //connection객체 생성
			 String query = "select user_pwd, movie_no from mr_review where review_no = ?";
			 
			 preparedStatement = connection.prepareStatement(query);//스테이트먼트 객체 생성
			 preparedStatement.setInt(1, Integer.parseInt(reviewno));
		
			 resultSet= preparedStatement.executeQuery();
			 
			 while (resultSet.next()) {
		pass=resultSet.getNString(1);
	
		
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection !=null) connection.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return pass;
	}
	public ArrayList<ReviewDto> review2(String reviewno) {
		ArrayList<ReviewDto>dtos=new ArrayList<ReviewDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
	
		try {
			
			 connection = dataSource.getConnection(); //connection객체 생성
			 String query = "select * from mr_review where review_no = ?  order by review_no desc";
			 
			 preparedStatement = connection.prepareStatement(query);//스테이트먼트 객체 생성
			 preparedStatement.setInt(1, Integer.parseInt(reviewno));
			 resultSet= preparedStatement.executeQuery();
			 
			 while (resultSet.next()) {
				int review_no = resultSet.getInt("review_no");
				String review_content = resultSet.getNString("review_content");
				String review_star = resultSet.getNString("review_star");
				String user_id = resultSet.getNString("user_id");
				String user_pwd = resultSet.getNString("user_pwd");
				Timestamp review_date = resultSet.getTimestamp("review_date");
				int movie_no = resultSet.getInt("movie_no");
				
				
				ReviewDto dto =new ReviewDto(review_no, review_content, review_star, review_date, user_id, user_pwd, movie_no);
				dtos.add(dto);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection !=null) connection.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return dtos;
	}
	
}
