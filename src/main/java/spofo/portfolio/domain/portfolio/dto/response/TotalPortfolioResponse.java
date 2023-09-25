package spofo.portfolio.domain.portfolio.dto.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TotalPortfolioResponse {

    private Long id;
    private BigDecimal allTotalAsset; // 총 자산
    private BigDecimal allGain; // 평가 손익
    private BigDecimal allGainRate; // 수익률
    private BigDecimal allDailyGainRate; // 일간 수익률

    public static TotalPortfolioResponse from(BigDecimal allTotalAsset, BigDecimal allGain,
            BigDecimal allGainRate, BigDecimal allDailyGainRate) {
        return TotalPortfolioResponse.builder()
                .allTotalAsset(allTotalAsset)
                .allGain(allGain)
                .allGainRate(allGainRate)
                .allDailyGainRate(allDailyGainRate)
                .build();
    }


}
