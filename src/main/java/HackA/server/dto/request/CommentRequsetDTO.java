package HackA.server.dto.request;

import HackA.server.domain.Comment;
import HackA.server.domain.Member;
import HackA.server.domain.Post;
import HackA.server.domain.UploadImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommentRequsetDTO {
    private Long id;
    private String comment_content;
    private int star_cnt;
    private Member member_id;
    private Post post_id;

    public static Comment toEntity(CommentRequsetDTO dto) {
        return Comment.builder()
                .id(dto.getId())
                .commentContent(dto.getComment_content())
                .star_cnt(dto.getStar_cnt())
                .member(dto.getMember_id())
                .post(dto.getPost_id())
                .build();
    }
}
