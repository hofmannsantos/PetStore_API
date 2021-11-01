// 1- pacote

package petstore;

// 2- Bibliotecas

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

// 3- Classe
public class Pet {
    // 3.1 - Atributos

    String uri = "https://petstore.swagger.io/v2/pet"; // endereço da entidade Pet

    // 3.2 - Metodos e Funçoes
    public String LerJason (String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));

    }

    //incluir - Create - Post

    @Test  //Idetifica o medodo ou função que é um teste para o TestNG
    public void incluirPet() throws IOException {
        String jsonBody = LerJason("db/pet1.json");


        //Sintaxe Gherkin
        // Dado -  Quando - Então
        // Given -  When  - Then


        given() //Dado
                .contentType("application/json") // Commum em API REST - Antigos era "test/xml"
                .log().all()
                .body(jsonBody)

        .when() //Quando
                .post(uri)
        .then() //Então
                .log().all()
                .statusCode(200)

        ;

    }


}
