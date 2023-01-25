package br.com.projeto.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import br.com.projeto.api.modelo.Pessoa;
import jakarta.transaction.Transactional;

//@Repository
@Transactional
public interface Repositorio extends JpaRepository<Pessoa, Integer>{

    List<Pessoa> findAll();

    Pessoa findByCodigo(int codigo);

    List<Pessoa> findByOrderByNomeDesc();

    List<Pessoa> findByNomeOrderByIdade(String nome);

    List<Pessoa> findByNomeContaining(String termo);

    List<Pessoa> findByNomeStartsWith(String termo);

    List<Pessoa> findByNomeEndsWith(String termo);
    
    @Query(value = "SELECT SUM(idade) FROM pessoas", nativeQuery = true)
    int somaIdades();

    @Query(value = "SELECT * FROM pessoas WHERE idade >= :idade", nativeQuery = true)
    List<Pessoa> idadeMaiorIgual(int idade);

    int countByCodigo(int codigo);
}
