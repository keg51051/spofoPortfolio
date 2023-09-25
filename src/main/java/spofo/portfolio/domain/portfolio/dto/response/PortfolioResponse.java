package spofo.portfolio.domain.portfolio.dto.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spofo.portfolio.domain.portfolio.entity.Portfolio;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioResponse {

    private Long id;
    private String name; // 포트폴리오 이름
    private String detail; // 포트폴리오 설명
    private BigDecimal totalAsset; // 총 자산
    private BigDecimal totalBuy; // 총 매수 금액
    private BigDecimal gain; // 평가 손익
    private BigDecimal gainRate; // 수익률

    public static PortfolioResponse from(Portfolio portfolio, BigDecimal totalAsset, BigDecimal totalBuy, BigDecimal gain, BigDecimal gainRate) {
        return PortfolioResponse.builder()
                .id(portfolio.getId())
                .name(portfolio.getName())
                .detail(portfolio.getDescription())
                .totalAsset(totalAsset)
                .totalBuy(totalBuy)
                .gain(gain)
                .gainRate(gainRate)
                .build();
    }
}
