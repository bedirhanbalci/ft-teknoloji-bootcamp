package com.patika.bloghubindexservice.consumer;

import com.patika.bloghubindexservice.consumer.constants.KafkaTopicConstants;
import com.patika.bloghubindexservice.model.Blog;
import com.patika.bloghubindexservice.model.document.BlogDocument;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ElasticsearchOperations elasticsearchOperations;

    @KafkaListener(topics = KafkaTopicConstants.BLOG_INDEX_TOPIC, groupId = "${kafka.group-id}")
    public void listen(Blog blog) {
        log.info("Received Messasge: {}", blog);

        IndexQuery indexQuery = new IndexQuery();
        indexQuery.setId(blog.getId().toString());
        indexQuery.setObject(prepareBlogDocument(blog));
        elasticsearchOperations.index(indexQuery, IndexCoordinates.of("blog"));
    }

    private BlogDocument prepareBlogDocument(Blog blog) {

        BlogDocument blogDocument = new BlogDocument();
        blogDocument.setId(blog.getId());
        blogDocument.setTitle(blog.getTitle());
        blogDocument.setText(blog.getText());
        blogDocument.setCreatedDate(blog.getCreatedDate());
        return blogDocument;
    }

}
