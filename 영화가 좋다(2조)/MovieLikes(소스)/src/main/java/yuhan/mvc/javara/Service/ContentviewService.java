package yuhan.mvc.javara.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


import yuhan.mvc.javara.Dao.MovieDao;
import yuhan.mvc.javara.reviewDto.MovieDto;


public class ContentviewService implements IService {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object>map=model.asMap();// 모델 객체를 맵 형태로 변환해서 맵에다 모델의 데이터를 다 집어 넣는다
		
		HttpServletRequest request = (HttpServletRequest) map.get("request"); //맵에들어가있는 키와 밸류
		
		String movie_no=request.getParameter("movie_no"); //여기랑 jsp부분 이랑 맞춰야함

		
		MovieDao dao = new MovieDao();
		MovieDto dto = dao.Contentview(movie_no);
		
		model.addAttribute("Contentview",dto);


	}

}
