package finalmission.infrastructure.reservation;

import finalmission.domain.member.entity.Member;
import finalmission.domain.reservation.entity.Reservation;
import finalmission.domain.reservation.repository.ReservationRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    private final JpaReservationRepository repository;

    @Override
    public Reservation save(final Reservation reservation) {
        return repository.save(reservation);
    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Reservation> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Reservation> findById(final Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Reservation> findByMember(final Member member) {
        return repository.findByMember(member);
    }

    @Override
    public boolean existsByLessonAndDateAndTime(final String lesson, final LocalDate date, final LocalTime time) {
        return repository.existsByLessonAndDateAndTime(lesson, date, time);
    }
}
