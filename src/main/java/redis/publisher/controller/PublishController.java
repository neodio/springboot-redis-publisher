package redis.publisher.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import redis.publisher.config.publisher.RedisMessagePublisher;
import redis.publisher.dto.RedisData;

@RestController
@RequiredArgsConstructor
public class PublishController {

    private final RedisMessagePublisher redisMessagePublisher;

    @PostMapping("/api/send")
    public ResponseEntity<String> sendMessage(@RequestBody RedisData redisData) {
        redisMessagePublisher.publish(redisData);
        return ResponseEntity.ok("Message sent: " + redisData);
    }
}
