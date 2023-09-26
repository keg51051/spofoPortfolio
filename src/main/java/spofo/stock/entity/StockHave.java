package spofo.stock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private Long id;
    private String stockCode; // 종목 코드 (FK)
    @ManyToOne
    private Portfolio portfolio; // 포트폴리오 아이디 (FK)
}
