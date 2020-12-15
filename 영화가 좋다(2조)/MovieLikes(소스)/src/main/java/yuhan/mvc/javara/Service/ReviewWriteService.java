package yuhan.mvc.javara.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.mvc.javara.Dao.ReviewDao;



public class ReviewWriteService implements IService {

	@Override
	public void execute(Model model) {
	Map<String, Object>map=model.asMap();// 모델 객체를 맵 형태로 변환해서 맵에다 모델의 데이터를 다 집어 넣는다
		
		HttpServletRequest request = (HttpServletRequest) map.get("request"); //맵에들어가있는 키와 밸류
		
	
		String user_id=request.getParameter("user_id");
		String user_pwd=request.getParameter("user_pwd");
		String review_content=request.getParameter("review_content");
		String review_star=request.getParameter("review_star");
		String movie_no=request.getParameter("movie_no");
		
		ReviewDao dao = new ReviewDao();
		dao.write(user_id, user_pwd, review_content, review_star, movie_no);
		
	}

}
