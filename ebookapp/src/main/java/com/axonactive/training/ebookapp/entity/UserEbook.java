//package com.axonactive.training.ebookapp.entity;
//
//import com.axonactive.training.ebookapp.security.entity.User;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class UserEbook {
//
//    @CreationTimestamp
//    private LocalDateTime uploadDate;
//
//    @Column
//    private String coverImage;
//
//    @Column
//    private boolean favorite;
//
//    @Column
//    @Enumerated(EnumType.STRING)
//    private UserEbookStatus status;
//
//    @ManyToOne
//    @JoinColumn
//    private Ebook ebook;
//
//    @ManyToOne
//    @JoinColumn
//    private User user;
//}
