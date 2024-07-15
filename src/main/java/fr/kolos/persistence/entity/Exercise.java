package fr.kolos.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exercise")
	private int idExercise;
    @Column(name = "name_exercise")
    private String nameExercise;
    @Column(name = "description")
    private String description;
    @Column(name = "url_image")
    private String urlImage;

    public int getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(int idEx) {
        this.idExercise = idEx;
    }

    public String getNameExercise() {
        return nameExercise;
    }

    public void setNameExercise(String nameExercise) {
        this.nameExercise = nameExercise;
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
