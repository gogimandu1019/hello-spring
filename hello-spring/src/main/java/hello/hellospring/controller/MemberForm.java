package hello.hellospring.controller;

public class MemberForm {   //이게 있으면 createMemberForm.html 의 name과 매칭가능
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
