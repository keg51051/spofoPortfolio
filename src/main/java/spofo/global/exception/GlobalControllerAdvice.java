package spofo.global.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice {

    /*
    작성 예시입니다
    @ExceptionHandler(PortfolioException.class)
    public String commonExHandler(PortfolioException ex, HttpServletResponse response, Model model) {

        model.addAttribute("error", ex.getMessage());
        response.setStatus(ex.getErrorCode().getStatus().value());

        return "portfolio_error";
    }
    */

}
