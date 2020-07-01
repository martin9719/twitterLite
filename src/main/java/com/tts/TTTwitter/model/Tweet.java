package com.tts.TTTwitter.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

@Entity
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tweet_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	@NotEmpty(message = "Tweet cannot be empty")
	@Length(max = 280, message = "Tweet cannot have more than 280 characters")
	private String message;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "tweet_tag", joinColumns = @JoinColumn(name = "tweet_id"), 
	inverseJoinColumns = @JoinColumn(name="tag_id"))
	private List<Tag> tags;
	
	@CreationTimestamp
	private Date createdAt;

	public Tweet() {
		// TODO Auto-generated constructor stub
	}

	public Tweet(User user, String message, List<Tag> tags, Date createdAt) {
		this.user = user;
		this.message = message;
		this.tags = tags;
		this.createdAt = createdAt;
	}
	

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Tweet [id=" + id + ", user=" + user + ", message=" + message + "]";
	}

}
