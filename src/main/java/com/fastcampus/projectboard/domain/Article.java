package com.fastcampus.projectboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createAt"),
        @Index(columnList = "createBy"),
})
@Entity // 데이터베이스 테이블과 매핑
// 1도메인 = 1엔티티 : Article 도메인 클래스를 JPA 엔티티로 사용
public class Article extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Setter @Column(nullable = false)                   private String title;   // 제목
    @Setter @Column(nullable = false, length = 10000)   private String content; // 본문
    
    @Setter private String hashtag; // 해시태그, null 가능

    @ToString.Exclude   // ToString의 무한 반복을 끊는 어노테이션
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    protected Article() {}

    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    // of 메서드를 통해 Article 필드 생성
    public static Article of(String title, String content, String hashtag) {
        return new Article(title, content, hashtag);
    }

    // equals로 id를 비교하고, hashcode를 이용하여 각각 다른 id를 부여
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id != null && Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

/* 자세한 설명:
* 이 코드는 Spring Boot 애플리케이션에서 사용되는 JPA(Java Persistence API)
* 엔티티 클래스인 Article 클래스에 대한 내용.

@Entity:
* 이 어노테이션은 엔티티 클래스임을 나타냅니다.
* Article 클래스는 데이터베이스 테이블과 매핑되는 JPA 엔티티입니다.

@Table:
* 이 어노테이션은 엔티티 클래스와 매핑되는 데이터베이스 테이블의 추가 정보를 정의합니다.
* 여기서는 indexes 속성을 사용하여 테이블의 인덱스를 정의하고 있습니다.
* 인덱스는 특정 열(column)에 대한 빠른 검색을 지원하며, columnList 속성을 사용하여 인덱스를 생성할 열을 지정합니다.

@Id:
* 이 어노테이션은 엔티티의 기본 키(primary key) 필드를 나타냅니다.
* Article 엔티티의 기본 키는 id 필드입니다.

@GeneratedValue(strategy = GenerationType.IDENTITY):
* 이 어노테이션은 기본 키 필드의 값을 자동으로 생성하는 방법을 설정합니다.
* 여기서는 데이터베이스에서 자동 증가(auto-increment)하는 방식을 사용하여 기본 키 값을 생성하도록 설정되어 있습니다.

@Column:
* 이 어노테이션은 엔티티 클래스의 필드를 데이터베이스 열(column)과 매핑할 때 사용됩니다.
* nullable 속성을 사용하여 열이 NULL 값을 허용하는지 여부를 설정하고, length 속성을 사용하여 열의 최대 길이를 지정합니다.
* 여기서는 title 및 content 필드에 사용되었습니다.

@Setter:
* Lombok 라이브러리에서 제공하는 어노테이션으로, 필드에 대한 Setter 메서드를 자동으로 생성합니다.
* 필드의 값을 변경하기 위한 메서드를 생성합니다.

@ToString:
* Lombok 라이브러리에서 제공하는 어노테이션으로, toString() 메서드를 자동으로 생성합니다.
* 이를 통해 객체의 문자열 표현을 간편하게 출력할 수 있습니다.

@OrderBy:
* 이 어노테이션은 엔티티 클래스의 관계를 정렬할 때 사용됩니다.
* 여기서는 articleComments 필드를 id를 기준으로 오름차순 정렬하도록 설정되어 있습니다.

@OneToMany:
* 이 어노테이션은 엔티티 클래스 간의 일대다 관계를 정의합니다.
* mappedBy 속성을 사용하여 연관된 엔티티 클래스의 필드를 지정하고,
* cascade 속성을 사용하여 연관된 엔티티의 라이프사이클을 관리합니다.
* 여기서는 ArticleComment 엔티티와의 일대다 관계를 설정하고 있습니다.

Article.of():
* 이 메서드는 Article 엔티티를 생성하는 정적 팩토리 메서드입니다.
* 객체 생성을 추상화하여 객체 생성 시 매개변수를 전달하도록 도와줍니다.

equals() 및 hashCode():
* 이 두 메서드는 객체의 동등성 비교 및 해시코드 생성을 담당합니다.
* equals() 메서드에서는 id 필드를 기준으로 객체들을 비교하고, hashCode() 메서드에서는 id를 사용하여 객체의 해시코드를 생성합니다.
* 이를 통해 객체를 컬렉션에 저장하거나 검색할 때 올바르게 동작하도록 합니다.

* Article 클래스는 게시물을 나타내는 JPA 엔티티이며,
* 감사 관련 필드 및 게시물의 제목, 내용, 해시태그, 댓글 등의 정보를 포함하고 있습니다.
* JPA를 사용하여 데이터베이스와 상호작용하고, Lombok을 활용하여 코드를 간결하게 작성하고 있습니다.
* */
