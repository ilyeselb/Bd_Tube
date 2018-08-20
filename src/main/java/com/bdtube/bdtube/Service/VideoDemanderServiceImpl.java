package com.bdtube.bdtube.Service;

import com.bdtube.bdtube.Model.VideoDemander;
import com.bdtube.bdtube.Repository.VideoDemanderRepository;
import com.bdtube.bdtube.Service.VideoDemanderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VideoDemanderServiceImpl implements VideoDemanderService {
    @Autowired
    VideoDemanderRepository vr ;
    public VideoDemanderServiceImpl(VideoDemanderRepository  vr) {
        this. vr =  vr;
    }
    @Override
    public List<VideoDemander> getAll() {
              return vr.findAll();
    }

    @Override
    public void addVideoDemander(VideoDemander videoDemander) {
             vr.save(videoDemander);

    }

    @Override
    public void deleteVideoDemander(String id) {
        System.out.println("lala");

        System.out.println((id));
        System.out.println(vr.findById_video(id));
        vr.delete(vr.findById_video(id));

    }

    @Override
    public Optional<VideoDemander> getVideoDemanderByid(int id) {
        return Optional.empty();
    }

    @Override
    public void updateVideoDemander(VideoDemander videoDemander) {
        vr.save(videoDemander);

    }
}
