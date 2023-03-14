package com.example.server.servise;

import com.example.server.entity.PublisherEntity;
import com.example.server.exception.ValidationExceptionPublisher;
import com.example.server.repo.PublisherRepo;
import com.example.server.utils.PublisherValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    private final PublisherRepo repo;
    public PublisherService(PublisherRepo repo){this.repo = repo; }

    public PublisherEntity save(PublisherEntity publisher) throws ValidationExceptionPublisher {
        PublisherValidationUtils.validationPublisher(publisher);
        return repo.save(publisher);

    }
}
