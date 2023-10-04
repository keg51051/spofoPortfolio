package spofo.portfolio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spofo.global.entity.Date;
import spofo.portfolio.enums.IncludeType;
import spofo.portfolio.enums.PortfolioType;

@Entity
@Table(name = "Portfolio")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Portfolio extends Date {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private String name;

    private String description;

    private String currency;

    @Column(columnDefinition = "VARCHAR(1) DEFAULT 'Y'", nullable = false)
    @Enumerated(EnumType.STRING)
    private IncludeType includeYn;

    @Enumerated(EnumType.STRING)
    private PortfolioType type;


}
