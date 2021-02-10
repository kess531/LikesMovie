package yuhan.mvc.javara.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.mvc.javara.Dao.ReviewDao;



public class ReviewWriteService implements IService {

	@Override
	public void execute(Model model) {
	Map<String, Object>map=model.asMap();// �� ��ü�� �� ���·� ��ȯ�ؼ� �ʿ��� ���� �����͸� �� ���� �ִ´�
		
		HttpServletRequest request = (HttpServletRequest) map.get("request"); //�ʿ����ִ� Ű�� ���
		
	
		String user_id=request.getParameter("user_id");
		String user_pwd=request.getParameter("user_pwd");
		String review_content=request.getParameter("review_content");
		String review_star=request.getParameter("review_star");
		String movie_no=request.getParameter("movie_no");
		
		ReviewDao dao = new ReviewDao();
		dao.write(user_id, user_pwd, review_content, review_star, movie_no);
		
	}

}
