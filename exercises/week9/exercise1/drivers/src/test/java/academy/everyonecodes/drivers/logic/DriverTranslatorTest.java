package academy.everyonecodes.drivers.logic;

import academy.everyonecodes.drivers.domain.Driver;
import academy.everyonecodes.drivers.domain.DriverDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class DriverTranslatorTest {
    @Autowired
    DriverTranslator translator;

    DriverDTO driverDTO = new DriverDTO("ID", "User", "PW", "TOC", true, Set.of("ROLE_DRIVER"));
    Driver driver = new Driver("ID", "User", "PW", "TOC", true, Set.of("ROLE_DRIVER"));

    @Test
    void toDriver() {
        Driver result = translator.toDriver(driverDTO);
        Assertions.assertEquals(driver, result);
    }

    @Test
    void toDriverDTO() {
        DriverDTO result = translator.toDriverDTO(driver);
        Assertions.assertEquals(driverDTO, result);
    }
}