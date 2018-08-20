package com.bdtube.bdtube.Repository;

import com.bdtube.bdtube.Model.Account;
import com.bdtube.bdtube.Model.Chanel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ChanelRepository extends CrudRepository<Chanel, Integer> {
}
