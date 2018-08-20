package com.bdtube.bdtube.Service;

import com.bdtube.bdtube.Model.Video;
import com.bdtube.bdtube.Repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService{
    @Autowired
    VideoRepository vr;

    public VideoServiceImpl(VideoRepository vr) {
        this. vr =  vr;}
    @Override

    public List<Video> getAll() {
        return (List<Video>) vr.findAll();
    }

    @Override
    public void addVideo(Video v) {
        vr.save(v);

    }

    @Override
    public void deleteVideo(String id) {
        vr.delete(vr.findById_video(id));

    }

    @Override
    public Optional<Video> getVideorByid(int id) {
        return Optional.empty();
    }

    public Video getVideorByid(String id) {
        return vr.findById_video(id);
    }

    @Override
    public void updateVideo(Video v) {
        vr.save(v);

    }
}
