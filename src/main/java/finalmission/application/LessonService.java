package finalmission.application;

import finalmission.domain.lesson.entity.Lesson;
import finalmission.domain.lesson.model.Name;
import finalmission.domain.lesson.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LessonService {

    private final LessonRepository repository;

    @Transactional
    public Lesson save(final String value) {
        final Name name = new Name(value);
        final Lesson lesson = new Lesson(name);

        return repository.save(lesson);
    }

    @Transactional
    public void delete(final boolean isExistReservation, final Long id) {
        existsReservation(isExistReservation);

        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Lesson findLesson(final String value) {
        final Name name = new Name(value);

        return repository.findByName(name);
    }

    private void existsReservation(final boolean isExistReservation) {
        if (isExistReservation) {
            throw new IllegalArgumentException("예약이 존재해 삭제 할 수 없습니다.");
        }
    }
}
