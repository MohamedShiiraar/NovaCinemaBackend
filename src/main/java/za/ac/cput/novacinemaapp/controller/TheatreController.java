package za.ac.cput.novacinemaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.novacinemaapp.domain.Theatre;
import za.ac.cput.novacinemaapp.service.TheatreService;

import java.util.Set;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
    @Autowired
    TheatreService theatreService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Theatre theatre){
        Theatre created = theatreService.create(theatre);
        if (created==null){
            return ResponseEntity.badRequest().body("Error Creating Theatre");
        }
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PostMapping("/read{theatreID}")
    public ResponseEntity<?> get(@PathVariable String theatreID){
        Theatre theatre = theatreService.read(theatreID);
        if (theatre==null){
            return ResponseEntity.badRequest().body("Theatre with theatreID: "+theatreID+" does not exist");
        }
        return ResponseEntity.ok(theatre);
    }

    @PostMapping("/getAll")
    public Set<Theatre> getAll(){
        return theatreService.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Theatre theatre){
        Theatre updatedTheatre = theatreService.update(theatre);
        if (updatedTheatre==null){
            return ResponseEntity.badRequest().body("Error Updating theatre");
        }
        return ResponseEntity.ok(updatedTheatre);
    }
}
