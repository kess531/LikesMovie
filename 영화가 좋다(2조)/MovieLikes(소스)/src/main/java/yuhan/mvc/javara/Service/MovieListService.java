package yuhan.mvc.javara.Service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.mvc.javara.Dao.MovieDao;

import yuhan.mvc.javara.reviewDto.MovieListDto;


public class MovieListService implements IService {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object>map=model.asMap();// 모델 객체를 맵 형태로 변환해서 맵에다 모델의 데이터를 다 집어 넣는다
		HttpServletRequest request = (HttpServletRequest) map.get("request"); //맵에들어가있는 키와 밸류
		String col = (request.getParameter("col"));
		if(col==null)
		{
			col="none"; //(request.getParameter("col"))가 null 일경우 Null Pointer Exception 방지를 위한 if문
		}

		MovieDao dao = new MovieDao();
		System.out.println(col);
		ArrayList<MovieListDto>dtos = dao.Movielist(col);
		
		model.addAttribute("movie",dtos);
		
	}

}
