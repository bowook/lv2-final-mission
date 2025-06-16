package finalmission.application;

import finalmission.domain.auth.JwtTokenProvider;
import finalmission.domain.member.exception.MemberNotFoundException;
import finalmission.domain.member.model.Email;
import finalmission.domain.member.model.Password;
import finalmission.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final MemberRepository repository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public String createToken(final String emailValue, final String passwordValue) {
        final Email email = new Email(emailValue);
        final Password password = new Password(passwordValue);

        checkInvalidLogin(email, password);

        return jwtTokenProvider.createToken(email.getValue());
    }

    private void checkInvalidLogin(final Email email, final Password password) {
        if (!repository.existsByEmailAndPassword(email, password)) {
            throw new MemberNotFoundException("멤버가 존재하지 않아 토큰을 만들 수 없습니다.");
        }
    }
}
