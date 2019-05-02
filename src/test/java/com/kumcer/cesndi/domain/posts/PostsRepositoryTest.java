package com.kumcer.cesndi.domain.posts;

import com.kumcer.cesndi.domain.posts.Posts;
import com.kumcer.cesndi.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        // 테스트 메소드가 끝날때마다 respository 전체 비우는 코드
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        // given 테스트 기반 환경 구축
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("test@naver.com")
                .build());

        // when 테스트 하고자 하는 행위 선언
        List<Posts> postsList = postsRepository.findAll();

        // hen 테스트 결과 검증
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }

    @Test
    public void BaseTimeEntity_등록() {
        // given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
        .title("타이틀")
        .content("본문")
        .author("작성자")
        .build());

        // when 테스트 하고자 하는 행위 선언
        List<Posts> postsList = postsRepository.findAll();

        // then 테스트 결과 검증
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}

