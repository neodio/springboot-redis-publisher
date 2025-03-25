package redis.publisher.config.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;
import redis.publisher.dto.RedisData;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisMessagePublisher {
    private final RedisTemplate<String, Object> redisTemplate;

    private final ChannelTopic topic;

    public void publish(RedisData redisData) {
        log.info("Publishing message on Redis channel {} with content: {}", topic.getTopic(), redisData.toString());
        redisTemplate.convertAndSend(topic.getTopic(), redisData);
    }
}
