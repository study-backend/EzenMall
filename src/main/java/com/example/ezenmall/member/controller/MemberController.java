package com.example.ezenmall.member.controller;
import com.example.ezenmall.member.model.dto.MemberJoinRequest;
import com.example.ezenmall.member.model.dto.MemberLoginRequest;
import com.example.ezenmall.member.model.dto.MemberUpdateRequest;
import com.example.ezenmall.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/members")
@RestController
public class MemberController {
    private final MemberService service;
    public MemberController(MemberService service) {
        this.service = service;
    }
//    @PostMapping(name = "/login")
//    public void login(MemberLoginRequest request) {
//        boolean result = service.login(request);
//    }
//    @PostMapping(name = "/join")
//    public void join(MemberJoinRequest memberJoinRequest) {
//        boolean result = service.join(memberJoinRequest);
//    }
    @PatchMapping(name = "")
    public void update(MemberUpdateRequest memberUpdateRequest) {
        boolean result = service.update(memberUpdateRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        boolean result = service.delete(id);
    }
}
