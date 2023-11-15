package br.com.eduardo.funcionarios.service;

import br.com.eduardo.funcionarios.entity.Funcionario;
import br.com.eduardo.funcionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario salvar(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listaFuncionario(){
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarPorId(Long id){
        return funcionarioRepository.findById(id);
    }

    public void removerPorId(Long id){
        funcionarioRepository.deleteById(id);
    }
}
