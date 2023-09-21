package spofo.portfolio.domain.stock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spofo.global.entity.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stock")
@Builder
public class Stock extends Date {

    @Id
    private String stockCode;
    private String stockName;
    private String imageUrl;
    private String stockMarket;
}
