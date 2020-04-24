package academy.everyonecodes.drhouseaccountancy.logic;

import academy.everyonecodes.drhouseaccountancy.domain.Invoice;
import academy.everyonecodes.drhouseaccountancy.domain.Patient;
import academy.everyonecodes.drhouseaccountancy.domain.PatientDTO;
import academy.everyonecodes.drhouseaccountancy.repo.InvoiceRepository;
import academy.everyonecodes.drhouseaccountancy.repo.PatientRepository;
import academy.everyonecodes.drhouseaccountancy.translator.PatientTranslator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunicationService {
    //I guess I could/should do the invoice stuff in a new class
    private final InvoiceRepository invoiceRepository;
    private final PatientRepository patientRepository;
    private final PatientTranslator translator;

    public CommunicationService(InvoiceRepository invoiceRepository, PatientRepository patientRepository, PatientTranslator translator) {
        this.invoiceRepository = invoiceRepository;
        this.patientRepository = patientRepository;
        this.translator = translator;
    }

    public PatientDTO postPatient(PatientDTO patientDTO) {
        Patient patient;
        Optional<Patient> oPatient = patientRepository.findByUuid(patientDTO.getUuid());
        if (oPatient.isEmpty()) {
            patient = savePatient(patientDTO);
        } else {
            patient = oPatient.get();
        }
        saveInvoice(patient);
        return translator.toPatientDTO(patient);
    }

    private Patient savePatient(PatientDTO patientDTO) {
        Patient patient = translator.toPatient(patientDTO);
        patientRepository.save(patient);
        return patient;
    }

    //this is what deserves a new Class, but not today
    private void saveInvoice(Patient patient) {
        Invoice invoice = new Invoice(calculateCost(patient), hasPaid(patient), patient);
        invoiceRepository.save(invoice);
    }

    private double calculateCost(Patient patient) {
        double freeHealthcareForEveryone = 0.0;
        return freeHealthcareForEveryone;
    }

    private boolean hasPaid(Patient patient) {
        boolean nowWeGetPhilosophical = false;
        return nowWeGetPhilosophical;
    }

    //I always wanted to make a really large Class. First steps!

    public List<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    public void payInvoice(Long id) {
        Optional<Invoice> oInvoice = invoiceRepository.findById(id);
        if (oInvoice.isPresent()) {
            Invoice invoice = oInvoice.get();
            invoice.setPaid(true);
            invoiceRepository.save(invoice);
        }
    }


}
