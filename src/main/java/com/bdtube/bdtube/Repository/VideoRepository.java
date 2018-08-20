package com.bdtube.bdtube.Repository;

import com.bdtube.bdtube.Model.Account;
import com.bdtube.bdtube.Model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface VideoRepository extends JpaRepository<Video, Integer> {
    @Query("select u from Video u where u.id_video = :id ")
    Video findById_video(@Param("id")String id );
}
