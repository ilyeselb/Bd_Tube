package com.bdtube.bdtube.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "chanel")
@Getter
@Setter
public class Chanel {
    @Id
    private String id_chanel;
    @NotBlank
    private String Titre;
    private String lienimg ;
    private String description ;

    public String getId_chanel() {
        return id_chanel;
    }

    public void setId_chanel(String id_chanel) {
        this.id_chanel = id_chanel;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getLienimg() {
        return lienimg;
    }

    public void setLienimg(String lienimg) {
        this.lienimg = lienimg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Video> getVideo() {
        return video;
    }

    public void setVideo(List<Video> video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Chanel{" +
                "id_chanel='" + id_chanel + '\'' +
                ", Titre='" + Titre + '\'' +
                ", lienimg='" + lienimg + '\'' +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                ", video=" + video +
                '}';
    }

    @ManyToOne
    private User owner ;
    @OneToMany(mappedBy = "chanel_ofvideo")
    private List<Video> video;
}
