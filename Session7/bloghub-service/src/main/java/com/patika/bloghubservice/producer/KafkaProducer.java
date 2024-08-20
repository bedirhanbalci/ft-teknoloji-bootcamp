package com.patika.bloghubservice.producer;

import com.patika.bloghubservice.constant.KafkaTopicConstants;
import com.patika.bloghubservice.model.Blog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public final class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendBlog(Blog blog) {

        log.info("blog gönderildi: {}", blog.getId());
        kafkaTemplate.send(KafkaTopicConstants.BLOG_INDEX_TOPIC, blog);

    }

}
