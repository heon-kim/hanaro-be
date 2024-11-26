package org.conan.domain;

import lombok.Data;
import lombok.Setter;

import java.util.Date;

@Setter
@Data
public class Board {
    private Integer bno;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Integer hit;
}
