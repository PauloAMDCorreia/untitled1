package test.java.main.gotasdeteconologia.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import test.java.main.gotasdeteconologia.logic.AmazonLogic;

@Slf4j
public class AmazonSteps {
    AmazonLogic sugestoesPesquisaLogic = new AmazonLogic();

    @Given("que o usuario esta na pagina inicial da Amazon Brasil")
    public void queOUsuarioEstaNaPaginaInicialDaAmazonBrasil() {
        sugestoesPesquisaLogic.acessaHome();
        log.info("Acessa a homepage da Amazon");
    }
    @When("o usuário digita {string} na barra de pesquisa")
    public void oUsuárioDigitaNaBarraDePesquisa(String termo) {
        sugestoesPesquisaLogic.digitarNaBarraDePesquisa(termo);
        log.info("Usuário digita LAPTOP na barra de pesquisas");
    }
    @Then("o sistema deve exibir sugestões relacionadas a {string}")
    public void oSistemaDeveExibirSugestõesRelacionadasA(String termo) {
        boolean sugestoesValidas = sugestoesPesquisaLogic.validarSugestoesRelacionadas(termo);
        if (!sugestoesValidas) {
            throw new AssertionError("As sugestões exibidas não são relacionadas ao termo: " + termo);
        }
        log.info("Sistema exibe sugestões relacionadas a busca ");
    }

    @Then("o sistema não deve exibir nenhuma sugestão")
    public void oSistemaNaoDeveExibirNenhumaSugestao() throws InterruptedException {
        sugestoesPesquisaLogic.oSistemaNaoDeveExibirNenhumaSugestao();
        log.info("Sistema não exibe sugestão para caracteres especiais");
    }

    @When("o usuario digitar {string} na barra de pesquisa")
    public void oUsuarioDigitarNaBarraDePesquisa(String arg0) throws InterruptedException {
        sugestoesPesquisaLogic.oUsuarioDigitarNaBarraDePesquisa();
        log.info("Usuario digita LAP na barra de pesquisa");
    }

    @And("continua digitando {string}")
    public void continuaDigitando(String arg0) throws InterruptedException {
        sugestoesPesquisaLogic.continuaDigitando();
        log.info("Continuando digitação TOP");
    }

    @And("clica em uma sugestão exibida")
    public void clicaEmUmaSugestaoExibida() {
        sugestoesPesquisaLogic.clicaEmUmaSugestaoExibida();
        log.info("Clicando em uma opção sugerida");
    }

    @Then("o usuário deve ser redirecionado para a página de resultados da pesquisa correspondente")
    public void oUsuarioDeveSerRedirecionadoParaAPaginaDeResultadosDaPesquisaCorrespondente() {
        sugestoesPesquisaLogic.oUsuarioDeveSerRedirecionadoParaAPaginaDeResultadosDaPesquisaCorrespondente();
        log.info("Usuário deve ser direcionado para página de resultados da pesquisa realizada");
    }

    @Then("o tempo de carregamento deve ser menor que {int} segundos")
    public void oTempoDeCarregamentoDeveSerMenorQueSegundos(int arg0) {
        sugestoesPesquisaLogic.oTempoDeCarregamentoDeveSerMenorQueSegundos();
        log.info("O tempo de carregamento dever ser menor que 3 segundos");
    }

    @Then("o tempo de resposta da busca deve ser menor que {int} segundos")
    public void oTempoDeRespostaDaBuscaDeveSerMenorQueSegundos(int arg0) {
        sugestoesPesquisaLogic.oTempoDeRespostaDaBuscaDeveSerMenorQueSegundos();
        log.info("Tempo de resposta da busca deve ser menor que 5 segundos");
    }

    @When("^realizo uma busca por \\\"([^\\\"]*)\\\"$")
    public void realizoUmaBuscaPor(String arg0) {
        sugestoesPesquisaLogic.realizoUmaBuscaPor(arg0);
        log.info("Busca por termo inválido");
    }

    @Then("o tempo de resposta da busca deve ser maior ou igual a {int} segundos")
    public void oTempoDeRespostaDaBuscaDeveSerMaiorOuIgualASegundos(int arg0) {
        sugestoesPesquisaLogic.oTempoDeRespostaDaBuscaDeveSerMaiorOuIgualASegundos(arg0);
    }

    @After
    public void tearDown() {
        sugestoesPesquisaLogic.fechaBrowser();
    }



}