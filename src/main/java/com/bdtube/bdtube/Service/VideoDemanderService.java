package com.bdtube.bdtube.Service;

import com.bdtube.bdtube.Model.Account;
import com.bdtube.bdtube.Model.VideoDemander;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

public interface VideoDemanderService  {
    public List<VideoDemander> getAll();
    public void addVideoDemander(VideoDemander videoDemander);
    public void deleteVideoDemander(String id);
    public Optional<VideoDemander> getVideoDemanderByid(int id);
    public void updateVideoDemander(VideoDemander videoDemander);
}
