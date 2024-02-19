package com.carParkingApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carParkingApp.Model.ParkingLot;
import com.carParkingApp.Model.ParkingSlot;
import com.carParkingApp.Repository.ParkingLotRepository;
import com.carParkingApp.Repository.ParkingSlotRepository;

@Service
public class ParkingService {
    @Autowired
    private ParkingSlotRepository slotRepository;
    
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    
    
    
    public ParkingLot createParkingLot(int capacity) {
    	 ParkingLot parkingLot = new ParkingLot();
         parkingLotRepository.save(parkingLot); // Save the parking lot to generate an ID

         List<ParkingSlot> slots = new ArrayList<>();
         for (int i = 0; i < capacity; i++) {
             ParkingSlot slot = new ParkingSlot();
            
             slot.setOccupied(false);
             slots.add(slot);
         }
         slotRepository.saveAll(slots);
         
         parkingLot.setSlots(slots);
         return parkingLotRepository.save(parkingLot);
     }
    

   

    public ParkingSlot parkCar(String registrationNumber, String color) {
        ParkingSlot slot = slotRepository.findFirstByOccupiedFalse();
        if (slot == null) {
            throw new RuntimeException("Parking lot is full");
        }

        slot.setRegistrationNumber(registrationNumber);
        slot.setColor(color);
        slot.setOccupied(true);
        slotRepository.save(slot);

        return slot;
    }

    public void leaveParkingSlot(Long slotId) {
        ParkingSlot slot = slotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Parking slot not found"));
        slot.setRegistrationNumber(null);
        slot.setColor(null);
        slot.setOccupied(false);
        slotRepository.save(slot);
    }

    public List<ParkingSlot> getAllSlots() {
        return slotRepository.findAll();
    }

    public List<ParkingSlot> getSlotsByColor(String color) {
        return slotRepository.findByColor(color);
    }

    public ParkingSlot getSlotByRegistrationNumber(String registrationNumber) {
        return slotRepository.findByRegistrationNumber(registrationNumber);
    }

    public List<String> getRegistrationNumbersForCarsWithColor(String color) {
        List<ParkingSlot> slots = slotRepository.findByColor(color);
        System.out.println(slots.get(0).getColor());
        return slots.stream()
                .map(ParkingSlot::getRegistrationNumber)
                .collect(Collectors.toList());
    }

    public List<Long> getSlotNumbersForCarsWithColor(String color) {
        List<ParkingSlot> slots = slotRepository.findByColor(color);
        return slots.stream()
                .map(ParkingSlot::getId)
                .collect(Collectors.toList());
    }

    public Long getSlotNumberForRegistrationNumber(String registrationNumber) {
        ParkingSlot slot = slotRepository.findByRegistrationNumber(registrationNumber);
        return slot != null ? slot.getId() : null;
    }
}