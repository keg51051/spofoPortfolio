package spofo.portfolio.dto.response;

import com.fasterxml.jackson.core.JsonToken;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import spofo.portfolio.entity.Portfolio;
import spofo.portfolio.enums.PortfolioType;

@Data
public class PortfolioResponse {

    private Long id;
    private String name; // 포트폴리오 이름
    private String detail; // 포트폴리오 설명
    private BigDecimal totalAsset; // 총 자산
    private BigDecimal totalBuy; // 총 매수 금액
    private BigDecimal gain; // 평가 손익
    private BigDecimal gainRate; // 수익률
    private PortfolioType portfolioType; // 태그

    public static PortfolioResponse from(Portfolio portfolio, BigDecimal totalAsset,
            BigDecimal totalBuy, BigDecimal gain, BigDecimal gainRate) {
        return PortfolioResponse.builder()
                .portfolio(portfolio)
                .totalAsset(totalAsset)
                .totalBuy(totalBuy)
                .gain(gain)
                .gainRate(gainRate)
                .build();
    }

    @Builder
    private PortfolioResponse(Portfolio portfolio, BigDecimal totalAsset,
            BigDecimal totalBuy, BigDecimal gain, BigDecimal gainRate) {
        this.id = portfolio.getId();
        this.name = portfolio.getName();
        this.detail = portfolio.getDescription();
        this.portfolioType = portfolio.getType();
        this.totalAsset = totalAsset;
        this.totalBuy = totalBuy;
        this.gain = gain;
        this.gainRate = gainRate;
    }
}
