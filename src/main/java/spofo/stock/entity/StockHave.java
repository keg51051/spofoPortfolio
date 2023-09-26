package spofo.stock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spofo.global.entity.Date;
import spofo.portfolio.entity.Portfolio;

@Entity
@Table(name = "stock_have")
@Getter
@NoArgsConstructor
public class StockHave extends Date {

    @Id
    @GeneratedValue
    @JoinColumn(name = "id")
    private Long id;
    private String stockCode; // 종목 코드 (FK)
    @JoinColumn(name = "portfolio_id")
    @ManyToOne(fetch = FetchType.LAZY) // Fecth 타입 Lazy 설정, Default: Eager
    private Portfolio portfolio; // 포트폴리오 아이디 (FK)
}
