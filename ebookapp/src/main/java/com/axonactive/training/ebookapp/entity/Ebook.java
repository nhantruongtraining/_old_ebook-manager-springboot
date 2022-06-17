package com.axonactive.training.ebookapp.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ebook {
    @Id
    @Column(name = "id", columnDefinition = "uuid")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Integer publishYear;

    @ManyToOne
    @JoinColumn
    private Language language;

    @ManyToOne
    @JoinColumn
    private Publisher publisher;

    @ManyToOne
    @JoinColumn
    private Category category;

    public Ebook(String title, String description, Integer publishYear, Language language, Publisher publisher, Category category) {
        this.title = title;
        this.description = description;
        this.publishYear = publishYear;
        this.language = language;
        this.publisher = publisher;
        this.category = category;
    }
}
