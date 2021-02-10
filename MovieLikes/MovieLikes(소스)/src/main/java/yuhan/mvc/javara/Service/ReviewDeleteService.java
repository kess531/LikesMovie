package yuhan.mvc.javara.Service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.mvc.javara.Dao.ReviewDao;
import yuhan.mvc.javara.reviewDto.ReviewDto;

public class ReviewDeleteService implements IService {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object>map=model.asMap();// 모델 객체를 맵 형태로 변환해서 맵에다 모델의 데이터를 다 집어 넣는다
		
		HttpServletRequest request = (HttpServletRequest) map.get("request"); //맵에들어가있는 키와 밸류
		String review_no=request.getParameter("review_no");
		String user_pwd=request.getParameter("user_pwd1");
		System.out.println(user_pwd);
		ReviewDao dao = new ReviewDao();
		ArrayList<ReviewDto> dto = dao.review2(review_no);
		String pck =dao.pwdcheck(review_no);
		System.out.println(pck);
		if(pck.equals(user_pwd))
		{
			System.out.println("내용이 같습니다.");
		dao.delete(review_no);	
		}
		else
		{
			System.out.println("다릅니다");
			
		}
		model.addAttribute("review",dto);
	}
}

