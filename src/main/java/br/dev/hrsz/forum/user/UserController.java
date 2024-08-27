package br.dev.hrsz.forum.user;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
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
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<Object> register(@RequestBody @Valid UserRecordDto userRecordDto) {
		var user = new User();
		BeanUtils.copyProperties(userRecordDto, user);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(user));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("User already exists");
		}
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAll() {
		List<User> users = userService.getAll();
		for (User user : users) {
			UUID id = user.getId();
			user.add(linkTo(methodOn(UserController.class).getOne(id)).withSelfRel());
		}
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Object> getOne(@PathVariable(value = "id") UUID id) {
		try {
			User user = userService.getOne(id);
			user.add(linkTo(methodOn(UserController.class).getAll()).withRel("list"));
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
	}
}
