package fr.kolos.business.dto;

public class ExerciseDto {
    private int idExercise;
    private String nameExercise;
    private String description;
    private String urlImage;

    public int getIdEx() {
        return idExercise;
    }

    public void setIdEx(int idEx) {
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
