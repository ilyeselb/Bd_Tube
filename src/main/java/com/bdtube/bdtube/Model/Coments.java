package com.bdtube.bdtube.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "coments")
@Getter
@Setter


public class Coments {
    @Id
    private String id_coments;
    private String comensts;
    private String authorname;
    private String authorurl;

    public String getId_coments() {
        return id_coments;
    }

    public void setId_coments(String id_coments) {
        this.id_coments = id_coments;
    }

    public String getComensts() {
        return comensts;
    }

    public void setComensts(String comensts) {
        this.comensts = comensts;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getAuthorurl() {
        return authorurl;
    }

    public void setAuthorurl(String authorurl) {
        this.authorurl = authorurl;
    }
}
