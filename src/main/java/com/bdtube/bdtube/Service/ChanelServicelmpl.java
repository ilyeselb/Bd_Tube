package com.bdtube.bdtube.Service;

import com.bdtube.bdtube.Model.Chanel;
import com.bdtube.bdtube.Repository.ChanelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChanelServicelmpl implements ChanelService{
    ChanelRepository cr ;
    @Override
    public List<Chanel> getAll() {
        return (List<Chanel>) cr.findAll();
    }

    @Override
    public void addChanel(Chanel chanel) {
        cr.save(chanel);

    }

    @Override
    public void deleteChanel(int id) {
        cr.deleteById(id);

    }

    @Override
    public Optional<Chanel> getChanelByid(int id) {
        return cr.findById(id);
    }

    @Override
    public void updateChanel(Chanel chanel) {
        cr.equals(chanel);

    }
}
