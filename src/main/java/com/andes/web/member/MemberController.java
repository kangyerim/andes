package com.andes.web.member;

import com.andes.web.proxy.Box;
import com.andes.web.util.Messenger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/members")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {
    static Logger log = LoggerFactory.getLogger(MemberController.class);

    @Autowired MemberRepository repository;
    @Autowired Box<Object> box;

    @PostMapping("/signin")
    public Map<?,?> signIn(@RequestBody Member member){
        log.info("signIn()");
        box.clear();
        if(0 < repository.count()){
            Iterator<Member> itr = repository.findAll().iterator();
            while (itr.hasNext()){
                if(itr.next().getUserId().equals(member.getUserId())){
                    box.put("duplication", "true");
                    box.put("result", "false");
                    break;
                }
            }
        } else if(box.get("duplication") == null) {
            Member newMember = new Member();
            newMember.setUserId(member.getUserId());
            newMember.setPassword(member.getPassword());
            newMember.setUserName(member.getUserName());
            newMember.setEmail(member.getEmail());
            repository.save(newMember);
            box.put("result","true");
        }
        return box.get();
    }

    @PutMapping("/{update}")
    public Map<?,?> update(@PathVariable String update, Member member){
        log.info("update()");
        box.clear();
        Iterator<Member> itr = repository.findAll().iterator();
        while (itr.hasNext()){
            Member next = itr.next();
            if(next.getUserId().equals(member.getUserId()) && next.getPassword().equals(member.getPassword())){
                repository.updatePassword(member.getUserId(), update);
                box.put("result","true");
                break;
            }
        }
        if(box.get("result") == null) box.put("result", "false");
        return box.get();
    }


}
