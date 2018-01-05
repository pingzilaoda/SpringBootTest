package com.wisely.ch5_2_3;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<UserTest,Long> {

    UserTest findById(int id);

    @Query("select u from UserTest u where u.id= :id")
    UserTest withIdPatam(@Param("id") int id);

    @Query("select u from UserTest u where u.id = ?1")
    UserTest withId( int id);

    @Modifying
    @Transactional
    @Query("update UserTest set name=?1 where id = ?2")
    int setName(String name, int id);

    @Modifying
    @Transactional
    @Query(value = "insert into user_test(name,age,address) value(?1,?2,?3)",nativeQuery = true)
    int insertUserTest(String name, Integer age,String address);


}
