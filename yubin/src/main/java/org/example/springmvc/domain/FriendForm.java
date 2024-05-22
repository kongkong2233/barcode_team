package org.example.springmvc.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FriendForm {
    @NotNull(message = "id는 공백을 허용하지 않습니다.")
    private Integer id;
    @NotEmpty(message = "name은 공백을 허용하지 않습니다.")
    @Size(min = 4, max = 20, message = "name은 4-20자까지만 허용합니다.")
    private String name;
    @NotEmpty(message = "email은 공백을 허용하지 않습니다.")
    @Email(message = "email은 이메일의 형식을 지켜야합니다.")
    private String email;
}
