package spofo.portfolio.dto.response;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;
import spofo.portfolio.entity.Portfolio;
import spofo.portfolio.enums.PortfolioType;

@Data
@Builder
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
                .id(portfolio.getId())
                .name(portfolio.getName())
                .detail(portfolio.getDescription())
                .totalAsset(totalAsset)
                .totalBuy(totalBuy)
                .gain(gain)
                .gainRate(gainRate)
                .portfolioType(portfolio.getType())
                .build();
    }
}
