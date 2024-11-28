package org.conan.myboot.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name="Todo")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tno;

    @Column(length=200, nullable=false)
    private String title;
    @Column(length=200, nullable=false)
    private String writer;
    @Column
    @ColumnDefault("0")
    private boolean complete;
    @Column
    private LocalDate dueDate;
}
