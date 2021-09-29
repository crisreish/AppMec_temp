package br.edu.infnet.appmec.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmec.model.domain.Pedido;
import br.edu.infnet.appmec.model.domain.Usuario;
import br.edu.infnet.appmec.model.repository.PedidoRepository;



@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> obterLista(Usuario usuario){
        return pedidoRepository.obterLista(usuario.getId());
    }

    public List<Pedido> obterLista(){

        return (List<Pedido>) pedidoRepository.findAll();
    }

    public void incluir(Pedido pedido) {

        pedidoRepository.save(pedido);
    }

    public void excluir(Integer id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido obterPorId(Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }
    public Integer obterQtde() {
        return (int) pedidoRepository.count();
    }
}