package academy.everyonecodes.drivers.logic;

import academy.everyonecodes.drivers.configuration.SecurityConfiguration;
import academy.everyonecodes.drivers.domain.Driver;
import academy.everyonecodes.drivers.domain.DriverDTO;
import academy.everyonecodes.drivers.repo.DriverRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DriversServiceTest {
    @Autowired
    DriversService service;
    @MockBean
    DriverTranslator translator;
    @MockBean
    DriverRepository repository;
    @MockBean
    PasswordEncoder encoder;
    @MockBean
    SecurityConfiguration securityConfiguration;

    DriverDTO inputDTO = new DriverDTO("test", "test", "test");
    Driver input = new Driver("test", "test", "test");
    @Test
    void registerNewDriver() {
        Mockito.when(repository.findByUsername(inputDTO.getUsername())).thenReturn(Optional.empty());
        Mockito.when(translator.toDriver(inputDTO)).thenReturn(input);

        Driver result = service.registerDriver(inputDTO);

        Mockito.verify(encoder).encode("test");
        Mockito.verify(repository).save(input);
    }

    @Test
    void registerExistingDriver() {
        Mockito.when(repository.findByUsername(inputDTO.getUsername())).thenReturn(Optional.of(input));

        Driver result = service.registerDriver(inputDTO);

        Mockito.verifyNoInteractions(encoder);
        Mockito.verifyNoInteractions(translator);
    }

    @Test
    void getById() {
        service.getById("test");
        Mockito.verify(repository).findById("test");
    }

    @Test
    void saveAvailability() {
        Mockito.when(repository.findById("test")).thenReturn(Optional.of(input));
        service.saveAvailability("test", true);
        Mockito.verify(repository).save(input);
    }
}