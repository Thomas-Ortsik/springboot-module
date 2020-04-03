package academy.everyonecodes.drhouseadmission.logic;

import academy.everyonecodes.drhouseadmission.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

@Service
public class UUIDProvider {
    private HashMap<String, String> cache;

    public UUIDProvider() {
        this.cache = new HashMap<String, String>();
    }

    public HashMap<String, String> getCache() {
        return cache;
    }

    public void setCache(HashMap<String, String> cache) {
        this.cache = cache;
    }

    public void provideUUID(Patient patient) {
        String patientName = patient.getName();
        if (cache.containsKey(patientName)) {
            patient.setUuid(cache.get(patientName));
        } else {
            String uuid = UUID.randomUUID().toString();
            patient.setUuid(uuid);
            cache.put(patient.getName(), patient.getUuid());
        }
    }

    public HashMap<String, String> getCacheSnapshot(){
        return cache;
    }

    public String findUUID(String name){
        return cache.get(name);
    }
}
