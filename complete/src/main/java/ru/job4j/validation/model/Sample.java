package ru.job4j.validation.model;

import javax.validation.constraints.*;
import java.util.Objects;

public class Sample {
    private int id;
    @NotBlank
    private String title;
    @Size(min = 5, max = 1000, message = "Длина строки должна быть от 5 до 1000 символов")
    private String description;
    @Min(1)
    @Max(50)
    private int numberField;
    @Digits(integer=3, fraction=0, message="Это поле должно состоять не более чем из трех цифр")
    private String onlyDigits;

    public Sample() {
    }

    public Sample(int id, String title, String description, int numberField, String onlyDigits) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.numberField = numberField;
        this.onlyDigits = onlyDigits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberField() {
        return numberField;
    }

    public void setNumberField(int numberField) {
        this.numberField = numberField;
    }

    public String getOnlyDigits() {
        return onlyDigits;
    }

    public void setOnlyDigits(String onlyDigits) {
        this.onlyDigits = onlyDigits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sample sample = (Sample) o;
        return id == sample.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
