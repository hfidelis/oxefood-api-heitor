package br.com.ifpe.oxefood.modelo.entregador;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class EntregadorService {
    
   @Autowired
   private EntregadorRepository repository;

   @Transactional
   public Entregador save(Entregador entregador) {

       entregador.setHabilitado(Boolean.TRUE);
       return repository.save(entregador);
   }

   public List<Entregador> listarTodos() {
       return repository.findAll();
   }

   public Entregador obterPorID(Long id) {
       return repository.findById(id).get();
   }

   @Transactional
   public void update(Long id, Entregador entregadorAlterado) {

       Entregador entregador = repository.findById(id).get();

       entregador.setNome(entregadorAlterado.getNome());
       entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
       entregador.setCpf(entregadorAlterado.getCpf());
       entregador.setRg(entregadorAlterado.getRg());
       entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
       entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
       entregador.setQtdEntregasRealizadas(entregadorAlterado.getQtdEntregasRealizadas());
       entregador.setValorFrete(entregadorAlterado.getValorFrete());
       entregador.setEnderecoRua(entregadorAlterado.getEnderecoRua());
       entregador.setEnderecoNumero(entregadorAlterado.getEnderecoNumero());
       entregador.setEnderecoBairro(entregadorAlterado.getEnderecoBairro());
       entregador.setEnderecoCidade(entregadorAlterado.getEnderecoCidade());
       entregador.setEnderecoCep(entregadorAlterado.getEnderecoCep());
       entregador.setEnderecoComplemento(entregadorAlterado.getEnderecoComplemento());
       entregador.setEnderecoUf(entregadorAlterado.getEnderecoUf());

       repository.save(entregador);
   }
}
