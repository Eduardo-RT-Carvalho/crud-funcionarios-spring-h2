package br.com.eduardo.funcionarios.repository;

import br.com.eduardo.funcionarios.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
