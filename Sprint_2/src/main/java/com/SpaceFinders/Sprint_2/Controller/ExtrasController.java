package com.SpaceFinders.Sprint_2.Controller;


import com.SpaceFinders.Sprint_2.DTO.ExtrasDTO;
import com.SpaceFinders.Sprint_2.Entity.Extras;
import com.SpaceFinders.Sprint_2.Service.ExtrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/property/extras")
public class ExtrasController {
    @Autowired
    ExtrasService extrasService;

    @PostMapping("/addExtras")
    public ResponseEntity<String> addExtras (@RequestBody ExtrasDTO dto){
        return extrasService.addExtras(dto);
    }

    @PutMapping("/updateExtras")
    public ResponseEntity<ExtrasDTO> updateExtras(@RequestParam int extras_id, @RequestBody ExtrasDTO dto){
        return extrasService.updateExtras(extras_id, dto);
    }

//    @PatchMapping("/updateExtrasStatus")
//    public ResponseEntity<ExtrasDTO> updateExtrasIsActive(@RequestParam int extras_id, @RequestBody ExtrasDTO dto){
//        return extrasService.updateExtrasIsActive(extras_id, dto);
//    }

    @GetMapping("/findByExtrasName")
    public ResponseEntity<ExtrasDTO> findByExtrasName(@RequestParam String extrasName){
        return extrasService.findByExtrasName(extrasName);
    }

    @GetMapping("/findAllByExtrasStatus")
    public ResponseEntity<List<ExtrasDTO>> findAllByExtrasStatus(@RequestParam boolean extrasIsActive){
        return extrasService.findAllByExtrasIsActive(extrasIsActive);
    }

    @GetMapping("/viewAllExtras")
    public ResponseEntity<List<Extras>> viewAllExtras() {
        return extrasService.viewAllExtras();
    }
}