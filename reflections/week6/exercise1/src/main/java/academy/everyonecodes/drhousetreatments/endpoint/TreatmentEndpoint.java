package academy.everyonecodes.drhousetreatments.endpoint;

import academy.everyonecodes.drhousetreatments.domain.Treatment;
import academy.everyonecodes.drhousetreatments.logic.TreatmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/treatments")
public class TreatmentEndpoint {
    private final TreatmentService service;

    public TreatmentEndpoint(TreatmentService service) {
        this.service = service;
    }

    @GetMapping
    List<Treatment> getAll(){
        return service.getTreatments();
    }

    @GetMapping("/{uuid}")
    List<Treatment> getSpecific(@PathVariable String uuid){
        return service.getSpecificTreatments(uuid);
    }
}
