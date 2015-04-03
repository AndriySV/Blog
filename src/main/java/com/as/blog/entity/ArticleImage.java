package com.as.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Article_Image")
public class ArticleImage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="article_id", unique=false, nullable=false)
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="image_id", unique=false, nullable=false)
	private Image image;
	
	@Column(name="paragraph", unique=false, nullable=false)
	private byte paragraph;

	public ArticleImage() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public byte getParagraph() {
		return paragraph;
	}

	public void setParagraph(byte paragraph) {
		this.paragraph = paragraph;
	}

	@Override
	public String toString() {
		return "ArticleImage [id=" + id + ", article=" + article + ", image="
				+ image + ", paragraph=" + paragraph + "]";
	}
}
