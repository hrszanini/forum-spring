package br.dev.hrsz.forum.post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post register(Post post) {
		return postRepository.save(post);
	}

	public List<Post> getAll() {
		return postRepository.findAll();
	}

	public Post getOne(UUID id) {
		Optional<Post> post = postRepository.findById(id);
		if (post.isEmpty()) {
			throw new RuntimeException("Post not found");
		}

		return post.get();
	}

}
