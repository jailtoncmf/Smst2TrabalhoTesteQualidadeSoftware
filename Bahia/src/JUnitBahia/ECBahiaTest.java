package JUnitBahia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ECBahiaTest {
    private ECBahia meuTime;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogador3;
    private Jogador jogador4;
    private Jogador jogador5;
    private Jogador jogador6;
    private Jogador jogador7;
    private Jogador jogador8;
    private Jogador jogador9;
    private Jogador jogador10;
    private Jogador jogador11;
    private Jogador jogador12;
    private Jogador jogador13;
    private Jogador jogador14;
    private Treinador treinador1;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        meuTime = new ECBahia("EC Bahia");
        jogador1 = new Jogador("Cauly Oliveira",null, 8,"Titular", 500000, 28, "Brasil" +" / " + "Alemanha","Meia Ofensivo");
        jogador2 = new Jogador("Ademir da Silva","Fumacinha", 7,"Titular", 300000, 28, "Brasil", "Ponta Direita");
        jogador3 = new Jogador("Gabriel Teixeira", "Biel" ,10,"Titular", 400000, 22, "Brasil", "Ponta Esquerda");
        jogador4 = new Jogador("Rafael Rogério","Ratão", 11,"Titular", 400000, 27, "Brasil", "Ponta Esquerda");
        jogador5 = new Jogador("Thaciano da Silva",null, 16,"Titular", 300000, 28, "Brasil", "Meia Central");
        jogador6 = new Jogador("Júlio César","Rezende", 5,"Titular", 300000, 28, "Brasil", "Volante");
        jogador7 = new Jogador("Nicolás Acevedo",null, 26,"Reserva", 300000, 24, "Uruguai", "Volante");
        jogador8 = new Jogador("Gilberto Moraes",null, 2,"Titular", 400000, 30, "Brasil","Lateral Direito");
        jogador9 = new Jogador("Camilo Cândido",null, 38,"Titular", 400000, 28, "Uruguai","Lateral Esquerdo");
        jogador10 = new Jogador("Victor Hugo","Kanu", 4,"Titular", 500000, 26, "Brasil","Zagueiro");
        jogador11 = new Jogador("Everaldo Stum","Eve", 9,"Titular", 700000, 32, "Brasil", "Centroavante");
        jogador12 = new Jogador("Francisco Vitor","Jacaré", 29,"Reserva", 90000, 23, "Brasil", "Ponta Esquerda");
        jogador13 = new Jogador("Luciano Batista","Juba", 46,"Reserva", 300000, 24, "Brasil", "Ponta Esquerda");
        jogador14 = new Jogador("Marcos Felipe",null, 22,"Titular", 200000, 27, "Brasil", "Goleiro");
        treinador1 = new Treinador("Rogério Ceni",50, 1000000, "Brasil");

        meuTime.adicionarJogador(jogador1);
        meuTime.adicionarJogador(jogador2);
        meuTime.adicionarJogador(jogador3);
        meuTime.adicionarJogador(jogador4);
        meuTime.adicionarJogador(jogador5);
        meuTime.adicionarJogador(jogador6);
        meuTime.adicionarJogador(jogador7);
        meuTime.adicionarJogador(jogador8);
        meuTime.adicionarJogador(jogador9);
        meuTime.adicionarJogador(jogador10);
        meuTime.adicionarJogador(jogador11);
        meuTime.adicionarJogador(jogador12);
        meuTime.adicionarJogador(jogador13);
        meuTime.adicionarJogador(jogador14);
        meuTime.adicionarTreinador(treinador1);


        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testPagarSalarios() {
        meuTime.pagarSalarios();

        String output = outputStream.toString().trim();

        assertTrue(output.contains("Salário pago para Cauly Oliveira no valor de R$500000"));
        assertTrue(output.contains("Salário pago para Ademir da Silva no valor de R$300000"));
        assertTrue(output.contains("Salário pago para Gabriel Teixeira no valor de R$400000"));
        assertTrue(output.contains("Salário pago para Rafael Rogério no valor de R$400000"));
        assertTrue(output.contains("Salário pago para Thaciano da Silva no valor de R$300000"));
        assertTrue(output.contains("Salário pago para Júlio César no valor de R$300000"));
        assertTrue(output.contains("Salário pago para Nicolás Acevedo no valor de R$300000"));
        assertTrue(output.contains("Salário pago para Gilberto Moraes no valor de R$400000"));
        assertTrue(output.contains("Salário pago para Camilo Cândido no valor de R$400000"));
        assertTrue(output.contains("Salário pago para Victor Hugo no valor de R$500000"));
        assertTrue(output.contains("Salário pago para Everaldo Stum no valor de R$700000"));
        assertTrue(output.contains("Salário pago para Francisco Vitor no valor de R$90000"));
        assertTrue(output.contains("Salário pago para Luciano Batista no valor de R$300000"));
        assertTrue(output.contains("Salário pago para Marcos Felipe no valor de R$200000"));
        assertTrue(output.contains("Salário pago para o treinador Rogério Ceni no valor de R$1000000"));

    }
    @Test
    public void testConstrutorECBahia() {
        assertEquals("EC Bahia", meuTime.getNome());
        assertEquals(14, meuTime.getJogadores().size());
        
        Jogador jogador1 = meuTime.getJogadores().get(0);
        assertEquals("Cauly Oliveira", jogador1.getNome());
        assertEquals(8, jogador1.getNumeroCamisa());
        assertEquals("Titular", jogador1.getStatus());
        assertEquals(500000, jogador1.getSalario());
        assertEquals(28, jogador1.getIdade());
        assertEquals("Brasil / Alemanha", jogador1.getNacionalidade());
        assertEquals("Meia Ofensivo", jogador1.getPosicao());

        Jogador jogador2 = meuTime.getJogadores().get(1);
        assertEquals("Ademir da Silva", jogador2.getNome());
        assertEquals(7, jogador2.getNumeroCamisa());
        assertEquals("Titular", jogador2.getStatus());
        assertEquals(300000, jogador2.getSalario());
        assertEquals(28, jogador2.getIdade());
        assertEquals("Brasil", jogador2.getNacionalidade());
        assertEquals("Ponta Direita", jogador2.getPosicao());


        Jogador jogador14 = meuTime.getJogadores().get(13);
        assertEquals("Marcos Felipe", jogador14.getNome());
        assertEquals(22, jogador14.getNumeroCamisa());
        assertEquals("Titular", jogador14.getStatus());
        assertEquals(200000, jogador14.getSalario());
        assertEquals(27, jogador14.getIdade());
        assertEquals("Brasil", jogador14.getNacionalidade());
        assertEquals("Goleiro", jogador14.getPosicao());
    }
    @Test
    public void testAdicionarJogadorProximaId() {
        assertEquals(1, jogador1.getId());
        assertEquals(2, jogador2.getId());
        assertEquals(3, jogador3.getId());
        assertEquals(4, jogador4.getId());
        assertEquals(5, jogador5.getId());
        assertEquals(6, jogador6.getId());
        assertEquals(7, jogador7.getId());
        assertEquals(8, jogador8.getId());
        assertEquals(9, jogador9.getId());
        assertEquals(10, jogador10.getId());
        assertEquals(11, jogador11.getId());
        assertEquals(12, jogador12.getId());
        assertEquals(13, jogador13.getId());
        assertEquals(14, jogador14.getId());
    }
    @Test
    public void testListarPlantel() {
        meuTime.listarPlantel();
        String output = outputStream.toString().trim();

        assertTrue(output.contains("Plantel do time EC Bahia:"));
        
        assertTrue(output.contains("Treinador:"));
        assertTrue(output.contains("Rogério Ceni"));

        assertTrue(output.contains("Jogadores:"));

        assertTrue(output.contains("Cauly Oliveira"));
        assertTrue(output.contains("Ademir da Silva"));
        assertTrue(output.contains("Gabriel Teixeira"));
        assertTrue(output.contains("Rafael Rogério"));
        assertTrue(output.contains("Thaciano da Silva"));
        assertTrue(output.contains("Júlio César"));
        assertTrue(output.contains("Nicolás Acevedo"));
        assertTrue(output.contains("Gilberto Moraes"));
        assertTrue(output.contains("Camilo Cândido"));
        assertTrue(output.contains("Victor Hugo"));
        assertTrue(output.contains("Everaldo Stum"));
        assertTrue(output.contains("Francisco Vitor"));
        assertTrue(output.contains("Luciano Batista"));
        assertTrue(output.contains("Marcos Felipe"));
    }
    @Test
    public void testRemoverJogador() {
        Jogador jogadorRemover = new Jogador("Jogador Para Remover", null, 99, "Titular", 1000000, 25, "Brasil", "Atacante");
        meuTime.adicionarJogador(jogadorRemover);

        assertTrue(meuTime.getJogadores().contains(jogadorRemover));

        meuTime.removerJogador(jogadorRemover);

        assertFalse(meuTime.getJogadores().contains(jogadorRemover));
    }
    @Test
    public void testAdicionarJogador() {
        Jogador novoJogador = new Jogador("Novo Jogador", null, 88, "Titular", 800000, 23, "Brasil", "Meia Ofensivo");

        assertFalse(meuTime.getJogadores().contains(novoJogador));

        meuTime.adicionarJogador(novoJogador);

        assertTrue(meuTime.getJogadores().contains(novoJogador));
    }
    @Test
    public void testAdicionarTreinador() {
        Treinador novoTreinador = new Treinador("Novo Treinador", 45, 1200000, "Argentina");

        assertFalse(meuTime.getTreinador().contains(novoTreinador));

        meuTime.adicionarTreinador(novoTreinador);

        assertTrue(meuTime.getTreinador().contains(novoTreinador));
    }
    @Test
    public void testRemoverTreinador() {
        Treinador treinadorRemover = new Treinador("Treinador Para Remover", 48, 1500000, "Espanha");
        meuTime.adicionarTreinador(treinadorRemover);

        assertTrue(meuTime.getTreinador().contains(treinadorRemover));

        meuTime.removerTreinador(treinadorRemover);

        assertFalse(meuTime.getTreinador().contains(treinadorRemover));
    }

}
