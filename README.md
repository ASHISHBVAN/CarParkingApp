Automated Ticketing System  
Overview  
This project is an automated ticketing system for a parking lot. It allows customers to use the parking lot without human intervention.   

1. Technologies Used  
    Java  
    Spring Boot  
    H2 Database  
   
2. Installation and Setup  
   Clone the Repository:  
   git clone https://github.com/ASHISHBVAN/CarParkingApp.git  

3. Build the Project:  
   cd CarParkingApp  
   ./mvnw clean package  
 
4. Run the Application:   
   java -jar target/carparkingapp-1.0.jar  

5. Access the Application:  
   Open a web browser and go to http://localhost:8080 to access the application.  
   API Endpoints:  

   1. /parking/srvice/createParkingLot/{capacity} - Create a parking lot with the specified capacity.  
   2. /parking/srvice/park/{registrationNumber}/{color} - Park a car in the parking lot.  
   3. /parking/srvice/leave/{slotId} - Remove a car from the parking lot.  
   4. /parking/srvice/status - Get the current status of the parking lot.  
   5. /parking/srvice/registration_numbers_for_cars_with_colour/{color} - Get registration numbers of cars with the specified color.  
   6. /parking/srvice/slot_numbers_for_cars_with_colour/{color} - Get slot numbers of cars with the specified color.  
   7. /slot_number_for_registration_number/{registrationNumber} - Get slot number for a car with the specified registration number.  

6.Additional Notes:  

The application uses an in-memory H2 database. Data is not persisted beyond the application's lifecycle.  
Make sure to adjust the application.properties file for any custom configurations.  
