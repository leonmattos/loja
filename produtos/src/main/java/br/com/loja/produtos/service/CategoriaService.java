package br.com.loja.produtos.service;

import br.com.loja.produtos.domain.Categoria;
import br.com.loja.produtos.repository.CategoriaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoriaService {


    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ObjectMapper objectMapper;

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Page<Categoria> getAll(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receiveMessage(@Payload Categoria categoria) throws JsonProcessingException {
        save(categoria);
        log.info("Mensagem persistida");
    }

}
