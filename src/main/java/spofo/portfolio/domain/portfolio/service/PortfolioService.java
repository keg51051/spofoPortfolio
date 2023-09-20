package spofo.portfolio.domain.portfolio.service;

import spofo.portfolio.domain.portfolio.dto.request.CreatePortfolio;
import spofo.portfolio.domain.portfolio.dto.response.CreatePortfolioResponse;

public interface PortfolioService {
    public CreatePortfolioResponse CreatePortfolio(CreatePortfolio RequestDto);
}
