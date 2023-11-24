package HackA.server.service;

import HackA.server.dto.request.CommentRequsetDTO;
import HackA.server.dto.response.CommentResponseDTO;

public interface CommentService {
    public CommentResponseDTO read(Long id);

    public boolean saveComment(CommentRequsetDTO commentRequsetDTO);

    public boolean updateComment(CommentRequsetDTO commentRequsetDTO);

    public boolean deleteComment(Long id);
}
