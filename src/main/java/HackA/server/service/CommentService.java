package HackA.server.service;

import HackA.server.dto.request.CommentRequsetDTO;
import HackA.server.dto.response.CommentResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

public interface CommentService {
    public CommentResponseDTO read(Long id);

    public boolean saveComment(CommentRequsetDTO commentRequsetDTO);

    public boolean updateComment(CommentRequsetDTO commentRequsetDTO);

    public boolean deleteComment(Long id);
}
