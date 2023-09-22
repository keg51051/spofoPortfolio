package spofo.portfolio.domain.stock.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import spofo.portfolio.domain.stock.entity.Stock;

@AllArgsConstructor
@Builder
public class StockRequest {

    private String stockCode;
    private String stockName;
    private String imageUrl;
    private String stockMarket;

    public Stock toEntity() {
        return Stock.builder()
                .stockCode(this.stockCode)
                .stockName(this.stockName)
                .imageUrl(this.imageUrl)
                .stockMarket(this.stockMarket)
                .build();
    }

}
