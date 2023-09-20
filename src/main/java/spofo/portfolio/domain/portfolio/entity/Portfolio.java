package spofo.portfolio.domain.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Portfolio {

    @Id
    private int id;

    private int member_id;

    private String name;

    private String description;

    private String currency;

    private String include_yn;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
