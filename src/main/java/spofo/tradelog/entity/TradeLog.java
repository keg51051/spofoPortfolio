package spofo.tradelog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import spofo.stock.entity.StockHave;
import spofo.tradelog.enums.TradeType;

@Entity
@Table(name = "TRADE_LOG_TB")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TradeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id")
    private StockHave stockHave;

    @Column(columnDefinition = "VARCHAR(1) DEFAULT 'B'", nullable = false)
    @Enumerated(EnumType.STRING)
    private TradeType type;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(updatable = false, nullable = false)
    private LocalDateTime tradeDate;

    @Column(precision = 30, scale = 15, nullable = false)
    private BigDecimal quantity;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal marketPrice;

    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public TradeLog(Long id, StockHave stockHave, TradeType tradeType, BigDecimal price, LocalDateTime tradeDate, BigDecimal quantity, BigDecimal marketPrice, LocalDateTime createdAt) {
        this.id = id;
        this.stockHave = stockHave;
        this.type = tradeType;
        this.price = price;
        this.tradeDate = tradeDate;
        this.quantity = quantity;
        this.marketPrice = marketPrice;
        this.createdAt = createdAt;
    }
}
