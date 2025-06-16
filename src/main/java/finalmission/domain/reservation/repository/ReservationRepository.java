package finalmission.domain.reservation.repository;

import finalmission.domain.member.entity.Member;
import finalmission.domain.reservation.entity.Reservation;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {

    Reservation save(final Reservation reservation);

    void deleteByMemberAndId(final Member member, final Long id);

    void deleteById(final Long id);

    List<Reservation> findAll();

    Optional<Reservation> findById(final Long id);

    List<Reservation> findByMember(final Member member);

    Reservation findReservationByIdAndMember(final Long id, final Member member);

    boolean existsReservationByLessonId(final Long lessonId);
}
