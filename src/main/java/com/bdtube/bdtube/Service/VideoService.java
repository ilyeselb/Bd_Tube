package com.bdtube.bdtube.Service;

import com.bdtube.bdtube.Model.User;
import com.bdtube.bdtube.Model.Video;

import java.util.List;
import java.util.Optional;

public interface VideoService {
    public List<Video> getAll();
    public void addVideo(Video v);
    public void deleteVideo(String id);
    public Optional<Video> getVideorByid(int id);
    public void updateVideo(Video v);
}
