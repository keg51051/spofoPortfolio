package spofo.portfolio.domain.stock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spofo.global.entity.Date;

@Entity
@Table(name = "stock_have")
@Getter
@NoArgsConstructor
public class StockHave extends Date {

    @Id
    @GeneratedValue
    private Long id;
    private String stockCode; // 종목 코드 (FK)
    private Long portfolioId; // 포트폴리오 아이디 (FK)
}
