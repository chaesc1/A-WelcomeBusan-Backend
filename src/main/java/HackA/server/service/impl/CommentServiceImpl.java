package HackA.server.service.impl;

import HackA.server.domain.Comment;
import HackA.server.domain.Member;
import HackA.server.domain.Post;
import HackA.server.dto.request.CommentRequsetDTO;
import HackA.server.dto.response.CommentResponseDTO;
import HackA.server.repository.CommentRepository;
import HackA.server.repository.MemberRepository;
import HackA.server.repository.PostRepository;
import HackA.server.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    @Override
    public CommentResponseDTO read(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        CommentResponseDTO a = CommentResponseDTO.builder()
                .id(comment.getId())
                .comment_content(comment.getCommentContent())
                .star_cnt(comment.getStar_cnt())
                .build();
        return a;
    }

    @Override
    public boolean saveComment(CommentRequsetDTO commentRequsetDTO) {
        return false;
    }

    @Override
    public boolean updateComment(CommentRequsetDTO commentRequsetDTO) {
        return false;
    }

    @Override
    public boolean deleteComment(Long id) {
        return false;
    }
}
