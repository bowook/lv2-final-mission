package finalmission.presentation.config;

import finalmission.application.AuthService;
import finalmission.domain.auth.exception.MissingTokenException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;

@RequiredArgsConstructor
public class AdminInterceptor implements HandlerInterceptor {

    private static final String TOKEN = "token";

    private final AuthService authService;

    @Override
    public boolean preHandle(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final Object handler) throws Exception {

        final String token = extractTokenFromCookies(request.getCookies());
        authService.validateAdminByToken(token);
        return true;
    }

    private String extractTokenFromCookies(final Cookie[] cookies) {
        if (cookies == null) {
            throw new MissingTokenException("토큰이 존재하지 않습니다.");
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(TOKEN)) {
                return cookie.getValue();
            }
        }

        throw new MissingTokenException("토큰이 존재하지 않습니다.");
    }
}
