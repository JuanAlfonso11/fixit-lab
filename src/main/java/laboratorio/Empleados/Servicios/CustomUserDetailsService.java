package laboratorio.Empleados.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import laboratorio.Empleados.Entidades.Bionalista;
import laboratorio.Empleados.Entidades.Secretaria;
import laboratorio.Empleados.Repositorios.BionalistaRepository;
import laboratorio.Empleados.Repositorios.SecretariaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final SecretariaRepository secretariaRepository;
    private final BionalistaRepository bionalistaRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomUserDetailsService(SecretariaRepository secretariaRepository, BionalistaRepository bionalistaRepository, PasswordEncoder passwordEncoder) {
        this.secretariaRepository = secretariaRepository;
        this.bionalistaRepository = bionalistaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return User.withUsername("admin")
                    .password(passwordEncoder.encode("admin"))
                    .authorities(Collections.singletonList(new SimpleGrantedAuthority("ADMIN")))
                    .build();
        }

        Secretaria secretaria = secretariaRepository.findByUsuario(username);
        if (secretaria != null) {
            return new User(secretaria.getUsuario(), secretaria.getPassword(), getAuthorities(secretaria));
        }

        Bionalista bionalista = bionalistaRepository.findByUsuario(username);
        if (bionalista != null) {
            return new User(bionalista.getUsuario(), bionalista.getPassword(), getAuthorities(bionalista));
        }

        throw new UsernameNotFoundException("User not found");
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Object user) {
        if (user instanceof Secretaria) {
            return Collections.singletonList(new SimpleGrantedAuthority("SECRETARIA"));
        } else if (user instanceof Bionalista) {
            return Collections.singletonList(new SimpleGrantedAuthority("BIONALISTA"));
        }
        return Collections.emptyList();
    }
}
