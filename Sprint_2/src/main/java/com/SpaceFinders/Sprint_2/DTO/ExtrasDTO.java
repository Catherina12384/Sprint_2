package com.SpaceFinders.Sprint_2.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ExtrasDTO {

    @NotNull
    @NotBlank(message = "Extras name should not be empty")
    @Column(unique = true)
    @Pattern(regexp = "[a-zA-z\\s ]{2,20}")
    String extrasName;

    @NotNull
    boolean extrasIsActive = true;

    public ExtrasDTO(String extrasName, boolean extrasIsActive) {
        this.extrasName = extrasName;
        this.extrasIsActive = extrasIsActive;
    }

    public ExtrasDTO() {}

    public String getExtrasName() {
        return extrasName;
    }

    public void setExtrasName(String extrasName) {
        this.extrasName = extrasName;
    }

    public boolean getExtrasIsActive() {
        return extrasIsActive;
    }

    public void setExtrasIsActive(boolean extrasIsActive) {
        this.extrasIsActive = extrasIsActive;
    }
}