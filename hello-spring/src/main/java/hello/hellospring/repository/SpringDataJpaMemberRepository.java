package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPQL : select m from member m where m.name = ? 이런식으로 자동 완성
    @Override
    Optional<Member> findByName(String name);
}
