package spofo.portfolio.domain.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spofo.global.entity.Date;
import spofo.portfolio.domain.portfolio.enums.IncludeType;
import spofo.portfolio.domain.portfolio.enums.PortfolioType;

@Entity
@Table(name = "portfolio")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Portfolio extends Date {

    @Id
    private Long id;

    private Long memberId;

    private String name;

    private String description;

    private String currency;

    @Enumerated(EnumType.STRING)
    private IncludeType includeYn;

    @Enumerated(EnumType.STRING)
    private PortfolioType type;
}
