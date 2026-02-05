package com.gatekeeper.config.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gatekeeper.user.infrastructure.mapper.UserMapper;
import com.gatekeeper.user.infrastructure.persistence.entity.UserEntity;
import com.gatekeeper.user.infrastructure.persistence.repository.UserRepositoryImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepositoryImpl userRepositoryImpl;
     private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // com.ezybuy.ecommerce.user.domain.model.User user = userRepositoryImpl.findUserEntityByUsername(username);
        com.gatekeeper.user.domain.model.User user = userRepositoryImpl.findUserEntityByUsername(username);

        if (user == null) {
                System.out.println("Usuario: "+ user + " no encontrado" );
        }

        UserEntity userEntity = userMapper.toEntity(user);

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        userEntity.getRoles()
                .forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));

        userEntity.getRoles().stream()
                .flatMap(role -> role.getPermissionList().stream())
                .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));


        return new User(userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.isEnabled(),
                userEntity.isAccountNoExpired(),
                userEntity.isCredentialNoExpired(),
                userEntity.isAccountNoLocked(),
                authorityList);
    }

}
