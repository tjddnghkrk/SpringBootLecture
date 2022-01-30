package hello.hellospring.service;

import hello.hellospring.Repository.JpaMemberRepository;
import hello.hellospring.Repository.MemberRepository;
import hello.hellospring.Repository.jdbcMemberRepository;
import hello.hellospring.Repository.jdbcTemplateMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    //private DataSource dataSource; //데이터와 연결할 수 있음

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new jdbcMemberRepository(dataSource);
        //return new jdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
