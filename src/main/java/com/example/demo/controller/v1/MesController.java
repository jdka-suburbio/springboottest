package com.example.demo.controller.v1;

import com.example.demo.Entity.MesEntity;
import com.example.demo.service.MesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mes")
@CrossOrigin(origins = "*")
public class MesController {

    @Autowired
    private MesService mesService;

    @GetMapping
    List<MesEntity> getMes(){
        return mesService.getAllMes();
    }

    @PostMapping
    public MesEntity createMes(@RequestBody MesEntity mesEntity) {
        return mesService.saveMes(mesEntity);
    }

    @GetMapping("/{id}")
    public Optional<MesEntity> getMesById(@PathVariable Long id) {
        return mesService.getMesById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMes(@PathVariable Long id) {
        if(!mesService.deleteMes(id))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Mes deleted successfully");
    }
}

