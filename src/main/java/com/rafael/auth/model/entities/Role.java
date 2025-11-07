package com.rafael.auth.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
