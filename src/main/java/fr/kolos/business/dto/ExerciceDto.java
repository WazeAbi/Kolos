package fr.kolos.business.dto;

public class ExerciceDto {
    private int idEx;
    private String nameExercice;
    private String description;
    private String urlImage;

    public int getIdEx() {
        return idEx;
    }

    public void setIdEx(int idEx) {
        this.idEx = idEx;
    }

    public String getNameExercice() {
        return nameExercice;
    }

    public void setNameExercice(String nameExercice) {
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
