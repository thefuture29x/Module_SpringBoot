package com.example.module_javaspringboot_finalproject.entities;

import com.example.module_javaspringboot_finalproject.config.AuthProvider;
import com.example.module_javaspringboot_finalproject.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String avatar;

    private boolean enabled;
    @Column(name = "reset_password_token")
    private String resetPassWordToken;

    @Enumerated(EnumType.STRING)
    @Column(name = "auth_provider")
    private AuthProvider authProvider;

    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
    private List<CommentsEntity> commentsEntityList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<RoleEntity> roleEntityList;

    public static UserDTO toDTO(UserEntity entity){
        return UserDTO.builder()
                .id(entity.id)
                .username(entity.username)
                .email(entity.email)
                .enabled(entity.enabled)
                .authProvider(entity.authProvider)
                .avatar(entity.avatar)
                .build();
    }
}
