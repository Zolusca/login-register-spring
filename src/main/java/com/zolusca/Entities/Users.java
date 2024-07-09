package com.zolusca.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 50, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(unique = true,length = 50,nullable = false)
    private String email;
    @OneToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Roles role;
}
