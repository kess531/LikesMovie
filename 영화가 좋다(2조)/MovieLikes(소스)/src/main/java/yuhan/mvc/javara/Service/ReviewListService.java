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
		
	Map<String, Object>map=model.asMap();// �� ��ü�� �� ���·� ��ȯ�ؼ� �ʿ��� ���� �����͸� �� ���� �ִ´�
		
		HttpServletRequest request = (HttpServletRequest) map.get("request"); //�ʿ����ִ� Ű�� ���
		
		String movie_no=request.getParameter("movie_no");


		
		ReviewDao dao = new ReviewDao();
		ArrayList<ReviewDto>dtos = dao.review(movie_no);
		model.addAttribute("review",dtos);
		
		double avg_star = dao.getStar(movie_no);
		model.addAttribute("avg_star", avg_star);
	}

}
