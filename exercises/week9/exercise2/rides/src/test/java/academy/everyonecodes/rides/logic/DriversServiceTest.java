package academy.everyonecodes.rides.logic;

import academy.everyonecodes.rides.domain.Driver;
import academy.everyonecodes.rides.repo.DriverRepository;
import academy.everyonecodes.rides.repo.RideRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DriversServiceTest {
    @Autowired
    DriversService service;
    @MockBean
    DriverRepository driverRepository;
    @MockBean
    RideRepository rideRepository;

    //well, my methods are secured, so I can't test them right now. I probably should look this up anyway, but time is running
}