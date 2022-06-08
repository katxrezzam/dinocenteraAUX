package com.kat.dinocenter.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioServiceAPI {

    public Page<Usuario> listarPage(Pageable pageable);
    public Long cantidad();
    public void guardar(Usuario usuario);
    public void eliminar(Long id);
    public List<Usuario> listar();
    public Usuario buscar(Long id);
}
