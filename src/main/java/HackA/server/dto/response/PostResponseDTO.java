package HackA.server.dto.response;

import HackA.server.domain.Post;
import HackA.server.dto.request.PostRequsetDTO;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class PostResponseDTO {
    private Long id;
    private String title;
    private String content;
    private int hits;

    public static Post toEntity(PostResponseDTO postResponseDTO) {
        return Post.builder()
                .id(postResponseDTO.getId())
                .title(postResponseDTO.getTitle())
                .content(postResponseDTO.getContent())
                .hits(postResponseDTO.getHits())
                .build();
    }
}
