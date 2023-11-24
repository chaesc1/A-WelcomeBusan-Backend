package HackA.server;

import HackA.server.domain.Post;
import HackA.server.dto.request.CommentRequsetDTO;
import HackA.server.dto.request.PostRequsetDTO;
import HackA.server.dto.response.PostResponseDTO;
import HackA.server.repository.PostRepository;
import HackA.server.service.PostService;
import HackA.server.web.controller.LoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerApplicationTests {

    @Autowired
    PostService postService;

    @Autowired
    LoginController loginController;

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
    void readPost() {
        PostRequsetDTO postRequsetDTO = PostRequsetDTO.builder()
                .id(3L)
                .build();


        postService.read(postRequsetDTO.getId());
    }
    @Test
    void updatePost() {
        PostRequsetDTO postRequsetDTO = PostRequsetDTO.builder()
                .id(1L)
                .userid("13")
                .title("asd")
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

    @Test
    void readComment() {
//        CommentRequsetDTO commentRequsetDTO = CommentRequsetDTO.builder()
//                .id()
        PostResponseDTO p = postService.read(3L);

        System.out.println(p.getCommentResponseDTOList().get(0).toString());
        System.out.println(p.getCommentResponseDTOList().get(1).toString());
    }

}
