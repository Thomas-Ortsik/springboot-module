package academy.everyonecodes.rides.endpoint;

import academy.everyonecodes.rides.domain.Driver;
import academy.everyonecodes.rides.domain.Ride;
import academy.everyonecodes.rides.logic.DriversService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriversEndpoint {
    private final DriversService service;

    public DriversEndpoint(DriversService service) {
        this.service = service;
    }

    @PostMapping
    Driver postDriver(@RequestBody Driver driver){
        return service.saveDriver(driver);
    }

    @GetMapping
    List<Driver> getDrivers(){
        return service.getAllDrivers();
    }

    @PostMapping("/{id}/rides")
    Ride postRide(@PathVariable Long id, @RequestBody Ride ride){
        return service.saveRide(id, ride);
    }
}
