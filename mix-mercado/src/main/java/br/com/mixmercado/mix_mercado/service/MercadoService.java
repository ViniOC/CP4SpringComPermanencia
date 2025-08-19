package br.com.mixmercado.mix_mercado.service;

import br.com.mixmercado.mix_mercado.model.Mercado;
import br.com.mixmercado.mix_mercado.repository.MercadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercadoService {

    private final MercadoRepository repository;

    public MercadoService(MercadoRepository repository) {
        this.repository = repository;
    }

    public List<Mercado> findAll() {
        return repository.findAll();
    }

    public Mercado findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Mercado save(Mercado mercado) {
        return repository.save(mercado);
    }

    public Mercado update(Long id, Mercado mercado) {
        Mercado existing = findById(id);
        existing.setNome(mercado.getNome());
        existing.setTipo(mercado.getTipo());
        existing.setSetor(mercado.getSetor());
        existing.setTamanho(mercado.getTamanho());
        existing.setPreco(mercado.getPreco());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
