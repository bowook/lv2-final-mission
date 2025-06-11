package finalmission.domain.reservation.repository;

import finalmission.domain.member.entity.Member;
import finalmission.domain.reservation.entity.Reservation;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {

    Reservation save(final Reservation reservation);

    void deleteById(final Long id);

    List<Reservation> findAll();

    Optional<Reservation> findById(final Long id);

    List<Reservation> findByMember(final Member member);

    boolean existsByLessonAndDateAndTime(final String lesson, final LocalDate date, final LocalTime time);
}
