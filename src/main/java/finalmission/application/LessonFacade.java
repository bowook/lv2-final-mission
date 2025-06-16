package finalmission.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LessonFacade {

    private final ReservationService reservationService;
    private final LessonService lessonService;

    public void delete(final Long id) {
        final boolean isExistReservation = reservationService.existsReservation(id);

        lessonService.delete(isExistReservation, id);
    }
}
