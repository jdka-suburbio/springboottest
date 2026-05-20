package com.example.demo.service;

import com.example.demo.Entity.MesEntity;
import com.example.demo.repository.MesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesService {
    @Autowired
    private MesRepository mesRepository;

    public List<MesEntity> getAllMes()
    {
        return mesRepository.findAll();
    }

    public Optional<MesEntity> getMesById(Long id) {
        return mesRepository.findById(id);
    }

    public MesEntity saveMes(MesEntity mesEntity) {
        return mesRepository.save(mesEntity);
    }

    public boolean deleteMes(Long id)
    {
        if (!mesRepository.existsById(id)) {
            return false;
        }
        mesRepository.deleteById(id);
        return true;
    }
}
