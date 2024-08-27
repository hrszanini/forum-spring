package br.dev.hrsz.forum.user;

import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(@NotBlank String username, @NotBlank String password, @NotBlank String nickname) {

}
