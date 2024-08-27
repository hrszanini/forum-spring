package br.dev.hrsz.forum.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User register(User newUser) {
		Optional<User> user = userRepository.findByUsername(newUser.getUsername());
		if (!user.isEmpty())
			throw new RuntimeException("User already exists");
		return userRepository.save(newUser);
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User getOne(UUID id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new RuntimeException("User not found");
		}

		return user.get();
	}
}
