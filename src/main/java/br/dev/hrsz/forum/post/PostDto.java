package br.dev.hrsz.forum.post;

import jakarta.validation.constraints.NotBlank;

public record PostDto(@NotBlank String title, @NotBlank String text) {

}
