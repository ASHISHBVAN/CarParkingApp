package com.carParkingApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carParkingApp.Model.ParkingSlot;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {
    ParkingSlot findFirstByOccupiedFalse();

    List<ParkingSlot> findByColor(String color);

    ParkingSlot findByRegistrationNumber(String registrationNumber);
}
