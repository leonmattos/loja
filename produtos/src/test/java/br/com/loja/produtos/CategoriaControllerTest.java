package br.com.loja.produtos;


import br.com.loja.produtos.domain.Categoria;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CategoriaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void validaSalvarCategoria() throws Exception {
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNome("Brinquedos");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/categoria")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(categoria));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Categoria categoriaSaved = objectMapper.readValue(result.getResponse().getContentAsString(), Categoria.class);

        Assert.assertEquals(result.getResponse().getStatus(),200);
        Assert.assertEquals(categoriaSaved.getNome(), categoria.getNome());
    }
}
