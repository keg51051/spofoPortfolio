package spofo.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spofo.portfolio.enums.PortfolioType;
import spofo.portfolio.enums.IncludeType;
import spofo.global.entity.Date;

@Entity
@Table(name = "portfolio")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Portfolio extends Date {

    @Id
    private Long id;

    private Long memberId;

    private String name;

    private String detail;

    private String currency;

    @Enumerated(EnumType.STRING)
    private IncludeType includeYn;

    @Enumerated(EnumType.STRING)
    private PortfolioType type;


}
