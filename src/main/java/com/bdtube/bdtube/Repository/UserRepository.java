package com.bdtube.bdtube.Repository;

import com.bdtube.bdtube.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.repository.query.Param;
@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository  extends JpaRepository<User, Long> {
}