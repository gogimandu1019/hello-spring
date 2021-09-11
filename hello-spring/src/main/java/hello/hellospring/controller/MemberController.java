package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //컨트롤러 객체를 생성해서 스프링이 들고 있음 : 스프링빈이 관리됨
public class MemberController {
    private final MemberService memberService;

    @Autowired  //생성자에 autowire가 되어있으면 자동연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";  //get방식 - url 직접접근 가능. 주로 조회만 할 때
    }

    @PostMapping("/members/new")//post방식으로 - 데이터 받아서 넘길때
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";    //홈화면으로 보내기
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}