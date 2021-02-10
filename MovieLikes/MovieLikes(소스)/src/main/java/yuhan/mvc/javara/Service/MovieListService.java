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
		Map<String, Object>map=model.asMap();// �� ��ü�� �� ���·� ��ȯ�ؼ� �ʿ��� ���� �����͸� �� ���� �ִ´�
		HttpServletRequest request = (HttpServletRequest) map.get("request"); //�ʿ����ִ� Ű�� ���
		String col = (request.getParameter("col"));
		if(col==null)
		{
			col="none"; //(request.getParameter("col"))�� null �ϰ�� Null Pointer Exception ������ ���� if��
		}

		MovieDao dao = new MovieDao();
		System.out.println(col);
		ArrayList<MovieListDto>dtos = dao.Movielist(col);
		
		model.addAttribute("movie",dtos);
		
	}

}
