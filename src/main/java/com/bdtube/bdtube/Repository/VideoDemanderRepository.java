package com.bdtube.bdtube.Repository;

import com.bdtube.bdtube.Model.Video;
import com.bdtube.bdtube.Model.VideoDemander;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface VideoDemanderRepository extends JpaRepository<VideoDemander, Integer> {
    @Query("select u from VideoDemander u where u.id_video = :id ")
    VideoDemander findById_video(@Param("id")  String id );

}

