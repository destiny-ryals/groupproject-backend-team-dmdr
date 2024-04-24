package com.DMDR.workout.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;


@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Table(name="goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @NonNull
    private String title;

    @NonNull
    private String description;

    private Double progress;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date startDate;

    @PrePersist
    public void onCreate() {
        startDate = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        startDate = new Date();
    }

    @NonNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date endDate;

    @ManyToOne()
    @JoinColumn(name = "person")
    private Person person;

    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }
    public Double getProgress() {
        return progress;
    }

    public void addToCurrentProgress(Double addProgress) {
        progress += addProgress;
    }
}
