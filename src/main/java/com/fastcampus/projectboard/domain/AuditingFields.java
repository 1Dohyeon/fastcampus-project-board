package com.fastcampus.projectboard.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass   // 다른 엔티티 클래스에서 사용할 수 있음.
public class AuditingFields {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createAt;     // 생성일시

    @CreatedBy
    @Column(nullable = false, updatable = false, length = 100)
    private String createBy;            // 생성자

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime ModifiedAt;   // 수정일시

    @LastModifiedBy
    @Column(nullable = false, length = 100)
    private String modifiedBy;          // 수정자
}

/* 자세한 설명:
* 이 코드는 JPA(Java Persistence API) 엔티티 클래스에서 공통으로 사용되는
* 감사(Auditing) 관련 필드와 어노테이션을 정의한 클래스입니다.
* 이 클래스는 다른 JPA 엔티티 클래스에서 상속되어 재사용될 수 있으며,
* 엔티티의 생성일시, 생성자, 수정일시, 수정자를 추적하고 저장하는 데 사용됩니다.

@Getter와 @ToString:
* Lombok 어노테이션인 @Getter는 클래스 내의 필드에 대한 Getter 메서드를 자동으로 생성하고,
* @ToString은 toString() 메서드를 자동으로 생성합니다.
* 이를 통해 코드의 간결성을 유지하면서 Getter 및 toString() 메서드를 생성할 수 있습니다.

@EntityListeners(AuditingEntityListener.class):
* 이 어노테이션은 JPA 엔티티 클래스의 변경 사항을 추적하고 감사 관련 기능을 활성화하기 위한 리스너를 설정합니다.
* AuditingEntityListener 클래스는 Spring Data JPA에서 제공하는 감사 관련 리스너입니다.

@MappedSuperclass:
* 이 어노테이션은 해당 클래스가 JPA 엔티티 클래스가 아니라 다른 엔티티 클래스에서 상속될 클래스임을 나타냅니다.
* 이 클래스의 필드와 메서드는 다른 엔티티 클래스에서 재사용될 수 있습니다.

감사 관련 필드:

* createAt:
* 엔티티의 생성일시를 저장하는 필드입니다.
* @CreatedDate 어노테이션과 함께 사용되며, updatable = false로 설정되어 엔티티가 수정될 때 변경되지 않도록 합니다.

* createBy:
* 엔티티를 생성한 사용자의 이름을 저장하는 필드입니다.
* @CreatedBy 어노테이션과 함께 사용되며, updatable = false로 설정되어 엔티티가 수정될 때 변경되지 않도록 합니다.

* ModifiedAt:
* 엔티티의 최종 수정일시를 저장하는 필드입니다.
* @LastModifiedDate 어노테이션과 함께 사용되며, 항상 업데이트됩니다.

* modifiedBy:
* 엔티티를 최종 수정한 사용자의 이름을 저장하는 필드입니다.
* @LastModifiedBy 어노테이션과 함께 사용되며, 항상 업데이트됩니다.

* @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME):
* 이 어노테이션은 날짜와 시간을 특정 ISO 형식에 맞게 직렬화하거나 역직렬화할 때 사용됩니다.
* 여기서는 날짜 및 시간 형식을 ISO 형식으로 지정합니다.

* 이 클래스를 다른 JPA 엔티티 클래스에서 상속받으면
* 해당 엔티티 클래스는 자동으로 생성일시, 생성자, 수정일시, 수정자를 감사 관련 필드로 사용할 수 있으며,
* Spring Data JPA의 감사 기능을 활용하여 이러한 필드의 값을 자동으로 업데이트할 수 있습니다.
* */
