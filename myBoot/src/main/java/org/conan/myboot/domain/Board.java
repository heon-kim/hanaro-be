package org.conan.myboot.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "writer")
@Getter
public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long bno;
    private String title;
    private String content;

    @ManyToOne
    private Member writer;
    @Builder.Default
    private Integer hit = 0;
}