package net.slipp.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUserId(String userId); //userId를 기반으로 해서 사용자 검색
}
