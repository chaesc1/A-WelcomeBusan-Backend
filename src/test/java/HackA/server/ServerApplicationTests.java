package HackA.server;

import HackA.server.domain.Post;
import HackA.server.dto.request.PostRequsetDTO;
import HackA.server.repository.PostRepository;
import HackA.server.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerApplicationTests {

    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRequsetDTO;

    @Test
    void createPost() {
        PostRequsetDTO postRequsetDTO = PostRequsetDTO.builder()
                .title("test")
                .content("test contetn")
                .hits(123241)
                .build();

        postService.savePost(postRequsetDTO);
    }

    @Test
    void updatePost() {
        PostRequsetDTO postRequsetDTO = PostRequsetDTO.builder()
                .id(2L)
                .title("test213123")
                .content("tes123123312t contetn")
                .hits(11111)
                .build();

        postService.updatePost(postRequsetDTO);
    }

    @Test
    void deletePost() {
        PostRequsetDTO postRequsetDTO = PostRequsetDTO.builder()
                .id(2L)
                .build();

        postService.deletePost(postRequsetDTO.getId());
    }
}
