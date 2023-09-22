package spofo.portfolio.domain.portfolio.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import spofo.portfolio.domain.portfolio.entity.Portfolio;
import spofo.portfolio.domain.portfolio.repository.PortfolioRepository;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final RestClient restClient;

    public String getStock() {
        return restClient.get()
                .uri("https://www.stock.spofo.net/1")
                .retrieve()
                .body(String.class);
    }

    public String getAuth() {
        return restClient.get()
                .uri("https://www.auth.spofo.net")
                .retrieve()
                .body(String.class);
    }

    public String getMemberId() {
        return restClient.get()
                .uri("https://www.auth.spofo.net:8080/auth/members/search")
                .retrieve()
                .body(String.class);
    }

    // 전체 포트폴리오 자산 조회 리스트 전달
    public void getTotalPortfolio(Long memberId) {
        // void -> List<TotalPortfolioResponse>로 바꿀 예정 (로직 완성 안되서 void로 해놓음)
        List<Portfolio> portfolios = portfolioRepository.findByMemberId(memberId);
    }

    /* 총 자산 계산
    private BigDecimal getTotal() {

    }

    // 평가 손익 계산
    private BigDecimal getTotalReturn() {

    }

    // 총 매수 금액 계산
    private BigDecimal getTotalBuy() {

    }

    // 수익률 계산
    private BigDecimal getReturnPercent() {

    }

    // 일간 수익률 계산
    private BigDecimal getReturnPerDay() {

    }
    */

}
