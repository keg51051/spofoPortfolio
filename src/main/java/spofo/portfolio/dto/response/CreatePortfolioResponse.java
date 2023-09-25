package spofo.portfolio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spofo.portfolio.entity.Portfolio;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePortfolioResponse {

    private Long id;

    public static CreatePortfolioResponse from(Portfolio portfolio) {
        return CreatePortfolioResponse.builder()
                .id(portfolio.getId())
                .build();
    }
}
