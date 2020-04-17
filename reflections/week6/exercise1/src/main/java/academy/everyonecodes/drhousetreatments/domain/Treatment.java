package academy.everyonecodes.drhousetreatments.domain;

import java.util.Objects;

public class Treatment{
    private String id;
    private String uuid;
    private String name;
    private String symptoms;
    private String diagnosis;
    private String treatment;

    Treatment(){}

    public Treatment(String uuid, String name, String symptoms, String diagnosis, String treatment) {
        this.uuid = uuid;
        this.name = name;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    void setId(String id) {
        this.id = id;
    }

    void setUuid(String uuid) {
        this.uuid = uuid;
    }

    void setName(String name) {
        this.name = name;
    }

    void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "id='" + id + '\'' +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treatment treatment1 = (Treatment) o;
        return Objects.equals(id, treatment1.id) &&
                Objects.equals(uuid, treatment1.uuid) &&
                Objects.equals(name, treatment1.name) &&
                Objects.equals(symptoms, treatment1.symptoms) &&
                Objects.equals(diagnosis, treatment1.diagnosis) &&
                Objects.equals(treatment, treatment1.treatment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uuid, name, symptoms, diagnosis, treatment);
    }

    public String getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }
}
