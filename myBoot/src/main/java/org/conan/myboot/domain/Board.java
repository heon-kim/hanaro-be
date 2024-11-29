package org.conan.myboot.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="board")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    @Column(length = 40, nullable = false)
    private String title;
    @Column(length = 1000, nullable = false)
    private String content;
    @Column(length = 40, nullable = false)
    private String writer;

    @CreatedDate
    @Column(name="regdate",updatable = false)
    private LocalDate regDate;

    @Builder.Default
    private Integer hit = 0;
}