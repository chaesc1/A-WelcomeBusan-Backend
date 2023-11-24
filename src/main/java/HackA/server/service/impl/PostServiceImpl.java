package HackA.server.service.impl;

import HackA.server.domain.Comment;
import HackA.server.domain.Post;
import HackA.server.domain.converter.commentConverter;
import HackA.server.dto.request.PostRequsetDTO;
import HackA.server.repository.CommentRepository;
import HackA.server.repository.MemberRepository;
import HackA.server.repository.PostRepository;
import HackA.server.dto.response.PostResponseDTO;
import HackA.server.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {
    private final MemberRepository memberRepository;

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

//    private Boolean isValid(String userid) {
//     if (memberRepository.findByGoogleId(userid) == null)
//         return false;
//     return true;
//    }
    @Override
    public PostResponseDTO read(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        List<Comment> comment = post.getCommentList();

        PostResponseDTO a = PostResponseDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .hits(post.getHits())
                .commentResponseDTOList(commentConverter.toCommentResponseDTOList(post.getCommentList()))
                .build();
        return a;
    }

    @Override
    public boolean savePost(PostRequsetDTO postRequsetDTO) {
//        if(isValid(postRequsetDTO.getUserid()))
            postRepository.save(PostRequsetDTO.toEntity(postRequsetDTO));
        return false;
    }

    @Override
    public boolean updatePost(PostRequsetDTO postRequsetDTO) {
        Post post = postRepository.findById(postRequsetDTO.getId()).orElseThrow(RuntimeException::new);
        post.modifyPost(postRequsetDTO.getTitle(), postRequsetDTO.getContent(),
                postRequsetDTO.getHits());

        try {
            postRepository.save(post);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deletePost(Long id) {
        postRepository.deleteById(id);
        commentRepository.deleteById(id);
        return true;
    }
}
