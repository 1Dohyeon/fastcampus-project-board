package com.fastcampus.projectboard.repository;

import com.fastcampus.projectboard.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

// ArticleComment 엔티티를 다루기 위한 레포지토리
public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}

/* 자세한 설명:
* import com.fastcampus.projectboard.domain.ArticleComment;:
* ArticleComment 엔티티를 사용하기 위해 해당 엔티티를 import 합니다.
* 이 엔티티는 com.fastcampus.projectboard.domain 패키지에 정의되어 있어야 합니다.

* import org.springframework.data.jpa.repository.JpaRepository;:
* Spring Data JPA 프레임워크에서 제공하는 JpaRepository 인터페이스를 import 합니다.
* 이 인터페이스는 Spring Data JPA에서 기본적인 CRUD (Create, Read, Update, Delete) 작업을 수행하기 위한 메서드를 제공합니다.

* public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> { }:
* ArticleCommentRepository 인터페이스를 정의합니다.
* 이 인터페이스는 JpaRepository를 확장하며,
* 제네릭 형태로 엔티티 클래스(ArticleComment)와 해당 엔티티의 기본 키 타입(Long)을 지정합니다.
* 이렇게 함으로써 Spring Data JPA가 ArticleComment 엔티티와 관련된 데이터베이스 작업을 처리할 수 있도록 합니다.

* ArticleCommentRepository는 이제 ArticleComment 엔티티와 관련된 데이터베이스 작업을 쉽게 수행할 수 있는 메서드를 상속받고 있으며,
* 이 인터페이스를 사용하여 데이터베이스에서 게시물 댓글과 관련된 정보를 조회, 저장, 수정, 삭제할 수 있습니다.
* Spring Data JPA는 레포지토리 인터페이스를 구현 클래스를 자동으로 생성하므로,
* 개발자는 구현 코드를 작성하지 않아도 데이터베이스 작업을 수행할 수 있습니다.
* */


