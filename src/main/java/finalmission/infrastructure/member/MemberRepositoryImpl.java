package finalmission.infrastructure.member;

import finalmission.domain.member.entity.Member;
import finalmission.domain.member.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final JpaMemberRepository repository;

    @Override
    public Member findByNameAndPhoneNumber(final String name, final String phoneNumber) {
        return repository.findByNameAndPhoneNumber(name, phoneNumber);
    }

    @Override
    public Optional<Member> findById(final Long id) {
        return repository.findById(id);
    }
}
