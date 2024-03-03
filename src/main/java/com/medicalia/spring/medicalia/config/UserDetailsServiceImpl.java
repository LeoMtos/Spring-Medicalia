package com.medicalia.spring.medicalia.config;

import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.medicalia.spring.medicalia.model.dto.UsuarioDto;
import com.medicalia.spring.medicalia.model.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


  private final IUsuarioRepository iUsuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsuarioDto usuarioDto = iUsuarioRepository.findByNombreUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));


        String roleName = usuarioDto.getRole().name();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_".concat(roleName));


        return new User(usuarioDto.getNombreUsuario(),
                usuarioDto.getContrasenia(),
                true,
                true,
                true,
                true,
                Collections.singleton(authority));
    }
}
