package com.SpaceFinders.Sprint_2.Service;
import com.SpaceFinders.Sprint_2.DTO.ExtrasDTO;
import com.SpaceFinders.Sprint_2.Entity.Extras;
import com.SpaceFinders.Sprint_2.Repository.ExtrasRepository;
import com.SpaceFinders.Sprint_2.Utility.AlreadyExistsException;
import com.SpaceFinders.Sprint_2.Utility.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExtrasService {

    @Autowired
    ExtrasRepository extrasRepository;

    private Extras convertToEntity (ExtrasDTO dto){
        Extras extras = new Extras();
        extras.setExtrasName(dto.getExtrasName());
        extras.setExtrasIsActive(dto.getExtrasIsActive());
        return extras;
    }

    private ExtrasDTO convertToDTO (Extras extras){
        ExtrasDTO dto = new ExtrasDTO();
        dto.setExtrasName(extras.getExtrasName());
        dto.setExtrasIsActive(extras.getExtrasIsActive());
        return dto;
    }

    public ResponseEntity<String> addExtras (ExtrasDTO dto){
        Extras extras = convertToEntity(dto);
        if(extrasRepository.existsByExtrasNameIgnoreCase(extras.getExtrasName())){
            throw new AlreadyExistsException("The Extra Service " + extras.getExtrasName() + " already exists");
        }

        extrasRepository.save(extras);
        return ResponseEntity.status(HttpStatus.CREATED).body("Extras has been added successfully");
    }

//    public ResponseEntity<ExtrasDTO> updateExtrasIsActive (int extras_id, ExtrasDTO dto){
//        Optional<Extras> extras= extrasRepository.findById(extras_id);
//        if (extras.isEmpty()){
//            throw new DataNotFoundException("The extras id " + extras_id + " does not exists");
//        }
//
//        Extras ex = extras.get();
//        ex.setExtrasIsActive(dto.getExtrasIsActive());
//
//        return ResponseEntity.accepted().body(convertToDTO(extrasRepository.save(ex)));
//    }

    public ResponseEntity<ExtrasDTO> updateExtras(int extras_id, ExtrasDTO dto){
        Optional<Extras> extras = extrasRepository.findById(extras_id);
        if (extras.isEmpty()){
            throw new DataNotFoundException("The extras id " + extras_id + " does not exists");
        }

        Extras ex = extras.get();
        if(dto.getExtrasName() != null && !dto.getExtrasName().isBlank()){
            ex.setExtrasName(dto.getExtrasName());
        }

        ex.setExtrasIsActive(dto.getExtrasIsActive());

        return ResponseEntity.accepted().body(convertToDTO(extrasRepository.save(ex)));
    }

    public ResponseEntity<List<Extras>> viewAllExtras(){
        List<Extras> extrasList = extrasRepository.findAll();
        return ResponseEntity.ok().body(extrasList);
    }

    public ResponseEntity<ExtrasDTO> findByExtrasName(String extrasName){
        Extras extras = extrasRepository.findByExtrasNameIgnoreCase(extrasName);
        if (extras == null){
            throw new DataNotFoundException("The extras " + extrasName+ " is not available");
        }

        return ResponseEntity.ok().body(convertToDTO(extras));
    }

    public ResponseEntity<List<ExtrasDTO>> findAllByExtrasIsActive(boolean extrasIsActive){
        List<Extras> extrasList = extrasRepository.findAllByExtrasIsActive(extrasIsActive);
        if (extrasList.isEmpty()){
            throw new DataNotFoundException ("No data with the required status is available");
        }

        List<ExtrasDTO> dtos = new ArrayList<>();
        for (Extras extras : extrasList){
            dtos.add(convertToDTO(extras));
        }

        return ResponseEntity.ok().body(dtos);
    }

}