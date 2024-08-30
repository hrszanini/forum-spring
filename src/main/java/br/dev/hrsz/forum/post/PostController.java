package br.dev.hrsz.forum.post;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Controller
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/posts")
	public ResponseEntity<List<Post>> listPosts() {
		List<Post> posts = postService.getAll();
		for (Post post : posts) {
			UUID id = post.getId();
			post.add(linkTo(methodOn(PostController.class).getOne(id)).withSelfRel());
		}
		return ResponseEntity.status(HttpStatus.OK).body(posts);
	}

	@GetMapping("/post/{id}")
	public ResponseEntity<Object> getOne(@PathVariable(value = "id") UUID id) {
		return null;
	}

	@PostMapping("/post")
	public ResponseEntity<Object> register(@RequestBody @Valid PostDto postDto) {
		return null;
	}
}
