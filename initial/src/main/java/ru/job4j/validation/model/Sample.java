package ru.job4j.validation.model;

import java.util.Objects;

public class Sample {
    private int id;
    private String title;
    private String description;

    private int numberField;

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
}
