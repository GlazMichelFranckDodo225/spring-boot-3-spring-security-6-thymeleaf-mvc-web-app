package com.dgmf.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.Collection;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "tbl_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    private String lastName;
    // The email must be unique in the DB, but must editable
    @Column(name = "email", nullable = false, length = 45)
    @NaturalId(mutable = true)
    private String email;
    @Column(name = "password", nullable = false, length = 15)
    private String password;
    private boolean isEnabled;
    // FetchType.EAGER ==> La relation est chargée par défaut (en même temps
    // que l'entité qui la porte) ==> "User"
    // CascadeType.ALL ==> propage toutes les opérations, y compris celles
    // spécifiques à Hibernate, du parent (User) à l'entité enfant (Role)
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // Specifies the table used for the joining foreign-keys
    @JoinTable(name = "user_roles",
            // Defines mapping for composite foreign keys (marks a column
            // as a join column for an entity association)
            joinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName = "id")
    )
    private Collection<Role> roles;

    public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
