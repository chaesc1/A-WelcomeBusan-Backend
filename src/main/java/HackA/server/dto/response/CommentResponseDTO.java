package HackA.server.dto.response;

import HackA.server.domain.Comment;
import HackA.server.domain.Member;
import HackA.server.domain.Post;
import HackA.server.domain.UploadImage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class CommentResponseDTO {
    private Long id;
    private String comment_content;
    private int star_cnt;
    private Member member_id;
    private Post post_id;
    public static Comment toEntity(CommentResponseDTO commentResponseDTO) {
        return Comment.builder()
                .id(commentResponseDTO.getId())
                .commentContent(commentResponseDTO.getComment_content())
                .member(commentResponseDTO.getMember_id())
                .post(commentResponseDTO.getPost_id())
                .star_cnt(commentResponseDTO.getStar_cnt())
                .build();
    }
}
