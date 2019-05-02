package com.kumcer.cesndi.domain.posts;

import com.kumcer.cesndi.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)      // 롬복 기본 생성자 자동추가 및 접슨 권한을 protected로 제한
@Getter     // 클래스내 모든 필드의 Getter 메소드 자동생성
@Entity     // 테이블과 링크되는 클래스 나타냄 SalesManager.java -> sales_manager table
public class Posts extends BaseTimeEntity {

    @Id     // 테이블 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // PK생성규칙 기본값 AUTO
    private Long id;

    @Column(length = 500, nullable = false)     // 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼, 사용하는 이유는 추가로 변경이 필요한 옵션이 있을경우
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    // 빌더패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
