package com.axonactive.training.ebookapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private ContributorType type;

    @ManyToOne
    @JoinColumn
    private Author author;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn
    private Ebook ebook;

}
