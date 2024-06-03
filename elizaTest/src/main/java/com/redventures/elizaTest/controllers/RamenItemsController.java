//package com.redventures.elizaTest.controllers;
//
//import com.redventures.elizaTest.model.Broth;
//import com.redventures.elizaTest.model.Protein;
//import com.redventures.elizaTest.services.RamenItemsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("")
//public class RamenItemsController {
//
//    @Qualifier("ramenItemsServiceImpl")
//    @Autowired
//    private RamenItemsService service;
//
//    @PostMapping("/postBroth")
//    public ResponseEntity<Broth> postBroth(@RequestBody Broth broth) {
//        try {
//             return ResponseEntity.status(201).body(service.postNewBroth(broth));
//        } catch (Error e) {
//            return ResponseEntity.status(402).build();
//        }
//    }
//
//    @PostMapping("/postProtein")
//    public ResponseEntity<Protein> postBroth(@RequestBody Protein protein) {
//        try {
//            return ResponseEntity.status(201).body(service.postNewProtein(protein));
//        } catch (Error e) {
//            return ResponseEntity.status(402).build();
//        }
//    }
//
//}
