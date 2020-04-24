package academy.everyonecodes.drhouseaccountancy.endpoint;

import academy.everyonecodes.drhouseaccountancy.domain.Invoice;
import academy.everyonecodes.drhouseaccountancy.logic.CommunicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoicesEndpoint {
    private final CommunicationService communicationService;

    public InvoicesEndpoint(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }

    @GetMapping
    List<Invoice> get(){
        return communicationService.getInvoices();
    }

    @PutMapping("/{id}/paid")
    void putPaid(@PathVariable Long id){
        communicationService.payInvoice(id);
    }
}
