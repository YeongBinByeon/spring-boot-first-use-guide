package com.example.demo.service;

import com.example.demo.dto.test.TestDto;
import com.example.demo.entity.TestEntity;
import com.example.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    public void saveEntity(TestDto testDto){
        TestEntity testEntity = TestEntity.createTestDtoFromEntity(testDto);
        testRepository.save(testEntity);
    }

    public List<TestEntity> getAllTestEntity(){
        return testRepository.findAllEntity();
    }

}
