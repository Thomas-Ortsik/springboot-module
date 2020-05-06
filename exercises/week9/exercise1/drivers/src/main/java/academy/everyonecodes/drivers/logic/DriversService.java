package academy.everyonecodes.drivers.logic;

import academy.everyonecodes.drivers.domain.Driver;
import academy.everyonecodes.drivers.domain.DriverDTO;
import academy.everyonecodes.drivers.repo.DriverRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class DriversService {
    private final DriverTranslator translator;
    private final DriverRepository repository;
    private final PasswordEncoder encoder;
    public DriversService(DriverTranslator translator, DriverRepository repository, PasswordEncoder encoder) {
        this.translator = translator;
        this.repository = repository;
        this.encoder = encoder;
    }

    public Driver registerDriver(DriverDTO driverDTO){
        Optional<Driver> oDriver = repository.findByUsername(driverDTO.getUsername());
        if (oDriver.isPresent()){
            return oDriver.get();
        }
        Driver driver = translator.toDriver(driverDTO);
        driver.setPassword(encoder.encode(driverDTO.getPassword()));
        driver.setAuthorities(Set.of("ROLE_DRIVER"));
        return repository.save(driver);
    }

    public Optional<Driver> getById(String id){
        return repository.findById(id);
    }

    public void saveAvailability(String id, boolean isAvailable){
        Optional<Driver> oDriver = repository.findById(id);
        if (oDriver.isPresent()){
            Driver driver = oDriver.get();
            driver.setAvailable(isAvailable);
            repository.save(driver);
        }
    }

}
