package yuhan.mvc.javara.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import yuhan.mvc.javara.reviewDto.MovieDto;
import yuhan.mvc.javara.reviewDto.MovieListDto;
import yuhan.mvc.javara.reviewDto.ReviewDto;

public class MovieDao {
	DataSource dataSource;
	
	public MovieDao()
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
	
	public ArrayList<MovieListDto> Movielist(String col) {
		ArrayList<MovieListDto>dtos=new ArrayList<MovieListDto>();
		Connection connection = null;
		//sql문을 데이터베이스로보내기위해 프리스테이먼트문 선언
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		
		
		try {
			 connection = dataSource.getConnection(); //connection객체 생성
			
			if (col.equals("none")) {
				 String query = "select movie_no,movie_title from mr_movie";
				 preparedStatement = connection.prepareStatement(query);//스테이트먼트 객체 생성
			}
			
			else {
				 String query = "select movie_no,movie_title from mr_movie where movie_genre Like ? ";
				 preparedStatement = connection.prepareStatement(query);//스테이트먼트 객체 생성
				 preparedStatement.setString(1, col);
			}
			
			 resultSet= preparedStatement.executeQuery();
			 
			 while (resultSet.next()) {
				int movie_no = resultSet.getInt("movie_no");
				String movie_title = resultSet.getNString("movie_title");
				MovieListDto dto =new MovieListDto(movie_no, movie_title);
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
	
	
	public MovieDto Contentview(String movie_no) {
		// TODO Auto-generated method stub
		MovieDto dto = null;
		Connection connection =null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet= null;
		
		try {
			connection=dataSource.getConnection();
			String query= "select * from mr_movie where movie_no = ?";
			
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(movie_no));
			
			resultSet= preparedStatement.executeQuery();

		
			 if(resultSet.next()) {
				
				 int Movie_no = resultSet.getInt("MOVIE_NO");
					String movie_title = resultSet.getNString("MOVIE_TITLE");
					String movie_date_y= resultSet.getNString("MOVIE_DATE_Y");
					String movie_date_m= resultSet.getNString("MOVIE_DATE_M");
					String movie_date_d= resultSet.getNString("MOVIE_DATE_D");
					String movie_directors= resultSet.getNString("MOVIE_DIRECTORS");
					String movie_actor= resultSet.getNString("MOVIE_ACTOR");
					String movie_genre= resultSet.getNString("MOVIE_GENRE");
					String movie_content= resultSet.getNString("MOVIE_CONTENT");
					String movie_length= resultSet.getNString("MOIVE_LENGTH");
					String movie_grade= resultSet.getNString("MOVIE_GRADE");
					String movie_url= resultSet.getNString("MOVIE_URL");
					
				 dto=new MovieDto(Movie_no, movie_title, movie_date_y, movie_date_m, movie_date_d, movie_directors, movie_actor, movie_genre, movie_content, movie_length, movie_grade, movie_url);
			 }
		
			 
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e);
			
		}
		finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection !=null) connection.close();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		
		
	}
		return dto;
	
}
	
	
	public int getCount(String col) {
		int Count = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		
		try {
			 connection = dataSource.getConnection(); //connection객체 생성
			 String query;
			 if(col.equals("none")) {
				 query = "select count(*) from mr_movie";
				 preparedStatement = connection.prepareStatement(query);
			 }
			 else {
				 query = "select count(*) from mr_movie where movie_genre Like ?";
				 preparedStatement = connection.prepareStatement(query);
				 preparedStatement.setString(1, col);
			 }
			 
			 resultSet= preparedStatement.executeQuery();
			 
			 while (resultSet.next()) {
				Count = resultSet.getInt(1);
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
		System.out.println(Count);
		return Count;
	}
}
