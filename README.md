
<details open="open">
  <summary>목차</summary>
  <ol>
    <li>
      <a href="#프로젝트">프로젝트</a>
      <ul>
        <li><a href="#사용-기술">사용 기술</a></li>
      </ul>
    </li>
 <li><a href="#핵심-코드">핵심코드</a></li>

    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## 프로젝트


* Spring 기반 영화 리뷰사이트를 개발해 봄으로써 학습하였습니다.


### 메인화면

### 영화리스트

### 영화정보 및 리뷰



### 사용 기술

프로젝트를 제작하는 데 사용된 주요 모듈을 기술하는 부분입니다. 언어, 프레임워크, API 등을 포함합니다.

* [Java(SpringFramework)](https://spring.io/projects/spring-framework)
* [Tomcat](http://tomcat.apache.org/)
* [Oracle DB](https://www.oracle.com/database/)
<!-- CODE -->
## 핵심 코드



### 

### MoviceDao.java


 
 ```sh
 // 영화 리스트 
	public ArrayList<MovieListDto> Movielist(String col) {
		ArrayList<MovieListDto>dtos=new ArrayList<MovieListDto>();
		Connection connection = null;
		//sql문을 데이터베이스로 보내기 위해 프리스테이먼트문 선언
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		
		
		try {
			 connection = dataSource.getConnection(); //connection객체 생성
			
			if (col.equals("none")) {
				 String query = "select movie_no,movie_title from mr_movie";
				 preparedStatement = connection.prepareStatement(query);//스테이트먼트 객체 생성
			}
			
			else {
				 String query = "select movie_no,movie_title from mr_movie where movie_genre Like ? ";  //장르 
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
	
   ```

<!-- GETTING STARTED -->

### 코드 에디터

프로젝트를 실행시키기 위해 필요한 소프트웨어 및 설치방법을 알려주는 예시입니다.

1. Eclipse 를 설치합니다. 이 프로젝트는 Eclipse 2019년 12월 버전을 사용하였습니다. 2019년 12월 이후의 버전을 사용하기를 권고드립니다.
Eclipse https://www.eclipse.org/
  




## Contact

kyungwan Yu - ukwan531@gmail.com

Github Address : [https://github.com/kess531/MovieLikes](https://github.com/kess531)


