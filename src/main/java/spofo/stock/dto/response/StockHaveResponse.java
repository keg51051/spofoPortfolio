package spofo.stock.dto.response;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import spofo.stock.entity.StockHave;

@Data
@Builder
public class StockHaveResponse {

    private Long id;
    private String stockCode;
    private Long portfolioId;

    private String stockName;
    private String sector;
    private BigDecimal totalAsset;
    private BigDecimal gain;
    private BigDecimal gainRate;
    private BigDecimal avgPrice;
    private BigDecimal currentPrice;
    private BigDecimal quantity;
    private String imageUrl;

    public static StockHaveResponse from(@NotNull StockHave sh, String stockName, String sector,
            BigDecimal totalAsset, BigDecimal gain, BigDecimal gainRate, BigDecimal avgPrice,
            BigDecimal currentPrice, BigDecimal quantity, String imageUrl) {
        return StockHaveResponse.builder()
                .id(sh.getId())
                .stockCode(sh.getStockCode())
                .portfolioId(sh.getPortfolio().getId())
                .stockName(stockName)
                .sector(sector)
                .totalAsset(totalAsset)
                .gain(gain)
                .gainRate(gainRate)
                .avgPrice(avgPrice)
                .currentPrice(currentPrice)
                .quantity(quantity)
                .imageUrl(imageUrl).build();
    }
}
