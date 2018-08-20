package com.bdtube.bdtube.Repository;

import com.bdtube.bdtube.Model.Account;
import com.bdtube.bdtube.Model.User;
import com.bdtube.bdtube.Model.VideoDemander;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("select u from Account u where u.username = :id ")
    Account findByUsername(@Param("id")  String id );

}
