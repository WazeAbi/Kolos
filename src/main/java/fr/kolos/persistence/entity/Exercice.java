package fr.kolos.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exercice")
public class Exercice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEx;
    @Column(name = "name_exercice")
    private int nameExercice;
    @Column(name = "description")
    private String description;
    @Column(name = "url_image")
    private String urlImage;

    public int getIdEx() {
        return idEx;
    }

    public void setIdEx(int idEx) {
        this.idEx = idEx;
    }

    public int getNameExercice() {
        return nameExercice;
    }

    public void setNameExercice(int nameExercice) {
        this.nameExercice = nameExercice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
