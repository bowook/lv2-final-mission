package finalmission.domain.member.repository;

import finalmission.domain.member.entity.Member;
import java.util.Optional;

public interface MemberRepository {

    Member findByNameAndPhoneNumber(final String name, final String phoneNumber);

    Optional<Member> findById(final Long id);
}
