package com.olegshishkin.ocdemo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@Builder
@EqualsAndHashCode(of = {"name"})
@ToString
@DynamicInsert
@DynamicUpdate
@Entity
public class Person {

    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
}
