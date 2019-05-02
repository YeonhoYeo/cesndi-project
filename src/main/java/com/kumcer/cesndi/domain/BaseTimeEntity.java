package com.kumcer.cesndi.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // 위 클래스 상속시 아래 필드들도 컬럼으로 인식함
@EntityListeners(AuditingEntityListener.class)  // BaseTimeEntity 에 Auditing 기능 포함
public abstract class BaseTimeEntity {

    @CreatedDate    // 엔티티 생성시 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate   // 엔티티 변경시 자동 저장
    private LocalDateTime modifiedDate;
}
