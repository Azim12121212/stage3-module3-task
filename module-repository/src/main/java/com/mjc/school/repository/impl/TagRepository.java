package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.model.TagModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Repository
public class TagRepository implements BaseRepository<TagModel, Long> {
    @PersistenceContext
    private EntityManager entityManager;

    public TagRepository() {
    }

    @Override
    public List<TagModel> readAll() {
        return entityManager.createQuery("SELECT t FROM TagModel t", TagModel.class).getResultList();
    }

    @Override
    public Optional<TagModel> readById(Long id) {
        return Optional.ofNullable(entityManager.find(TagModel.class, id));
    }

    @Transactional
    @Override
    public TagModel create(TagModel entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    @Override
    public TagModel update(TagModel entity) {
        TagModel tagModel = null;
        if (existById(entity.getId())) {
            tagModel = entityManager.find(TagModel.class, entity.getId());
            tagModel.setName(entity.getName());
            entityManager.merge(tagModel);
        }
        return tagModel;
    }

    @Transactional
    @Override
    public boolean deleteById(Long id) {
        if (existById(id)) {
            entityManager.remove(entityManager.find(TagModel.class, id));
            return true;
        }
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return entityManager.getReference(TagModel.class, id)!=null;
    }

    // Get News by tag id
    public List<NewsModel> getNewsByTagId(Long id) {
        Set<NewsModel> newsModelSet = entityManager.find(TagModel.class, id).getNewsModelSet();
        List<NewsModel> newsModelList = new ArrayList<>(newsModelSet);
        return newsModelList;
    }

    // Get News by tag name
    public List<NewsModel> getNewsByTagName(String name) {
        Query query = entityManager.createQuery("SELECT t FROM TagModel t WHERE t.name LIKE :name")
                .setParameter("name", "%" + name + "%");

        List<TagModel> tagModelList = query.getResultList();

        Set<NewsModel> newsModelSet = new HashSet<>();
        for (NewsModel newsModel: tagModelList.iterator().next().getNewsModelSet()) {
            newsModelSet.add(newsModel);
        }

        List<NewsModel> newsModelList = new ArrayList<>(newsModelSet);

        return newsModelList;
    }
}