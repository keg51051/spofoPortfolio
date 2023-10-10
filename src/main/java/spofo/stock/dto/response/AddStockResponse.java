package spofo.stock.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import spofo.stock.entity.StockHave;

@Data
@AllArgsConstructor
@Builder
public class AddStockResponse {

    private Long portfolioId;

    public static AddStockResponse from(StockHave stockHave) {
        return AddStockResponse.builder()
                .portfolioId(stockHave.getPortfolio().getId())
                .build();
    }

}
