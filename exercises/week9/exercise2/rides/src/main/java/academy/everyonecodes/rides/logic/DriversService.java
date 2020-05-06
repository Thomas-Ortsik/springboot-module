package academy.everyonecodes.rides.logic;

import academy.everyonecodes.rides.domain.Driver;
import academy.everyonecodes.rides.domain.Ride;
import academy.everyonecodes.rides.repo.DriverRepository;
import academy.everyonecodes.rides.repo.RideRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriversService {
    private final DriverRepository driverRepository;
    private final RideRepository rideRepository;

    public DriversService(DriverRepository driverRepository, RideRepository rideRepository) {
        this.driverRepository = driverRepository;
        this.rideRepository = rideRepository;
    }

    @Secured("ROLE_ADMIN")
    public Driver saveDriver(Driver driver){
        driverRepository.save(driver);
        return driver;
    }

    @Secured("ROLE_ADMIN")
    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }

    @Secured("ROLE_APP")
    public Ride saveRide(Long id, Ride ride){
        Optional<Driver> oDriver = driverRepository.findById(id);
        if (oDriver.isPresent()){
            rideRepository.save(ride);
            Driver driver = oDriver.get();
            List<Ride> rides = driver.getRides();
            rides.add(ride);
            driver.setRides(rides);
            driverRepository.save(driver);
        }
        return ride;
    }
}
