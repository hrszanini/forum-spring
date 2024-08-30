package br.dev.hrsz.forum.post;

import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import br.dev.hrsz.forum.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pst_post")
public class Post extends RepresentationModel<Post> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pst_id")
	private UUID id;

	@Column(name = "pst_title")
	private String title;

	@Column(name = "pst_text")
	private String text;

	@ManyToOne
	@JoinColumn(name = "usr_id", nullable = false)
	private User owner;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
