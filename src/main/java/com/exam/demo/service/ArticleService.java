package com.exam.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.demo.repository.ArticleRepository;
import com.exam.demo.vo.Article;

@Service
public class ArticleService {

	@Autowired
	ArticleRepository articleRepository;

	public int writeArticle(String title, String body) {
		articleRepository.writeArticle(title, body);
		return articleRepository.lastInsertId();
	}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}

	public Article getArticle(int id) {
		return articleRepository.getArticle(id);
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}

	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
	}

}
