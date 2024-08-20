package com.patika.bloghubindexservice.repository;

import com.patika.bloghubindexservice.model.document.BlogDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BlogRepository extends ElasticsearchRepository<BlogDocument, Long> {
}
