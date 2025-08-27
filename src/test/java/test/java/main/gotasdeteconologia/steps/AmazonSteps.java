package test.java.main.gotasdeteconologia.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.java.main.gotasdeteconologia.Logic.SugestoesPesquisaLogic;

public class AmazonSteps {
    SugestoesPesquisaLogic sugestoesPesquisaLogic = new SugestoesPesquisaLogic();

    @Given("que o usuario esta na pagina inicial da Amazon Brasil")
    public void queOUsuarioEstaNaPaginaInicialDaAmazonBrasil() {
        sugestoesPesquisaLogic.acessaHome();
    }
    @When("o usuário digita {string} na barra de pesquisa")
    public void oUsuárioDigitaNaBarraDePesquisa(String termo) {
        sugestoesPesquisaLogic.digitarNaBarraDePesquisa(termo);
    }
    @Then("o sistema deve exibir sugestões relacionadas a {string}")
    public void oSistemaDeveExibirSugestõesRelacionadasA(String termo) {
        // Chama o metodo que valida se as sugestões exibidas são relacionadas ao termo
        boolean sugestoesValidas = sugestoesPesquisaLogic.validarSugestoesRelacionadas(termo);
        if (!sugestoesValidas) {
            throw new AssertionError("As sugestões exibidas não são relacionadas ao termo: " + termo);
        }
    }

    @Then("o sistema não deve exibir nenhuma sugestão")
    public void oSistemaNaoDeveExibirNenhumaSugestao() throws InterruptedException {
        sugestoesPesquisaLogic.oSistemaNaoDeveExibirNenhumaSugestao();
    }

    @When("o usuario digitar {string} na barra de pesquisa")
    public void oUsuarioDigitarNaBarraDePesquisa(String arg0) throws InterruptedException {
        sugestoesPesquisaLogic.oUsuarioDigitarNaBarraDePesquisa();
    }

    @And("continua digitando {string}")
    public void continuaDigitando(String arg0) throws InterruptedException {
        sugestoesPesquisaLogic.continuaDigitando();
    }

    @And("clica em uma sugestão exibida")
    public void clicaEmUmaSugestaoExibida() {
        sugestoesPesquisaLogic.clicaEmUmaSugestaoExibida();
    }

    @Then("o usuário deve ser redirecionado para a página de resultados da pesquisa correspondente")
    public void oUsuarioDeveSerRedirecionadoParaAPaginaDeResultadosDaPesquisaCorrespondente() {
        sugestoesPesquisaLogic.oUsuarioDeveSerRedirecionadoParaAPaginaDeResultadosDaPesquisaCorrespondente();
    }
}