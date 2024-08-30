package za.ac.cput.novacinemaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.novacinemaapp.domain.Seat;
import za.ac.cput.novacinemaapp.service.SeatService;

import java.util.Set;

@RestController
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    SeatService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Seat seat){
        Seat createdSeat = service.create(seat);
        if(createdSeat==null){
            ResponseEntity.badRequest().body("Error Creating seat.");
        }
        return new ResponseEntity<>(createdSeat, HttpStatus.CREATED);
    }

    @GetMapping("read/{seatID}")
    public ResponseEntity<?> get(@PathVariable Long seatID){
        Seat seat = service.read(seatID);
        if(seat==null){
            ResponseEntity.badRequest().body("Seat with SeatID: "+seatID+" does not exist");
        }
        return ResponseEntity.ok(seat);
    }

    @GetMapping("/getAll")
    public Set<Seat> getAll(){
        return service.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Seat seat){
        Seat updatedSeat = service.update(seat);
        if(updatedSeat==null){
            return ResponseEntity.badRequest().body("Error Updating Seat");
        }
        return ResponseEntity.ok(updatedSeat);
    }
}
