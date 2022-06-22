package com.axonactive.training.ebookapp.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Integer publishYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Language language;

    @ManyToOne
    @JoinColumn
    private Publisher publisher;

    @ManyToOne
    @JoinColumn
    private Category category;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "writtenBy")
//    @JoinColumn
//    private List<Contributor> contributors = new ArrayList<>();

    public Ebook(String title, String description, Integer publishYear, Language language, Publisher publisher, Category category) {
        this.title = title;
        this.description = description;
        this.publishYear = publishYear;
        this.language = language;
        this.publisher = publisher;
        this.category = category;
    }
}
