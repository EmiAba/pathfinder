package bg.softuni.pathfinder.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column()
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name="full_name", nullable = false)
    private String fullName;
    @Column
    private Integer age;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="users_roles",
    joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name="roles_id", referencedColumnName = "id")}

    )
    private Set<Role> role;
    @Column
    @Enumerated(EnumType.STRING)
    private Level level;

    public User() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
