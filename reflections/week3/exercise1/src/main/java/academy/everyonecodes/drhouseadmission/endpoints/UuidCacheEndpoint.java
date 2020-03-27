package academy.everyonecodes.drhouseadmission.endpoints;

import academy.everyonecodes.drhouseadmission.logic.UUIDProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/uuids")
public class UuidCacheEndpoint {
    private UUIDProvider uuidProvider;

    public UuidCacheEndpoint(UUIDProvider uuidProvider) {
        this.uuidProvider = uuidProvider;
    }

    @GetMapping
    Map<String, String> getAll(){
        return uuidProvider.getCacheSnapshot();
    }

    @GetMapping("/{patientName}")
    String getByName(@PathVariable String patientName){
        return uuidProvider.findUUID(patientName);
    }
}
