package com.exam.demo.controller;

import java.util.List;

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
	public ResultData doAdd(String title, String body) {

		if (Ut.empty(title)) {
			return ResultData.from("title을(를) 입력해주세요.");
		}
		if (Ut.empty(body)) {
			return ResultData.from("body을(를) 입력해주세요.");
		}

		ResultData writeArticleRd = articleService.writeArticle(title, body);
		int id = (int) writeArticleRd.getData1();
		
		Article article = articleService.getArticle(id);

		return ResultData.from(writeArticleRd.getMsg(), article);
	}

	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public ResultData getArticles() {
		List<Article> articles =  articleService.getArticles();
		
		return ResultData.from("게시물리스트", articles);
	}

	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public ResultData getArticle(int id) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return ResultData.from(Ut.f("%d번 게시물은 존재하지 않습니다.", id));
		}

		return ResultData.from(Ut.f("%d번 게시물 입니다.", id), article);
	}

	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public ResultData doDelete(int id) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return ResultData.from(Ut.f("%d번 게시물은 존재하지 않습니다.", id));
		}

		articleService.deleteArticle(id);

		return ResultData.from(Ut.f("%d번 게시물은 삭제되었습니다.", id), id);
	}

	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public ResultData doModify(int id, String title, String body) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return ResultData.from(Ut.f("%d번 게시물은 존재하지 않습니다.", id));
		}

		articleService.modifyArticle(id, title, body);

		return ResultData.from(Ut.f("%d번 게시물은 수정되었습니다.", id), id);
	}
}
