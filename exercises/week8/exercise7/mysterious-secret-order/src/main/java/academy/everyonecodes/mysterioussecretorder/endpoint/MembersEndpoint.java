package academy.everyonecodes.mysterioussecretorder.endpoint;

import academy.everyonecodes.mysterioussecretorder.domain.MemberDTO;
import academy.everyonecodes.mysterioussecretorder.service.MembersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MembersEndpoint {

    private final MembersService membersService;

    public MembersEndpoint(MembersService membersService) {
        this.membersService = membersService;
    }

    @GetMapping
    String get() {
        return "Mysterious Secret Order";
    }

    @GetMapping("/members")
    List<MemberDTO> getAllMembers() {
        return membersService.getAll();
    }

    @GetMapping("/members/apprentices")
    List<MemberDTO> getAllApprentices() {
        return membersService.getAllApprentices();
    }

    @PostMapping("/members")
    MemberDTO saveMember(@RequestBody MemberDTO memberDTO) {
        return membersService.saveMember(memberDTO);
    }
}
