package exam.paperContext.userInterface;

import exam.paperContext.application.AssemblePaperCommand;
import exam.paperContext.application.PaperService;
import exam.paperContext.domain.model.paper.Paper;
import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.infrastructure.MemoryPaperReadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaperController {

    private final PaperService paperService;
    private final MemoryPaperReadRepository memoryPaperReadRepository;

    @PostMapping("/papers")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    PaperDTO assemble(@RequestBody AssemblePaperCommand command) {
        final PaperId paperId = paperService.assemblePaper(command);
        return PaperDTO.from(paperId);
    }

    @GetMapping("/papers")
    List<Paper> getAll() {
        return memoryPaperReadRepository.getAllByReversedOrder();
    }

    @PutMapping("/papers/{paperId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void reassemble(@PathVariable String paperId, @RequestBody AssemblePaperCommand command) {
        paperService.reassemblePaper(paperId, command);
    }
}
