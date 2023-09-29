package com.giovana.library.services;

import com.giovana.library.entity.Livro;
import com.giovana.library.entity.Usuario;
import com.giovana.library.repositories.UsuarioRepository;
import org.springframework.dao.DataIntegrityViolationException;
import com.giovana.library.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario findById(Integer id){
        Optional<Usuario> user = usuarioRepository.findById(id);
        return user.orElseThrow( () -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+id+" - Tipo: "+ Usuario.class.getName()));
    }

    public List<Usuario> findByNome(String nome){
        Optional<List<Usuario>> users = usuarioRepository.findByNomeContainingIgnoringCase(nome);
        return users.orElseThrow( () -> new ObjectNotFoundException(
                "Nenhum usuário encontrado! "));
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario create(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Integer id, Usuario usuario){
        Usuario newUsuario = findById(id);
        updateData(newUsuario, usuario);

        return usuarioRepository.save(newUsuario);
    }

    private void updateData(Usuario newUsuario, Usuario usuario){
        newUsuario.setNome(usuario.getNome());
        newUsuario.setEmail(usuario.getEmail());
        newUsuario.setCpf(usuario.getCpf());
    }

    public void delete(Integer id) {
        findById(id);
        try {
            usuarioRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new com.giovana.library.services.exceptions.DataIntegrityViolationException(
                    "Usuário não pode ser excluido! Possui emprestimos associados" );
        }
    }
}
