package uz.digitalone.appgmuzbekistan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 2/1/2022
 * Time: 6:55 PM
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence")
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();

    public User(String fullName, String email, Address address, Set<Role> roles) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.roles = roles;
    }
}
