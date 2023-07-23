package com.example.demo.entity;

import com.example.demo.dto.test.TestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "TestEntity")
@NoArgsConstructor
@AllArgsConstructor
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int age;

    public static TestEntity createTestDtoFromEntity(TestDto testDto){
        return TestEntity.builder()
                .name(testDto.getName())
                .age(testDto.getAge())
                .build();
    }
}
