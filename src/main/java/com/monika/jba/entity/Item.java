package com.monika.jba.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Monika
 *
 */
@Entity
@Table(name = "Item")
public class Item implements Serializable {

	/**
	 * No Argument Constructor.
	 */
	public Item() {

	}

	/**
	 * Parameterized Constructor.
	 * 
	 * @param blog
	 * @param title
	 * @param link
	 * @param publishedDate
	 */
	public Item(Blog blog, String title, String link, Date publishedDate) {
		this.blog = blog;
		this.title = title;
		this.link = link;
		this.publishedDate = publishedDate;
	}

	private static final long serialVersionUID = 8634209606034270882L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 1000)
	private String title;

	/*
	 * @Lob
	 * 
	 * @Type(type="org.hibernate.type.StringClobType")
	 * 
	 * @Column(length=Integer.MAX_VALUE)
	 */
	private String description;

	@Column(length = 1000)
	private String link;

	@Column(name = "published_date")
	private Date publishedDate;

	@ManyToOne
	@JoinColumn(name = "blog_id")
	private Blog blog;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

}
