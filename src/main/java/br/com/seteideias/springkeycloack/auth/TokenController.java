package br.com.seteideias.springkeycloack.auth;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TokenController {
    @PostMapping("/token")
    public ResponseEntity<String> newToken(@RequestBody  User user){

        HttpHeaders httpHeaders = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        LinkedMultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id",user.clientId());
        formData.add("username",user.userName);
        formData.add("password",user.password());
        formData.add("grant_type",user.grantType());

        HttpEntity<MultiValueMap<String, String>> multiValueMapHttpEntity = new HttpEntity<>(formData, httpHeaders);

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:8080/realms/youtube/protocol/openid-connect/token", multiValueMapHttpEntity,
                String.class);

        return stringResponseEntity;

    }

    public record User(String password, String clientId, String grantType, String userName){}

}
