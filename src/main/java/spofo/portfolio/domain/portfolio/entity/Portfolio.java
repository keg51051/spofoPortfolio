package spofo.portfolio.domain.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "portfolio")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Portfolio {

    @Id
    private Long id;

    private Long memberId;

    private String name;

    private String description;

    private String currency;

    @Builder
    public Portfolio(Long id, Long memberId, String name, String description, String currency) {
        this.id = id;
        this.memberId = memberId;
        this.name = name;
        this.description = description;
        this.currency = currency;
    }
}
