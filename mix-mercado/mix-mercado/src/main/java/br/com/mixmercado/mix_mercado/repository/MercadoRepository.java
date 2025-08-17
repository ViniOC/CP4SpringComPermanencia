package br.com.mixmercado.mix_mercado.repository;

import br.com.mixmercado.mix_mercado.model.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MercadoRepository extends JpaRepository<Mercado, Long> {
}