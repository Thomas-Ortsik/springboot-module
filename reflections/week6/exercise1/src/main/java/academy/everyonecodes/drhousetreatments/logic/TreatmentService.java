package academy.everyonecodes.drhousetreatments.logic;

import academy.everyonecodes.drhousetreatments.domain.Patient;
import academy.everyonecodes.drhousetreatments.domain.Treatment;
import academy.everyonecodes.drhousetreatments.repo.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {
    private final TreatmentRepository repository;
    private final Nurse nurse;

    public TreatmentService(TreatmentRepository repository, Nurse nurse) {
        this.repository = repository;
        this.nurse = nurse;
    }

    public Patient postTreatment(Patient patient){
        nurse.provideTreatment(patient);
        //i guess I could do this with typecasting by having treatment extend patient?
        //but i'm not even sure this is what you want from us in the first place
        //so I'm not gonna mess with the data classes
        Treatment treatment = doBureaucracy(patient);
        repository.save(treatment);
        return patient;
    }

    public List<Treatment> getTreatments(){
        return repository.findAll();
    }

    public List<Treatment> getSpecificTreatments(String uuid){
        return repository.findByUuid(uuid);
    }


    //converter would be a more descriptive name, but wheres the fun in that
    private Treatment doBureaucracy(Patient patient){
        return new Treatment(
                patient.getUuid(),
                patient.getName(),
                patient.getSymptoms(),
                patient.getDiagnosis(),
                patient.getTreatment()
        );
    }
}
