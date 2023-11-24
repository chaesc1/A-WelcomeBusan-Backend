package HackA.server.dto.request;

import HackA.server.domain.Post;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostRequsetDTO {
    private Long id;
    private String title;
    private String content;
    private int hits;
    private String userid;
    public static Post toEntity(PostRequsetDTO dto) {
        return Post.builder()
                .id(dto.getId()) // DTO의 id를 엔티티의 id에 매핑
                .title(dto.getTitle()) // DTO의 title을 엔티티의 title에 매핑
                .content(dto.getContent()) // DTO의 content를 엔티티의 content에 매핑
                .hits(dto.getHits()) // DTO의 hits를 엔티티의 hits에 매핑
                .build(); // 빌더를 통해 엔티티 객체 생성
    }
}
