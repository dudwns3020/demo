package com.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.demo.vo.Article;

@Controller
public class UsrArticleController {
	
	private int articlesLastId;	
	private List<Article> articles;
	
	public UsrArticleController() {
		articles = new ArrayList<>();
	}
	
	public Article writeArticle(String title, String body) {
		
		int id = articlesLastId + 1;
		Article article = new Article(id, title, body);
		
		articles.add(article);
		articlesLastId++;
		
		return article;
	}
	
	public Article getArticle(int id) {
		for(Article article: articles) {
			if(article.getId() == id) {
				return article;
			}
		}
		return null;
	}
	
	public Article deleteArticle(int id) {
		Article article = getArticle(id);

		articles.remove(article);
		
		return null;
	}
	
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {

		Article article = writeArticle(title, body);
		
		return article;
	}
	
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articles;
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = getArticle(id);

		if(article == null) {
			return id + "번 게시물은 존재하지 않습니다.";
		}
			
		deleteArticle(id);
		
		return id + "번 게시물을 삭제했습니다.";
	}

	
}
