package com.exam.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.demo.service.ArticleService;
import com.exam.demo.service.BoardService;
import com.exam.demo.util.Ut;
import com.exam.demo.vo.Article;
import com.exam.demo.vo.Board;
import com.exam.demo.vo.ResultData;
import com.exam.demo.vo.Rq;

@Controller
public class UsrArticleController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private BoardService boardService;

	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public String doAdd(HttpServletRequest req, String title, String body) {
		Rq rq = (Rq) req.getAttribute("rq");

//		if (rq.isLogined() == false) {
//			return ResultData.from("로그인 후 이용해주세요");
//		}

		if (Ut.empty(title)) {
			return Ut.jsHistoryBack("title을(를) 입력해주세요.");
		}
		if (Ut.empty(body)) {
			return Ut.jsHistoryBack("body을(를) 입력해주세요.");
		}

		ResultData<Integer> writeArticleRd = articleService.writeArticle(rq.getLoginedMemberId(), title, body);

		int id = writeArticleRd.getData1();

		Article article = articleService.getArticle(rq.getLoginedMemberId(), id);

		return Ut.jsReplace(Ut.f("%d번 게시물이 생성되었습니다.", id), "../article/list");
	}

	@RequestMapping("/usr/article/write")
	public String write(HttpServletRequest req, Model model) {

		return "/usr/article/write";
	}

	@RequestMapping("/usr/article/list")
	public String getArticles(HttpServletRequest req, Model model, @RequestParam(defaultValue = "1") int boardId,
			@RequestParam(defaultValue = "1") int page) {
		Rq rq = (Rq) req.getAttribute("rq");

		Board board = boardService.getBoardId(boardId);

		if (board == null) {
			return Ut.jsHistoryBack("존재하지 않는 게시판입니다.");
		}

		int totalPage = articleService.getArticlesCount();

		int itemsCountPage = 10;

		int pageCount = (int) Math.ceil((double) totalPage / itemsCountPage);

		List<Article> articles = articleService.getArticles(rq.getLoginedMemberId(), itemsCountPage, page);

		model.addAttribute("articles", articles);
		model.addAttribute("board", board);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCount", pageCount);

		return "/usr/article/list";
	}

	@RequestMapping("/usr/article/detail")
	public String detail(HttpServletRequest req, Model model, int id) {
		Rq rq = (Rq) req.getAttribute("rq");

		Article article = articleService.getArticle(rq.getLoginedMemberId(), id);

		model.addAttribute("article", article);

		return "/usr/article/detail";
	}

//	@RequestMapping("/usr/article/getArticle")
//	@ResponseBody
//	public String getArticle(HttpServletRequest req, int id) {
//		Rq rq = (Rq) req.getAttribute("rq");
//
//		Article article = articleService.getArticle(rq.getLoginedMemberId(), id);
//
//		if (article == null) {
//			return Ut.f("%d번 게시물은 존재하지 않습니다.", id);
//		}
//
//		return Ut.f(Ut.f("%d번 게시물 입니다.", id), article);
//	}

	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(HttpServletRequest req, int id) {
		Rq rq = (Rq) req.getAttribute("rq");

//		if (rq.isLogined() == false) {
//			return Ut.jsHistoryBack("로그인 후 이용해주세요.");
//		}

		Article article = articleService.getArticle(rq.getLoginedMemberId(), id);

		if (article == null) {
			return Ut.jsHistoryBack(Ut.f("%d번 게시물은 존재하지 않습니다.", id));
		}

		if (article.getMemberId() != rq.getLoginedMemberId()) {
			return Ut.jsHistoryBack("해당 게시물의 작성자가 아닙니다.");
		}

		articleService.deleteArticle(id);

		return Ut.jsReplace(Ut.f("%d번 게시물은 삭제되었습니다.", id), "../article/list");
	}

	@RequestMapping("/usr/article/modify")
	public String modify(HttpServletRequest req, Model model, int id) {
		Rq rq = (Rq) req.getAttribute("rq");

		Article article = articleService.getArticle(rq.getLoginedMemberId(), id);

		if (article == null) {
			return Ut.jsHistoryBack(Ut.f("%d번 게시물은 존재하지 않습니다.", id));
		}

//		ResultData actorCanModifyRd = articleService.actorCanModify(rq.getLoginedMemberId(), article);

		model.addAttribute("article", article);

		return "/usr/article/modify";
	}

	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public String doModify(HttpServletRequest req, int id, String title, String body) {
		Rq rq = (Rq) req.getAttribute("rq");

//		if (rq.isLogined() == false) {
//			return ResultData.from("로그인 후 이용해주세요.");
//		}

		Article article = articleService.getArticle(rq.getLoginedMemberId(), id);

		if (article == null) {
			return Ut.jsHistoryBack(Ut.f("%d번 게시물은 존재하지 않습니다.", id));
		}

		if (article.getMemberId() != rq.getLoginedMemberId()) {
			return Ut.jsHistoryBack(Ut.f("해당 게시물의 작성자가 아닙니다."));
		}

		if (Ut.empty(title)) {
			return Ut.jsHistoryBack("title을(를) 입력해주세요.");
		}
		if (Ut.empty(body)) {
			return Ut.jsHistoryBack("body을(를) 입력해주세요.");
		}

//		ResultData actorCanModify = articleService.actorCanModify(rq.getLoginedMemberId(), article);

		articleService.modifyArticle(rq.getLoginedMemberId(), id, title, body);

		return Ut.jsReplace(Ut.f("%d번 게시물이 수정되었습니다.", id), Ut.f("../article/detail?id=%d", id));
	}
}
