package com.carParkingApp.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carParkingApp.Model.ParkingLot;
import com.carParkingApp.Model.ParkingSlot;
import com.carParkingApp.Service.ParkingService;

@RestController
@RequestMapping("parking/service")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;
    
    @GetMapping("/Running")
    public String running() {
    	
    	return "Running";
    }
    
    
    @PostMapping("/createParkingLot/{capacity}")
    public ResponseEntity<ParkingLot> createParkingLot(@PathVariable("capacity") int capacity) {
        ParkingLot parkingLot = parkingService.createParkingLot(capacity);
        return ResponseEntity.ok(parkingLot);
    }

    @PostMapping("/park/{registrationNumber}/{color}")
    public ResponseEntity<ParkingSlot> parkCar(@PathVariable("registrationNumber") String registrationNumber,
    		@PathVariable("color") String color) {
        ParkingSlot slot = parkingService.parkCar(registrationNumber, color);
        return ResponseEntity.ok(slot);
    }

    @PostMapping("/leave/{slotId}")
    public ResponseEntity<String> leaveParkingSlot(@PathVariable("slotId") Long slotId) {
        parkingService.leaveParkingSlot(slotId);
        return ResponseEntity.ok("Slot " + slotId + " is free");
    }

    @GetMapping("/status")
    public ResponseEntity<List<ParkingSlot>> getStatus() {
        List<ParkingSlot> slots = parkingService.getAllSlots();
        return ResponseEntity.ok(slots);
    }

    @GetMapping("/registration_numbers_for_cars_with_colour/{color}")
    public ResponseEntity<List<String>> getRegistrationNumbersForCarsWithColor(@PathVariable("color") String color) {
        List<String> registrationNumbers = parkingService.getRegistrationNumbersForCarsWithColor(color);
        return ResponseEntity.ok(registrationNumbers);
    }

    @GetMapping("/slot_numbers_for_cars_with_colour/{color}")
    public ResponseEntity<List<Long>> getSlotNumbersForCarsWithColor(@PathVariable("color") String color) {
        List<Long> slotNumbers = parkingService.getSlotNumbersForCarsWithColor(color);
        return ResponseEntity.ok(slotNumbers);
    }

    @GetMapping("/slot_number_for_registration_number/{registrationNumber}")
    public ResponseEntity<Long> getSlotNumberForRegistrationNumber(@PathVariable("registrationNumber") String registrationNumber) {
        Long slotNumber = parkingService.getSlotNumberForRegistrationNumber(registrationNumber);
        return ResponseEntity.ok(slotNumber);
    }
}

