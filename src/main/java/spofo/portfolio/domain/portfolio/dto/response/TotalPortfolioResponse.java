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
    private BigDecimal total; // 총 자산
    private BigDecimal totalReturn; // 평가 손익
    private BigDecimal returnPercent; // 수익률
    private BigDecimal returnPerDay; // 일간 수익률

    public static TotalPortfolioResponse from(BigDecimal total, BigDecimal totalReturn,
            BigDecimal returnPercent, BigDecimal returnPerDay) {
        return TotalPortfolioResponse.builder()
                .total(total)
                .totalReturn(totalReturn)
                .returnPercent(returnPercent)
                .returnPerDay(returnPerDay)
                .build();
    }


}
