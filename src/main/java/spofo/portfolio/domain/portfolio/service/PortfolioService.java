package spofo.portfolio.domain.portfolio.service;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import spofo.global.exception.ErrorCode;
import spofo.global.exception.PortfolioException;
import spofo.portfolio.domain.portfolio.dto.response.PortfolioResponse;
import spofo.portfolio.domain.portfolio.entity.Portfolio;
import spofo.portfolio.domain.portfolio.repository.PortfolioRepository;
import spofo.portfolio.domain.stock.service.StockHaveService;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final RestClient restClient;
    private final StockHaveService stockHaveService;

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

    public PortfolioResponse getPortfolio(Long portfolioId) {
        Portfolio portfolio = findById(portfolioId);

        BigDecimal totalAsset = getTotalAsset();
        BigDecimal totalBuy = getTotalBuy();
        BigDecimal gain = getGain(totalAsset, totalBuy);
        BigDecimal gainRate = getGainRate(totalAsset, totalBuy);
        return PortfolioResponse.from(portfolio, totalAsset, totalBuy, gain, gainRate);
    }

    private Portfolio findById(Long id) {
        return portfolioRepository.findById(id)
                .orElseThrow(() ->
                        new PortfolioException(ErrorCode.PORTFOLIO_NOT_FOUND));
    }

    /** TODO : 총 자산 계산
     * 각 종목 현재가 * 수량
     * **/
    private BigDecimal getTotalAsset() {
        return BigDecimal.ZERO;
    }

    /** TODO : 총 매수 금액 계산
     * 각 종목의 구매가 * 수량
     * **/
    private BigDecimal getTotalBuy() {
        return BigDecimal.ZERO;
    }

    /** 평가 손익 계산
     * 총 자산 - 총 매수 금액
     * **/
    private BigDecimal getGain(BigDecimal totalAsset, BigDecimal totalBuy) {
        return totalAsset.subtract(totalBuy);
    }

    /** 수익률 계산
     * ((총 자산/총 매수 금액)*100)-100
     * **/
    private BigDecimal getGainRate(BigDecimal totalAsset, BigDecimal totalBuy) {
        return totalAsset.divide(totalBuy).multiply(BigDecimal.valueOf(100)).subtract(
                BigDecimal.valueOf(100));
    }


    /** TODO : 일간 수익률 계산
    private BigDecimal getReturnPerDay() {

    }**/
}
