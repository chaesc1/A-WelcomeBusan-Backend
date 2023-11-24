package HackA.server.web.controller;

import HackA.server.dto.request.PostRequsetDTO;
import HackA.server.dto.response.PostResponseDTO;
import HackA.server.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {
    PostService postService;
    //게시물 가져오기
    @GetMapping("/read")
    public ResponseEntity<PostResponseDTO> getRead(@RequestParam Long id) {
        return ResponseEntity.ok(postService.read(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Boolean> postSave(@RequestBody PostRequsetDTO postRequsetDTO){
        try{
            postService.savePost(postRequsetDTO);
        }catch (Exception e) {
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateSave(@RequestBody PostRequsetDTO postRequsetDTO){
        try{
            postService.updatePost(postRequsetDTO);
        } catch (Exception e) {
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> getDelete(@RequestParam Long id) {
        return ResponseEntity.ok(postService.deletePost(id));
    }

}
