package com.beyondlabs.backend_assignment.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
public class TodoModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String title;
    private String description;

    @Column(nullable = false)
    private String status;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
