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
		Map<String, Object>map=model.asMap();// �� ��ü�� �� ���·� ��ȯ�ؼ� �ʿ��� ���� �����͸� �� ���� �ִ´�
		
		HttpServletRequest request = (HttpServletRequest) map.get("request"); //�ʿ����ִ� Ű�� ���
		
		String movie_no=request.getParameter("movie_no"); //����� jsp�κ� �̶� �������

		
		MovieDao dao = new MovieDao();
		MovieDto dto = dao.Contentview(movie_no);
		
		model.addAttribute("Contentview",dto);


	}

}
