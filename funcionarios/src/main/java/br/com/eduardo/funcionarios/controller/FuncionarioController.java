package br.com.eduardo.funcionarios.controller;

import br.com.eduardo.funcionarios.entity.Funcionario;
import br.com.eduardo.funcionarios.service.FuncionarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario salvar(@RequestBody Funcionario funcionario){
        return funcionarioService.salvar(funcionario);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Funcionario> listaFuncionario(){
        return funcionarioService.listaFuncionario();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Funcionario buscarFuncionarioPorId(@PathVariable("id") Long id){
        return funcionarioService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario nao encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerFuncionario(@PathVariable("id") Long id){
        funcionarioService.buscarPorId(id)
                .map(funcionario -> {
                    funcionarioService.removerPorId(funcionario.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario nao encontrado."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarFuncionario(@PathVariable("id") Long id, @RequestBody Funcionario funcionario){
        funcionarioService.buscarPorId(id)
                .map(funcionarioBase -> {
                    modelMapper.map(funcionario, funcionarioBase);
                    funcionarioService.salvar(funcionarioBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario nao encontrado."));
    }


}
