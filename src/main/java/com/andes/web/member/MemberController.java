package com.andes.web.member;

import com.andes.web.util.Messenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/members")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {
    @Autowired MemberService memberService;
    @Autowired Member member;

    @PostMapping("")
    public Messenger post(@RequestBody Member member){
        System.out.println(member);
        memberService.signIn(member);
        return Messenger.SUCCESS;
    }

    @PostMapping("/{userId}/login")
    public Map<String, Object> login(@PathVariable String userId, @RequestBody Member param){
        System.out.println("컨트롤러이에서ㅏ얼ㅇㄴㄹㅁ" + param);
        Map<String, Object> map = new HashMap<>();
        member = memberService.access(param);

        if(member != null) {
            map.put("result", true);
        } else {
            map.put("result", false);
        }
        map.put("user", member);
        System.out.println("!!!!!!!~~~~~~~~~~~~~~" + map);
        return map;
    }

    @GetMapping("")
    public List<Member> list(){
        return memberService.listAll();
    }

    @GetMapping("/{userId}")
    public Member detail(@PathVariable String userId){
        return memberService.listOne(userId);
    }

    @PutMapping("/{userId}")
    public Messenger put(@RequestBody Member member){
        memberService.modify(member);
        return Messenger.SUCCESS;
    }

    @DeleteMapping("/{userId}")
    public Messenger delete(@RequestBody Member member){
        memberService.remove(member);
        return Messenger.SUCCESS;
    }


}
