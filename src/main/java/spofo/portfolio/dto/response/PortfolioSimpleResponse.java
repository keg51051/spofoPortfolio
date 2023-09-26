package spofo.portfolio.dto.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spofo.portfolio.entity.Portfolio;
import spofo.portfolio.enums.IncludeType;
import spofo.portfolio.enums.PortfolioType;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioSimpleResponse {

    private Long id;
    private String name;
    private PortfolioType type;
    private IncludeType includeYn;
    private BigDecimal gain;
    private BigDecimal gainRate;

    public static PortfolioSimpleResponse from(Portfolio portfolio, BigDecimal gain,
            BigDecimal gainRate) {
        return PortfolioSimpleResponse.builder()
                .id(portfolio.getId())
                .name(portfolio.getName())
                .type(portfolio.getType())
                .includeYn(portfolio.getIncludeYn())
                .gain(gain)
                .gainRate(gainRate)
                .build();
    }
}
