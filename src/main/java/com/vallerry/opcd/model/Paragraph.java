package com.vallerry.opcd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paragraphs")
public class Paragraph {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String description;
    private String imagePath;
    @ManyToOne
    @JoinColumn(name = "pattern_id")
    private Pattern pattern;

    @Transient
    public String getPhotosImagePath() {
        if (imagePath == null || id == null) return null;
        return imagePath;
    }
}
