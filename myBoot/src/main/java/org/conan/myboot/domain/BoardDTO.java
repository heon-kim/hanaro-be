


package org.conan.myboot.domain;

import jakarta.persistence.*;
        import lombok.*;
        import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Data
public class BoardDTO {
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
    private Integer hit;
}

