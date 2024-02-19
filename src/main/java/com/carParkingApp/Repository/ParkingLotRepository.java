package com.carParkingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carParkingApp.Model.ParkingLot;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
  
}