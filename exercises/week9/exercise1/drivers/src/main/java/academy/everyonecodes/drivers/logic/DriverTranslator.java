package academy.everyonecodes.drivers.logic;

import academy.everyonecodes.drivers.domain.Driver;
import academy.everyonecodes.drivers.domain.DriverDTO;
import org.springframework.stereotype.Service;

@Service
public class DriverTranslator {

    public Driver toDriver(DriverDTO driverDTO){
        return new Driver(
                driverDTO.getId(),
                driverDTO.getUsername(),
                driverDTO.getPassword(),
                driverDTO.getTypeOfCar(),
                driverDTO.isAvailable(),
                driverDTO.getAuthorities()
        );
    }

    public DriverDTO toDriverDTO(Driver driver){
        return new DriverDTO(
                driver.getId(),
                driver.getUsername(),
                driver.getPassword(),
                driver.getTypeOfCar(),
                driver.isAvailable(),
                driver.getAuthorities()
        );
    }
}
