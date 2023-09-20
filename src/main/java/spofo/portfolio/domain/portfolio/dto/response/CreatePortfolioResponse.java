package spofo.portfolio.domain.portfolio.dto.response;

import lombok.Getter;
import spofo.portfolio.domain.portfolio.entity.Portfolio;

@Getter
public class CreatePortfolioResponse {

    private Long id;

    private CreatePortfolioResponse(Portfolio portfolio){
        this.id = portfolio.getId();
    }

    public static CreatePortfolioResponse from(Portfolio portfolio){
        return new CreatePortfolioResponse(portfolio);
    }

}
