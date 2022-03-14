package com.exam.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.demo.repository.ArticleRepository;
import com.exam.demo.util.Ut;
import com.exam.demo.vo.Article;
import com.exam.demo.vo.ResultData;

@Service
public class ArticleService {

	@Autowired
	ArticleRepository articleRepository;

	public ResultData<Integer> writeArticle(int memberId, String title, String body) {
		articleRepository.writeArticle(memberId, title, body);
		int id = articleRepository.getLastInsertId();

		return ResultData.from(Ut.f("%d번 게시물이 생성되었습니다.", id), id);
	}

	public List<Article> getArticles(int actorId) {
		List<Article> articles = articleRepository.getArticles();

		for (Article article : articles) {
			updateData(actorId, article);
		}

		return articleRepository.getArticles();
	}

	public Article getArticle(int actorId, int id) {

		Article article = articleRepository.getArticle(id);

		updateData(actorId, article);

		return article;
	}

	private void updateData(int actorId, Article article) {
		if (article == null) {
			return;
		}

		if (article.getMemberId() == actorId) {
			article.setCanDelete(true);
		}
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}

	public ResultData<Article> modifyArticle(int actorId, int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);

		Article article = getArticle(actorId, id);

		return ResultData.from(Ut.f("%d번 게시물을 수정했습니다.", id), article);
	}

	public ResultData actorCanModify(int actorId, Article article) {
		if (article == null) {
			ResultData.from("게시물이 존재하지 않습니다.");
		}

		if (article.getMemberId() != actorId) {
			return ResultData.from("게시물의 작성자가 아닙니다.");
		}

		return ResultData.from("게시물은 수정이 가능합니다.");
	}

}
