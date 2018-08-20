package com.bdtube.bdtube.Service;

import com.bdtube.bdtube.Model.Chanel;

import java.util.List;
import java.util.Optional;

public interface ChanelService {
    public List<Chanel> getAll();
    public void addChanel(Chanel chanel);
    public void deleteChanel(int id);
    public Optional<Chanel> getChanelByid(int id);
    public void updateChanel(Chanel chanel);
}
