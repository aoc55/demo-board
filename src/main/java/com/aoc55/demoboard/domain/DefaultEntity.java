package com.aoc55.demoboard.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

/**
 * Default Entity
 * Created by aoc55.soft@gmail.com
 */
@MappedSuperclass
@Getter @Setter
public class DefaultEntity {
    @CreatedDate
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }

}
