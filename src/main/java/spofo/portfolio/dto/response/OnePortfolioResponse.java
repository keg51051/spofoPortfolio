package spofo.portfolio.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spofo.portfolio.entity.Portfolio;
import spofo.portfolio.enums.PortfolioType;

@Data
@NoArgsConstructor
public class OnePortfolioResponse {

    private Long id;
    private Long memberId;
    private String name;
    private String description;
    private String currency;
    private PortfolioType type;

    public static OnePortfolioResponse from(Portfolio portfolio) {
        return OnePortfolioResponse.builder()
                .id(portfolio.getId())
                .memberId(portfolio.getMemberId())
                .name(portfolio.getName())
                .description(portfolio.getDescription())
                .currency(portfolio.getCurrency())
                .type(portfolio.getType())
                .build();
    }

    @Builder
    public OnePortfolioResponse(Long id, Long memberId, String name, String description,
            String currency, PortfolioType type) {
        this.id = id;
        this.memberId = memberId;
        this.name = name;
        this.description = description;
        this.currency = currency;
        this.type = type;
    }

}
