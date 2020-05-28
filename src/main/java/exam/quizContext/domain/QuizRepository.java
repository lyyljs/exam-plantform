package exam.quizContext.domain;

import exam.common.domain.BaseRepository;

public interface QuizRepository extends BaseRepository<Quiz, QuizId> {
    void delete(QuizId quizId);
}
