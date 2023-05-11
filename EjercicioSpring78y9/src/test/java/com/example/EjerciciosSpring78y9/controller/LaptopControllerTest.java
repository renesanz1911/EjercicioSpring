package com.example.EjerciciosSpring78y9.controller;

import com.example.EjerciciosSpring78y9.entities.LaptopEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {
    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
        ResponseEntity<LaptopEntity[]> response
                = testRestTemplate.getForEntity("/laptops",LaptopEntity[].class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        List<LaptopEntity> laptops = Arrays.asList(response.getBody());
    }

    @Test
    void findById() {
        ResponseEntity<LaptopEntity> response
                = testRestTemplate.getForEntity("/laptops/1",LaptopEntity.class);
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "marca": "Apple",
                    "modelo": "Macbook Pro",
                    "ram": "16GB",
                    "procesador": "Intel Core i5, 4 nucleos",
                    "almacenamiento": "1Tb"
                }
                """;


        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<LaptopEntity> response = testRestTemplate.exchange("/laptops", HttpMethod.POST, request, LaptopEntity.class);

        LaptopEntity result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("Apple",result.getMarca());
    }

    /*No pude hacer que funcione el test del metodo update() en ningun otro caso que no sea cuando no encuentra una
    laptop segun si ID en repository, necesito resolver algunas dudas que no pude en internet, por ejemplo, como simular
    una clase repository */

    @Test
    void update() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "id": 1,
                    "marca": "Apple",
                    "modelo": "Macbook Pro",
                    "ram": "8 GB",
                    "procesador": "Apple M2, 8 nucleos",
                    "almacenamiento": "256 Gb"
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<LaptopEntity> response = testRestTemplate.exchange("/laptops", HttpMethod.PUT, request, LaptopEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void delete() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<LaptopEntity> response
                = testRestTemplate.exchange("/laptops/1", HttpMethod.DELETE, request, LaptopEntity.class);

        assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());

    }

    @Test
    void deleteAll() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<LaptopEntity> response
                = testRestTemplate.exchange("/laptops", HttpMethod.DELETE, request, LaptopEntity.class);

        assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());
    }
}