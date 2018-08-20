package com.bdtube.bdtube.Model;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "video")
@Getter
@Setter
public class Video {
    @Id
    @Column(name = "id_video")
    private String id_video;
    @NotBlank
    private String lien;
    @NotBlank
    private String categorie;
    @NotBlank
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    private Long Rate;

    private String description;
    private String imgUrl;
    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getId_video() {

        return id_video;
    }

    public void setId_video(String id_video) {
        this.id_video = id_video;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;

    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }


    public Long getRate() {
        return Rate;
    }

    public void setRate(Long rate) {
        Rate = rate;
    }



    public Chanel getChanel_ofvideo() {
        return chanel_ofvideo;
    }

    public void setChanel_ofvideo(Chanel chanel_ofvideo) {
        this.chanel_ofvideo = chanel_ofvideo;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chanel_id")
    private Chanel chanel_ofvideo;
    private int accpetation;
    @Override
    public String toString() {
        return "Video{" +
                "id_video='" + id_video + '\'' +
                ", lien='" + lien + '\'' +
                ", categorie='" + categorie + '\'' +
                ", title='" + title + '\'' +
                ", Rate=" + Rate +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", chanel_ofvideo=" + chanel_ofvideo +
                ", accpetation=" + accpetation +
                '}';
    }


    public int getAccpetation() {
        return accpetation;
    }

    public void setAccpetation(int accpetation) {
        this.accpetation = accpetation;
    }
}
