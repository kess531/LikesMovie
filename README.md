
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
    <li>
      <a href="#실행-방법">실행 방법</a>
      <ul>
        <li><a href="#코드-에디터">코드 에디터</a></li>

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
## 실행 방법

프로젝트를 로컬저장소에 다운받아 설정하는 방법에 대한 지침을 제공하는 방법입니다.
프로젝트를 실행하려면 다음 단계들을 따라해주세요.

### 코드 에디터

프로젝트를 실행시키기 위해 필요한 소프트웨어 및 설치방법을 알려주는 예시입니다.

1. Eclipse 를 설치합니다. 이 프로젝트는 Eclipse 2019년 12월 버전을 사용하였습니다. 2019년 12월 이후의 버전을 사용하기를 권고드립니다.
Eclipse https://www.eclipse.org/
  

### 설치


1. Tomcat Server 8.5버젼을 설치합니다.
2. repo를 Clone 합니다.
 ```sh
   git clone https://github.com/your_username_/Project-Name.git
   ```
3. Clone한 파일을 본인의 Eclipse-Workspace에 넣습니다.
4. Eclipse 실행 후 프로젝트 파일을 Import합니다.
5. Window -> Prefernces -> Server -> Runtime Environments ->Add
   에서 Tomcat 8.5를 추가해줍니다.
6.  Servers 안에있는 web.xml
   
   
 ```
   ApiKey=" API 키를 넣어주세요 "
   ```

<!-- USAGE EXAMPLES -->
## 사용법

프로젝트 사용법을 나타낸 항목입니다.

1. Youtube-Crawler 폴더 안의 Like_Youtube.sln을 실행해 주세요.
2. 본인의 API Key로 바꾸어 입력해주세요.
```
   ApiKey=" API 키를 넣어주세요 "
   ```
3. 실행하시면 로고 창이 나오면서 1초 후 메인 폼으로 이동합니다.
4. 텍스트 창에 검색어 입력 후 필터를 설정하여 검색 버튼을 눌러주세요.
5. 리스트 박스에 검색된 리소스들이 나옵니다.
* 검색된 리소스를 좌클릭 하면 우측 창에 썸네일과 관련 정보들이 나오고 우클릭하면 미리보기 창이 나오며 더블클릭 시 사용자의 디폴트 브라우저로 해당 리소스 페이지를 띄워줍니다.

6. 메인 폼의 종료 버튼을 눌러도 꺼지지 않고 우측 밑 NotifyIcon으로 남습니다. 
7. NotifyIcon 좌클릭 시 모달 창이 나오며 썸네일 폴더 및 도움말을 볼 수 있습니다.
8. 종료 하고 싶으시면 NotifyIcon을 우클릭 후 종료 버튼을 눌러주세요.





## Contact

kyungwan Yu - ukwan531@gmail.com

Github Address : [https://github.com/kess531/MovieLikes](https://github.com/kess531)


