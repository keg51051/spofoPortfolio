package spofo.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    PORTFOLIO_NOT_FOUND(HttpStatus.BAD_REQUEST, "포트폴리오를 찾을 수 없습니다."),

    /*
    오류 코드 예시입니다
    DUPLICATED_ID(HttpStatus.BAD_REQUEST, "중복된 회원 아이디 입니다.");
     */;
    private final HttpStatus status;
    private final String message;
}
