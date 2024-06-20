package com.example.demo.services;
import com.example.demo.exceptions.AlreadyExistACategoryWithTheSameNameException;
import com.example.demo.model.OutFlow;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.OutFlowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class OutFlowService {

    @Autowired
    private final OutFlowRepository outFlowRepository;

    public OutFlow createOutFlow(OutFlow outFlow){
        return outFlowRepository.save(outFlow);
    }
}
