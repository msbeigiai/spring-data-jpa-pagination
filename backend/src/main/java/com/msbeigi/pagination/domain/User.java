package com.msbeigi.pagination.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "users_sequence", sequenceName = "users_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    private Long id;
    private String name;
    private String email;
    private String status;
    private String address;
    private String phone;
    private String imageUrl;
}
