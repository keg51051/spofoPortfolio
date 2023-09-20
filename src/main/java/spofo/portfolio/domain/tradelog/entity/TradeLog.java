package spofo.portfolio.domain.trade.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRADE_LOG_TB")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TradeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO : 보유 종목 번호

    @Column(columnDefinition = "VARCHAR(1) DEFAULT ''", nullable = false)
    private String type;

    @Column(columnDefinition = "DECIMAL(18,2) DEFAULT 0", nullable = false)
    private BigDecimal price;

    // TODO : 어노테이션 더 필요
    @Column(updatable = false, nullable = false)
    private LocalDateTime tradeDate;

    @Column(columnDefinition = "DECIMAL(30,15) DEFAULT 0", nullable = false)
    private BigDecimal quantity;

    @Column(columnDefinition = "DECIMAL(18,2) DEFAULT 0", nullable = false)
    private BigDecimal marketPrice;

    // TODO : 어노테이션 더 필요
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
}
