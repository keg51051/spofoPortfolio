package spofo.portfolio.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spofo.portfolio.entity.Portfolio;
import spofo.portfolio.enums.PortfolioType;

@Data
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

    @Builder
    public CreatePortfolioRequest(String name, String description, String currency,
            PortfolioType type) {
        this.name = name;
        this.description = description;
        this.currency = currency;
        this.type = type;
    }

}
