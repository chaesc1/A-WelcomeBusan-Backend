package HackA.server.service;

import HackA.server.dto.request.PostRequsetDTO;
import HackA.server.dto.response.PostResponseDTO;
import lombok.Builder;
import lombok.Getter;

public interface PostService {
    public PostResponseDTO read(Long id);

    public boolean savePost(PostRequsetDTO postRequsetDTO);

    public boolean updatePost(PostRequsetDTO postRequsetDTO);

    public boolean deletePost(Long id);
}
