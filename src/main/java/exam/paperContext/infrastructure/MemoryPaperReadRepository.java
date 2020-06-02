package exam.paperContext.infrastructure;

import exam.paperContext.domain.model.paper.Paper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MemoryPaperReadRepository {
    private final MemoryPaperRepository memoryPaperRepository;

    public List<Paper> getAllByReversedOrder() {
        return memoryPaperRepository.getAll().stream()
                .sorted((paper, paper1) -> paper1.getCreateTime().compareTo(paper.getCreateTime()))
                .collect(Collectors.toList());
    }
}
