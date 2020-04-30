package academy.everyonecodes.mysterioussecretorder.service;

import academy.everyonecodes.mysterioussecretorder.domain.Founder;
import academy.everyonecodes.mysterioussecretorder.domain.Member;
import academy.everyonecodes.mysterioussecretorder.domain.MemberDTO;
import academy.everyonecodes.mysterioussecretorder.repo.MemberRepository;
import academy.everyonecodes.mysterioussecretorder.translator.MemberTranslator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MembersService {

    private final MemberTranslator translator;
    private final MemberRepository repository;
    private final Founder founder;

    public MembersService(MemberTranslator translator, MemberRepository repository, Founder founder) {
        this.translator = translator;
        this.repository = repository;
        this.founder = founder;
        if (!repository.existsByUsername("master")){
            Member master = founder.foundOrder();
            repository.save(master);
        }
    }

    public MemberDTO saveMember(MemberDTO memberDTO) {
        Member member = translator.toMember(memberDTO);
        member = repository.save(member);
        return translator.toMemberDTO(member);
    }

    public List<MemberDTO> getAllApprentices() {
        return repository.findByAuthorities("ROLE_APPRENTICE").stream()
                .map(translator::toMemberDTO)
                .collect(Collectors.toList());
    }

    public List<MemberDTO> getAll() {
        return repository.findAll().stream()
                .map(translator::toMemberDTO)
                .collect(Collectors.toList());
    }

}
