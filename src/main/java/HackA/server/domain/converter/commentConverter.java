package HackA.server.domain.converter;

import HackA.server.domain.Comment;
import HackA.server.dto.response.CommentResponseDTO;
import java.util.ArrayList;
import java.util.List;

public class commentConverter {
    public static List<CommentResponseDTO> toCommentResponseDTOList(List<Comment> comment) {
        List<CommentResponseDTO> cdtolist = new ArrayList<>();
        for(Comment c : comment) {
            CommentResponseDTO cdto = CommentResponseDTO.builder()
                    .id(c.getId())
                    .comment_content(c.getCommentContent())
                    .star_cnt(c.getStar_cnt())
                    .member_id(c.getMember().getId())
                    .post_id(c.getPost().getId())
                    .build();

            cdtolist.add(cdto);
        }

        return cdtolist;
    }
}
