package HackA.server.service;

import HackA.server.domain.Member;
import HackA.server.repository.MemberRepository;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class LoginService {

    private final Environment env;
    private final MemberRepository memberRepository;

    private final RestTemplate restTemplate = new RestTemplate();

//    public LoginService(Environment env) {
//        this.env = env;
//    }

    public String socialLogin(String code, String registrationId) {
//        log.info("error point::{}", code);
        String accessToken = getAccessToken(code, registrationId);
        JsonNode userResourceNode = getUserResource(accessToken, registrationId);
        System.out.println("userResourceNode = " + userResourceNode);

        String id = userResourceNode.get("id").asText();
        String email = userResourceNode.get("email").asText();
        String nickname = userResourceNode.get("name").asText();
        System.out.println("id = " + id);
        System.out.println("email = " + email);
        System.out.println("nickname = " + nickname);
        //정보 확인 후 쿠키 아이디 생성

        //Insert
        Optional<Member> optionalMember = memberRepository.findByGoogleId(id);
//        log.info("error point::{}",optionalMember);
        Member member = optionalMember.orElse(null);
        if (member == null) {
            member = Member.builder()
                    .nickname(nickname)
                    .googleId(id)
                    .build();
            memberRepository.save(member);
        }
        return member.getGoogleId();
    }

    private String getAccessToken(String authorizationCode, String registrationId) {
//        System.out.println("asdasdsad"+env);
        String clientId = env.getProperty("oauth2." + registrationId + ".client-id");
        String clientSecret = env.getProperty("oauth2." + registrationId + ".client-secret");
        log.info("client Secret::{}", clientSecret);
        String redirectUri = env.getProperty("oauth2." + registrationId + ".redirect-uri");
        String tokenUri = env.getProperty("oauth2." + registrationId + ".token-uri");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("code", authorizationCode);
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("redirect_uri", redirectUri);
        params.add("grant_type", "authorization_code");
        System.out.println(params);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity entity = new HttpEntity(params, headers);
        ResponseEntity<JsonNode> responseNode = restTemplate.exchange(tokenUri, HttpMethod.POST, entity,
                JsonNode.class);
        JsonNode accessTokenNode = responseNode.getBody();
        return accessTokenNode.get("access_token").asText();
    }

    private JsonNode getUserResource(String accessToken, String registrationId) {
        String resourceUri = env.getProperty("oauth2." + registrationId + ".resource-uri");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity entity = new HttpEntity(headers);
        return restTemplate.exchange(resourceUri, HttpMethod.GET, entity, JsonNode.class).getBody();
    }
}