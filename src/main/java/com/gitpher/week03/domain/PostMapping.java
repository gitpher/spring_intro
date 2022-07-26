package com.gitpher.week03.domain;


import java.time.LocalDateTime;

public interface PostMapping {
    LocalDateTime getCreateAt();
    LocalDateTime getModifiedAt();
    Long getId();
    String getTitle();
    String getUsername();

}
