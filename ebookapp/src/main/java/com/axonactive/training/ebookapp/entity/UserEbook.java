package com.axonactive.training.ebookapp.entity;

import com.axonactive.training.ebookapp.security.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    private LocalDateTime uploadDate;

    @Column
    private String coverImage;

    @Column
    private boolean favorite;

    @Column
    @Enumerated(EnumType.STRING)
    private UserEbookStatus status;

    @ManyToOne
    @JoinColumn
    private Ebook ebook;

    @ManyToOne
    @JoinColumn
    private User user;

    public UserEbook(Ebook ebook, User user, boolean favorite, String ebookStatus) {
        this.ebook = ebook;
        this.user = user;
        this.favorite = favorite;
        this.status = UserEbookStatus.valueOf(ebookStatus);
    }
}
