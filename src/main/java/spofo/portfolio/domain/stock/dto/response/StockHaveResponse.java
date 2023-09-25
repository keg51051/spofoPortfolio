package spofo.portfolio.domain.stock.dto.response;

import lombok.Builder;
import org.jetbrains.annotations.NotNull;
import spofo.portfolio.domain.stock.entity.StockHave;

@Builder
public class StockHaveResponse {

    private Long id;
    private String stockCode;
    private Long portfolioId;

    public static StockHaveResponse from(@NotNull StockHave sh) {
        return StockHaveResponse.builder()
                .id(sh.getId())
                .stockCode(sh.getStockCode())
                .portfolioId(sh.getPortfolioId())
                .build();
    }
}
