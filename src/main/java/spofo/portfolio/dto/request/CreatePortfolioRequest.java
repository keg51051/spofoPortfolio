package spofo.portfolio.dto.request;

import lombok.Builder;
import lombok.Getter;
import spofo.portfolio.entity.Portfolio;
import spofo.portfolio.enums.PortfolioType;


@Getter
@Builder
public class CreatePortfolioRequest {

    private String name;
    private String detail;
    private String currency;
    private PortfolioType type;

    public Portfolio toEntity() {
        return Portfolio.builder()
                .name(name)
                .description(detail)
                .currency(currency)
                .type(type)
                .build();
    }


}
