package com.bdtube.bdtube.Controller;

import com.bdtube.bdtube.Model.Role;
import com.bdtube.bdtube.Model.User;
import com.bdtube.bdtube.Model.Video;
import com.bdtube.bdtube.Model.VideoDemander;
import com.bdtube.bdtube.Repository.VideoDemanderRepository;
import com.bdtube.bdtube.Repository.VideoRepository;
import com.bdtube.bdtube.Service.VideoService;
import com.bdtube.bdtube.Service.VideoDemanderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class VideoController {
    public  static  Video video_static ;
    public  static  Video video_static2 ;


    @Autowired
    private   VideoDemanderService videoDemanderService ;
    @Autowired
    private VideoService videoService;
    @Autowired
    private VideoDemanderRepository vr;
    @Autowired
    private VideoRepository vrr;

    public static Video getVideo_static() {
        return video_static;
    }

    public static void setVideo_static(Video video_static) {
        VideoController.video_static = video_static;
    }

    //Demande d(autorisationde video
    @PostMapping("/adddemande")
    public void  AddDemande(@RequestBody VideoDemander video)
    {
         User u = LoginController.user;
         System.out.println(LoginController.user);
        System.out.println(video);
        video.setRate((long) 0);
        video.setAcceptation(0);
        video.setCategorie("musique");
        video.setUser_acceptation(u);
        videoDemanderService.addVideoDemander(video);


    }
    //**********************************************************
    //afficher toutes les demande de video
 @GetMapping("/demande")
    public List<VideoDemander> getvideo(){
        List<VideoDemander> vd = new ArrayList<>();
                System.out.println(  videoDemanderService.getAll());

        for(VideoDemander v :      videoDemanderService.getAll())
        {              System.out.println("pooooooooooooo"+v.getAcceptation());

            if (v.getAcceptation()==0)
        vd.add(v);
        }
        return vd;
 }
 //*********************************
    //accepter une video et l'ajouter au video accepter
 @PostMapping("/addvideo/{id_video}")
 public void  AddVideo(@PathVariable String id_video,@RequestBody Video video)
 { User u = new User();


     VideoDemander v = vr.findById_video(id_video);
     v.setAcceptation(1);
     videoDemanderService.updateVideoDemander(v);
     videoService.addVideo(video);
 }
 //*********************************************************
    //refuser une demande d'ajout de video
    @PostMapping("/deletedemande")
    public void deleteDemande(@RequestBody VideoDemander vd){
        System.out.println(vd.getId_video());
        VideoDemander v = vr.findById_video(vd.getId_video());
        v.setAcceptation(-1);
        videoDemanderService.updateVideoDemander(v);
    }
    @PostMapping("/getvidid")
    public List<Video> findvidbyid(@RequestBody String id){
        Video v = vrr.findById_video(id);
 List <Video> vl = new ArrayList<>();
 vl.add(v);
 return vl ;
    }
    //***********************
    //afficher les demande pour les filtrer apres
    @GetMapping("/filtrage")
    public List<VideoDemander> filtragevideo(){
    return vr.findAll();
     }
     //************************
    //deux methode transferer permettes de transferer la video a regarder d'un coomponenet a un autre s'aidant d'une variable static
    @GetMapping("/transfere2")
    public List<Video> transfere2(){
       List<Video> lv = new ArrayList<>();
       lv.add(video_static);
        return lv;
    }
    @PostMapping("/transfere")
    public void transfere(@RequestBody Video vd){
        System.out.println(vd.getId_video());
         video_static=vd;
    }
    @PostMapping ("/regarderr")
    public void regarder(@RequestBody Video vd){
        System.out.println(vd.getId_video());
        video_static2=vd;
    }
    @GetMapping("/regarder2")
    public List<Video> regarder2(){
        List<Video> lv = new ArrayList<>();
        lv.add(video_static2);

        System.out.println(video_static2);
        return lv;
    }
    @GetMapping("/allvid")
    public List<Video> allvid(){
        List<Video> lv = new ArrayList<>();
        for(Video v :      videoService.getAll())
        {
            lv.add(v);
        }
        System.out.println(lv);
        return lv;
    }


}