package com.example.projectmanagementtools.controller;

import com.example.projectmanagementtools.entity.Do;
import com.example.projectmanagementtools.service.DoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoController {
    private DoService doService;

    public DoController(DoService doService) {
        this.doService = doService;
    }
    @GetMapping("/do")
    public List<Do> getAllDoRel(){
        return this.doService.findAllDoRelation();
    }

    @GetMapping("/do/{id}")
    public Optional<Do> getDoRelById(@PathVariable int id){
        return this.doService.findDoRelationById(id);
    }

    @PostMapping("/do")
    public Do insertDoRel(@RequestBody Do toInsert){
        return this.doService.insert(toInsert);
    }

    @PutMapping("/do/{id}")
    public Do updateDoRel(@PathVariable int id, @RequestBody Do updateDo) {
        if (updateDo.getIdDo() != id) {
            throw new IllegalArgumentException("The ID provided in the request body does not match the ID in the path.");
        }
        return this.doService.updateDoRelation(updateDo);
    }
    @DeleteMapping("/do/{id}")
    public ResponseEntity<String> deleteDoRel(@PathVariable int id) {
        doService.deleteDoRelation(id);
        return ResponseEntity.ok("Deleted with success");
    }
}
