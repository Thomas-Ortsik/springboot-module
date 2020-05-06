package academy.everyonecodes.drivers.endpoint;

import academy.everyonecodes.drivers.domain.Driver;
import academy.everyonecodes.drivers.domain.DriverDTO;
import academy.everyonecodes.drivers.logic.DriversService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/drivers")
public class DriversEndpoint {
    private final DriversService service;

    public DriversEndpoint(DriversService service) {
        this.service = service;
    }

    @PostMapping
    Driver post(@RequestBody DriverDTO driverDTO){
        return service.registerDriver(driverDTO);
    }

    @GetMapping("/{id}")
    Optional<Driver> get(@PathVariable String id){
        return service.getById(id);
    }

    @PutMapping("/{id}/available")
    void setAvailable(@PathVariable String id){
        service.saveAvailability(id, true);
    }

    @PutMapping("/{id}/unavailable")
    void setUnavailable(@PathVariable String id){
        service.saveAvailability(id, false);
    }
}
