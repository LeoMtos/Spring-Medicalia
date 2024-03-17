package com.medicalia.spring.medicalia.config;

import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.medicalia.spring.medicalia.persistence.entity.UsuarioEntity;
import com.medicalia.spring.medicalia.persistence.repository.crud.IUsuarioCrudRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


  private final IUsuarioCrudRepository iUsuarioCrudRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsuarioEntity usuarioEntity = iUsuarioCrudRepository.findByNombreUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));


        String roleName = usuarioEntity.getRole().name();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_".concat(roleName));


        return new User(usuarioEntity.getNombreUsuario(),
                usuarioEntity.getContrasenia(),
                true,
                true,
                true,
                true,
                Collections.singleton(authority));
    }
}
