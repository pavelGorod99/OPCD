package com.vallerry.opcd.service;

import com.vallerry.opcd.data.NewsRepository;
import com.vallerry.opcd.model.News;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public Iterable<News> findAll() {
        return newsRepository.findAll();
    }
}
