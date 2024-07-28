package com.daffaulia.undangan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //termasuk setter getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "invitations")
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 30)
    private String relation;
    private Integer numberOfGuest;
}
