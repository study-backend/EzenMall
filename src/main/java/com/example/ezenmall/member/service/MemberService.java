package com.example.ezenmall.member.service;


import com.example.ezenmall.member.model.Member;
import com.example.ezenmall.member.model.dto.JoinRequest;
import com.example.ezenmall.member.model.dto.LoginRequest;
import com.example.ezenmall.member.model.dto.UpdateRequest;
import com.example.ezenmall.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository repository;
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }
    public boolean login(LoginRequest request) {
        Optional <Member> findMember = repository.findByLoginId(request.getLoginId());
        if(findMember.isEmpty()) return false;
        if(!findMember.get().getPassword().equals(request.getPassword())) return false;
        return true;

    }

    public boolean join(JoinRequest joinRequest) {
        Optional <Member> findMember = repository.findByLoginId(joinRequest.getLoginId());
        if(!findMember.isPresent()) return false;

        Member member = new Member(joinRequest.getLoginId(), joinRequest.getPassword()
                , joinRequest.getName(), joinRequest.getEmail()
                , joinRequest.getTelephone(),joinRequest.getAddress());
        Member newMember = repository.save(member);
        if(newMember.getLoginId().equals(joinRequest.getLoginId()))
            return true;
        else
            return false;
    }

    public boolean update(UpdateRequest updateRequest) {
        Optional<Member>  findMember = repository.findById(updateRequest.getId());
        if(findMember.isEmpty()) return false;
        findMember.get().updateMember(updateRequest.getName(), updateRequest.getEmail(),
                updateRequest.getPhone(), updateRequest.getAddress());

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
