package yuhan.mvc.javara.Service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


import yuhan.mvc.javara.Dao.ReviewDao;

import yuhan.mvc.javara.reviewDto.ReviewDto;

public class ReviewListService implements IService {

	
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
	Map<String, Object>map=model.asMap();// 모델 객체를 맵 형태로 변환해서 맵에다 모델의 데이터를 다 집어 넣는다
		
		HttpServletRequest request = (HttpServletRequest) map.get("request"); //맵에들어가있는 키와 밸류
		
		String movie_no=request.getParameter("movie_no");


		
		ReviewDao dao = new ReviewDao();
		ArrayList<ReviewDto>dtos = dao.review(movie_no);
		model.addAttribute("review",dtos);
		
		double avg_star = dao.getStar(movie_no);
		model.addAttribute("avg_star", avg_star);
	}

}
