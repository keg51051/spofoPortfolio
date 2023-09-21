package spofo.portfolio.domain.portfolio.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spofo.portfolio.domain.portfolio.entity.Portfolio;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePortfolioRequest {

    private Long id;
    private Long memberId;
    private String name;
    private String description;
    private String currency;
    private String includeYn;
    private String type;

    public Portfolio toEntity() {
        return Portfolio.builder()
                .id(id)
                .memberId(memberId)
                .name(name)
                .description(description)
                .currency(currency)
                .includeYn(includeYn)
                .type(type)
                .build();
    }
}
