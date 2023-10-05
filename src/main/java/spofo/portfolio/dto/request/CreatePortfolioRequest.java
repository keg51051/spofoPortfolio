package spofo.portfolio.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spofo.portfolio.entity.Portfolio;
import spofo.portfolio.enums.PortfolioType;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePortfolioRequest {

    private String name;
    private String description;
    private String currency;
    private PortfolioType type;

    public Portfolio toEntity() {
        return Portfolio.builder()
                .name(name)
                .description(description)
                .currency(currency)
                .type(type)
                .build();
    }


}
