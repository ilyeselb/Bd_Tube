package com.bdtube.bdtube.Model;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "videodemander")
@Getter
@Setter
public class VideoDemander {
    @Id
    @Column(name = "id_video")
    private String id_video;
    @NotBlank
    @Column(name = "lien")

    private String lien;
    @NotBlank
    @Column(name = "categorie")

    private String categorie;
    @NotBlank
    @Column(name = "title")

    private String title ;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
     @NotNull
     @Column(name="acceptation")
     private int acceptation ;

    public int getAcceptation() {
        return acceptation;
    }

    public void setAcceptation(int acceptation) {
        this.acceptation = acceptation;
    }

    @Column(name = "rate")


    private Long Rate;
    @ManyToOne(optional = false,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties("videodemander")
    private User user_acceptation;
    @Column(name = "description")
    private  String description;
    @Column(name = "imgUrl")
    private String imgUrl;

    public String getId_video() {
        return id_video;
    }

    public void setId_video(String id_video) {
        this.id_video = id_video;
    }

    public void setLien(String lien) {
        this.lien = lien;
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

    public User getUser_acceptation() {
        return user_acceptation;
    }

    public void setUser_acceptation(User user_acceptation) {
        this.user_acceptation = user_acceptation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLien() {
        return lien;
    }

    @Override
    public String toString() {
        return "VideoDemander{" +
                "id_video='" + id_video + '\'' +
                ", lien='" + lien + '\'' +
                ", categorie='" + categorie + '\'' +
                ", title='" + title + '\'' +

                ", Rate=" + Rate +
                ", user_acceptation=" + user_acceptation +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    public VideoDemander() {
    }

    public VideoDemander(@NotBlank String lien, @NotBlank String title, String description, String imgUrl) {
        this.lien = lien;
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public VideoDemander(@NotBlank String lien, @NotBlank String categorie, @NotBlank String title, Date date_post, @NotBlank Long rate, User user_acceptation, String description, String imgUrl) {
        this.lien = lien;
        this.categorie = categorie;
        this.title = title;
        Rate = rate;
        this.user_acceptation = user_acceptation;
        this.description = description;
        this.imgUrl = imgUrl;
    }
}
