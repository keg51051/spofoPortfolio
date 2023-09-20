package spofo.portfolio.domain.portfolio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spofo.portfolio.domain.portfolio.dto.request.CreatePortfolio;
import spofo.portfolio.domain.portfolio.dto.response.CreatePortfolioResponse;
import spofo.portfolio.domain.portfolio.repository.PortfolioRepository;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService{

    private final PortfolioRepository portfolioRepository;

    @Override
    @Transactional
    public CreatePortfolioResponse CreatePortfolio(CreatePortfolio RequestDto) {
        return null; // Todo : DTO에서 포트폴리오 엔티티에 넣는 작업
    }
}
