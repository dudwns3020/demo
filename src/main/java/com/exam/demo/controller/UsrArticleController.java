package com.exam.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.demo.service.ArticleService;
import com.exam.demo.util.Ut;
import com.exam.demo.vo.Article;
import com.exam.demo.vo.ResultData;

@Controller
public class UsrArticleController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public ResultData<Article> doAdd(HttpSession httpSession, String title, String body) {
		boolean	isLogined = false;
		int loginedMemeberId = 0;
		
		if(httpSession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemeberId = (int)httpSession.getAttribute("loginedMemberId");
		}
		
		if(isLogined == false) {
			return ResultData.from("로그인 후 이용해주세요");
		}
		
		if (Ut.empty(title)) {
			return ResultData.from("title을(를) 입력해주세요.");
		}
		if (Ut.empty(body)) {
			return ResultData.from("body을(를) 입력해주세요.");
		}

		ResultData<Integer> writeArticleRd = articleService.writeArticle(loginedMemeberId, title, body);
		int id = writeArticleRd.getData1();
		
		Article article = articleService.getArticle(id);

		return ResultData.newData(writeArticleRd, article);
	}

	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public ResultData<List<Article>> getArticles() {
		List<Article> articles =  articleService.getArticles();
		
		return ResultData.from("게시물리스트", articles);
	}

	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public ResultData<Article> getArticle(int id) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return ResultData.from(Ut.f("%d번 게시물은 존재하지 않습니다.", id));
		}

		return ResultData.from(Ut.f("%d번 게시물 입니다.", id), article);
	}

	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public ResultData<Integer> doDelete(HttpSession httpSession, int id) {
		boolean isLogined = false;
		int loginedMemberId = 0;
		
		if(httpSession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int)httpSession.getAttribute("loginedMemberId");
		}
		
		if(isLogined == false) {
			return ResultData.from("로그인 후 이용해주세요.");
		}
		
		Article article = articleService.getArticle(id);

		if (article == null) {
			return ResultData.from(Ut.f("%d번 게시물은 존재하지 않습니다.", id));
		}

		if(article.getMemberId() != loginedMemberId) {
			return ResultData.from("해당 게시물의 작성자가 아닙니다.");
		}
		
		articleService.deleteArticle(id);

		return ResultData.from(Ut.f("%d번 게시물은 삭제되었습니다.", id), id);
	}

	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public ResultData<Integer> doModify(int id, String title, String body) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return ResultData.from(Ut.f("%d번 게시물은 존재하지 않습니다.", id));
		}

		articleService.modifyArticle(id, title, body);

		return ResultData.from(Ut.f("%d번 게시물은 수정되었습니다.", id), id);
	}
}
