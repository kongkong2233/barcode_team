package org.example.springmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Friend {
    private Integer id;
    private String name;
    private String email;
}
