package finalmission.infrastructure.lesson;

import finalmission.domain.lesson.entity.Lesson;
import finalmission.domain.lesson.model.Name;
import finalmission.domain.lesson.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LessonRepositoryImpl implements LessonRepository {

    private final JpaLessonRepository repository;

    @Override
    public Lesson findByName(final Name name) {
        return repository.findByName(name);
    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }

    @Override
    public Lesson save(final Lesson lesson) {
        return repository.save(lesson);
    }
}
