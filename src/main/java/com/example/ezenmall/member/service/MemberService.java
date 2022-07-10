package com.example.ezenmall.member.service;
import com.example.ezenmall.member.model.Member;
import com.example.ezenmall.member.model.dto.MemberJoinRequest;
import com.example.ezenmall.member.model.dto.MemberLoginRequest;
import com.example.ezenmall.member.model.dto.MemberUpdateRequest;
import com.example.ezenmall.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository repository;
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }
    public boolean login(MemberLoginRequest request) {
        Optional <Member> findMember = repository.findByLoginId(request.getLoginId());
        if(findMember.isEmpty()) return false;
        if(!findMember.get().getPassword().equals(request.getPassword())) return false;
        return true;
    }
    public boolean join(MemberJoinRequest memberJoinRequest) {
        Optional <Member> findMember = repository.findByLoginId(memberJoinRequest.getLoginId());
        if(!findMember.isPresent()) return false;

        Member member = new Member(memberJoinRequest.getLoginId(), memberJoinRequest.getPassword()
                , memberJoinRequest.getName(), memberJoinRequest.getEmail()
                , memberJoinRequest.getTelephone(), memberJoinRequest.getAddress());

        Member newMember = repository.save(member);

        if(newMember.getLoginId().equals(memberJoinRequest.getLoginId()))
            return true;
        else
            return false;
    }
    public boolean update(MemberUpdateRequest memberUpdateRequest) {
        Optional<Member>  findMember = repository.findById(memberUpdateRequest.getId());
        if(findMember.isEmpty()) return false;
        findMember.get().updateMember(memberUpdateRequest.getName(), memberUpdateRequest.getEmail(),
                memberUpdateRequest.getPhone(), memberUpdateRequest.getAddress());

        Member updatedMember = repository.save(findMember.get());
        return true;
    }
    public boolean delete(Long id) {
        Optional<Member> findMember = repository.findById((id));
        if(findMember.isEmpty()) return false;
        repository.delete(findMember.get());
        return true;
    }
}