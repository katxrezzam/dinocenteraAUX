package com.kat.dinocenter.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements  UsuarioServiceAPI{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Page<Usuario> listarPage(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    public Long cantidad() {
        return usuarioRepository.count();
    }

    @Override
    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> listar() {
        return (List<Usuario>)  usuarioRepository.findAll();
    }

    @Override
    public Usuario buscar(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
