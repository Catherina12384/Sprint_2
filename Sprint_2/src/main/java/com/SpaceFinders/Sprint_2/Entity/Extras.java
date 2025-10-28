package com.SpaceFinders.Sprint_2.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Extras")
public class Extras {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int extras_id;

    @NotNull
    @Column(unique = true)
    @NotBlank(message = "Extras name should not be empty")
    @Pattern(regexp = "[a-zA-z\\s]{2,20}")
    String extrasName;

    @NotNull(message = "Extras status should not be null")
    boolean extrasIsActive = true;

    public Extras(int extras_id, String extrasName, boolean extrasIsActive) {
        this.extras_id = extras_id;
        this.extrasName = extrasName;
        this.extrasIsActive = extrasIsActive;
    }

    public Extras() {}

    public int getExtras_id() {
        return extras_id;
    }

    public void setExtras_id(int extras_id) {
        this.extras_id = extras_id;
    }

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
