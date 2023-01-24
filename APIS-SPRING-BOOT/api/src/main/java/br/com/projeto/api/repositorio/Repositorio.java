package br.com.projeto.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import br.com.projeto.api.modelo.Pessoa;
import jakarta.transaction.Transactional;

//@Repository
@Transactional
public interface Repositorio extends JpaRepository<Pessoa, Integer>{

    List<Pessoa> findAll();

    Pessoa findByCodigo(int codigo);
    
}
