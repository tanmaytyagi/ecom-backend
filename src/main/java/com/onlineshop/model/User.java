package com.onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  @Id
  @Column(nullable = false, unique = true)
  private String userId;

  private String name;
  private String email;
  private String mobile;
  private String password;
}
