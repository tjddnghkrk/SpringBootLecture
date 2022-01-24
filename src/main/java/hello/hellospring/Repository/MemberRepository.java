package hello.hellospring.Repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    //optional 은 null 이 반환될 떄, optional로 감싸서 하길 추천. 자바 8부터 생김.
    List<Member> findAll();
}
