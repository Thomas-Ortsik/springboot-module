package academy.everyonecodes.mysterioussecretorder.translator;

import academy.everyonecodes.mysterioussecretorder.domain.Member;
import academy.everyonecodes.mysterioussecretorder.domain.MemberDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberTranslator {
    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    public Member toMember(MemberDTO memberDTO){
        return new Member(memberDTO.getUsername(), encoder.encode(memberDTO.getPassword()), memberDTO.getAuthorities());
    }

    public MemberDTO toMemberDTO(Member member){
        return new MemberDTO(member.getId(), member.getUsername(), member.getPassword(), member.getAuthorities());
    }
}
