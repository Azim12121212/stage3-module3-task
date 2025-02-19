package com.mjc.school.service.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class AuthorDtoResponse {
    private Long id;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private List<NewsDtoResponse> newsDtoResponseList;

    public AuthorDtoResponse() {
    }

    public AuthorDtoResponse(String name) {
        this.name = name;
    }

    public AuthorDtoResponse(Long id, String name, LocalDateTime createDate,
                             LocalDateTime lastUpdateDate, List<NewsDtoResponse> newsDtoResponseList) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.newsDtoResponseList = newsDtoResponseList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public List<NewsDtoResponse> getNewsDtoResponseList() {
        return newsDtoResponseList;
    }

    public void setNewsDtoResponseList(List<NewsDtoResponse> newsDtoResponseList) {
        this.newsDtoResponseList = newsDtoResponseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDtoResponse that = (AuthorDtoResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(createDate, that.createDate) && Objects.equals(lastUpdateDate, that.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createDate, lastUpdateDate);
    }

    @Override
    public String toString() {
        return "AuthorDtoResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}