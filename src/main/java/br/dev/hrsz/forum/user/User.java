package br.dev.hrsz.forum.user;

import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "usr_user")
public class User extends RepresentationModel<User> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usr_id")
	private UUID id;

	@JsonIgnore
	@Column(name = "usr_username")
	private String username;

	@JsonIgnore
	@Column(name = "usr_password")
	private String password;

	@Column(name = "usr_nickname")
	private String nickname;

	public record CreateDto(@NotBlank String username, @NotBlank String password, @NotBlank String nickname) {
	}

	public record LoginDto(@NotBlank String username, @NotBlank String password) {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
