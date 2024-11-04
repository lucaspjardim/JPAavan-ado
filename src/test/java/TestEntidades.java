import org.br.lucaspjardim.dao.*;
import org.br.lucaspjardim.domain.Acessorio;
import org.br.lucaspjardim.domain.Carro;
import org.br.lucaspjardim.domain.Marca;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

/**
 * Author: Lucas Jardim
 */
public class TestEntidades {

    private ICarroDAO carroDAO;

    private IMarcaDAO marcaDAO;

    private IAcessorioDAO acessorioDAO;

    public TestEntidades() {
        carroDAO = new CarroDAO();
        marcaDAO = new MarcaDAO();
        acessorioDAO = new AcessorioDAO();
    }

    @Test
    public void cadastrar() {
        Marca marca = criarMarca("Fiat");
        Acessorio acessorio1 = criarAcessorio("Ar Condicionado");
        Acessorio acessorio2 = criarAcessorio("Banco de Couro");

        Carro carro = new Carro();
        carro.setModelo("Palio");
        carro.setMarca(marca);
        carro.setAcessorios(Arrays.asList(acessorio1, acessorio2));

        carro = carroDAO.cadastrar(carro);


        assertNotNull(carro);
        assertNotNull(carro.getId());
    }

    private Marca criarMarca(String nome) {
        Marca marca = new Marca();
        marca.setNome(nome);
        return marcaDAO.cadastrar(marca);
    }

    private Acessorio criarAcessorio(String nome) {
        Acessorio acessorio = new Acessorio();
        acessorio.setNome(nome);
        return acessorioDAO.cadastrar(acessorio);
    }
}
