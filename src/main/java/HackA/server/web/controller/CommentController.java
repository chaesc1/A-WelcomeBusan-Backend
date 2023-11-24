package HackA.server.web.controller;

import HackA.server.dto.request.CommentRequsetDTO;
import HackA.server.dto.response.CommentResponseDTO;
import HackA.server.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
//@NoArgsConstructor
public class CommentController {
    CommentService commentService;

    @GetMapping("/read")
    public ResponseEntity<CommentResponseDTO> getRead(@RequestParam Long id) {
        return ResponseEntity.ok(commentService.read(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Boolean> commentSave(@RequestBody CommentRequsetDTO commentRequsetDTO) {
        try{
            commentService.saveComment(commentRequsetDTO);
        } catch(Exception e) {
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateSave(@RequestBody CommentRequsetDTO commentRequsetDTO) {
        try{
            commentService.updateComment(commentRequsetDTO);
        } catch (Exception e) {
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> getDelete(@RequestParam Long id) {
        return ResponseEntity.ok(commentService.deleteComment(id));
    }
}
