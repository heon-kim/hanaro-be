package org.conan.myboot.domain;

import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Data
public class Board {
    private Integer bno;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
    private Integer hit;
}
