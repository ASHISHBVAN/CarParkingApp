package com.carParkingApp.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class ParkingLot {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "parkingLot")
    private List<ParkingSlot> slots;

	public ParkingLot(Long id, List<ParkingSlot> slots) {
		super();
		this.id = id;
		this.slots = slots;
	}
	
	public ParkingLot() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ParkingSlot> getSlots() {
		return slots;
	}

	public void setSlots(List<ParkingSlot> slots) {
		this.slots = slots;
	}
    
    

}
