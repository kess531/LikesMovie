package yuhan.mvc.javara.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import yuhan.mvc.javara.Service.ContentviewService;
import yuhan.mvc.javara.Service.IService;
import yuhan.mvc.javara.Service.IndexService;
import yuhan.mvc.javara.Service.MovieListService;
import yuhan.mvc.javara.Service.ReviewDeleteService;
import yuhan.mvc.javara.Service.ReviewListService;
import yuhan.mvc.javara.Service.ReviewWriteService;
import yuhan.mvc.javara.util.Paging;

@Controller
public class UserController {
	IService service;
	Paging paging;
	
	@RequestMapping("/home")
	public String home(Model model) {
		service = new IndexService();
		return "home";
	}
	
	
	@RequestMapping(value="/review")
	public String review(HttpServletRequest request, Model model)
	{
		System.out.println("--리뷰 불러오기 완료--");
		service = new ReviewListService();
		service.execute(model);
		return "Contentview";
	}
	
	
	@RequestMapping(value="/movie",  method = RequestMethod.GET)
	public String movie(@RequestParam(value="page", required = false, defaultValue = "1") int page, 
						@RequestParam(value="col", required = false, defaultValue = "none") String col,
						HttpServletRequest request, Model model)
	{
		System.out.println("--영화 정보 불러오기 완료--");
		model.addAttribute("request",request);
		
		paging = new Paging();
		paging.makeBlock(page);
		paging.makeLastPageNum(col);
		model.addAttribute("blockStartNum", paging.getBlockStartNum());
		model.addAttribute("blockLastNum", paging.getBlockLastNum());
		model.addAttribute("lastPageNum", paging.getLastPageNum());
		
		model.addAttribute("col", col);
		model.addAttribute("curPageNum", page);
		service = new MovieListService();
		service.execute(model);
		System.out.println(page);
		System.out.println(col);
		System.out.println(paging.getBlockStartNum());
		System.out.println(paging.getBlockLastNum());
		System.out.println(paging.getLastPageNum());
		return "movie";
	}
	
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String write(HttpServletRequest request, Model model)
	{
		model.addAttribute("request",request);
		service = new ReviewWriteService();
		service.execute(model);
		System.out.println("--리뷰작성 완료--");
		service = new ReviewListService();
		service.execute(model);
		service = new ContentviewService();
		service.execute(model);
		return "Contentview";
				
	}
	
	
	@RequestMapping(value="/Contentview")
	public String Contentview(HttpServletRequest request, Model model)
	{
		System.out.println("--Contentview()--");
		model.addAttribute("request",request);
		service = new ReviewListService();
		service.execute(model);
		service = new ContentviewService();
		service.execute(model);
		return "Contentview";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST ) 
	public String delete(HttpServletRequest request, Model model)
	{
		System.out.println("--댓글 삭제--");
		model.addAttribute("request",request);
		service = new ReviewDeleteService();
		service.execute(model);
		service = new ReviewListService();
	      service.execute(model);
	      service = new ContentviewService();
			service.execute(model);
	
		return "Contentview";
	}
}
