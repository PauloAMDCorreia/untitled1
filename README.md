# Sugestões de Pesquisa (Autocomplete) - Amazon Brasil

Este repositório contém o código e os testes automatizados para a funcionalidade de **Sugestões de Pesquisa (Autocomplete)** na página inicial da Amazon Brasil. A funcionalidade foi desenvolvida e testada utilizando **Cucumber** e **Selenium WebDriver**, garantindo que os cenários de uso sejam validados em diferentes navegadores e dispositivos.

## 📋 Funcionalidades

A funcionalidade de Sugestões de Pesquisa (Autocomplete) inclui os seguintes cenários:

1. **Exibir sugestões ao digitar um termo válido**  
   - Quando o usuário digita um termo válido, como "laptop", na barra de pesquisa, o sistema exibe sugestões relacionadas ao termo.

2. **Não exibir sugestões para caracteres especiais aleatórios**  
   - Quando o usuário digita caracteres especiais, como "@#$%", o sistema não exibe nenhuma sugestão.

3. **Atualizar sugestões conforme o usuário digita mais caracteres**  
   - As sugestões são atualizadas dinamicamente à medida que o usuário digita mais caracteres, refletindo o termo completo.

4. **Sugestões são clicáveis e redirecionam para a página correta**  
   - Ao clicar em uma sugestão exibida, o usuário é redirecionado para a página de resultados da pesquisa correspondente.

5. **Verificar autocomplete em diferentes navegadores e dispositivos**  
   - A funcionalidade é validada em navegadores como Chrome, Firefox e Safari, tanto em dispositivos Desktop quanto Mobile.

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Cucumber**: Framework para escrita de cenários de teste em linguagem natural.
- **Selenium WebDriver**: Automação de testes para navegadores.
- **JUnit**: Framework para execução dos testes.
- **Maven**: Gerenciamento de dependências e build do projeto.

## 📂 Estrutura do Projeto
src
 |_main
 |_test
     |_java
        |_test.java
	     |_logic
	     |_runners 
	     |_steps
      |_resources
           |_CucumberFeatures
## 🚀 Como Executar o Projeto

### Pré-requisitos

- Java 11 ou superior instalado.
- Maven configurado no ambiente.
- Navegador Chrome e o driver correspondente (chromedriver) configurado no PATH.

### Passos

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/sugestoes-pesquisa.git
   cd sugestoes-pesquisa
   ```text

2. Instale as dependências do projeto:
   ```bash
   mvn clean install
   ```text

3. Execute os testes:
   ```bash
   mvn test
   ```text

4. Os resultados dos testes serão exibidos no console e um relatório detalhado será gerado.

## 📝 Cenários de Teste

### Exemplo de Cenário no Cucumber

```gherkin
Feature: Sugestões de Pesquisa (Autocomplete)

  @Test1
  Scenario: Exibir sugestões ao digitar um termo válido
    Given que o usuário está na página inicial da Amazon Brasil
    When o usuário digita "laptop" na barra de pesquisa
    Then o sistema deve exibir sugestões relacionadas a "laptop"
```text

### Cenários para Diferentes Navegadores e Dispositivos

```gherkin
Scenario Outline: Verificar autocomplete em diferentes navegadores e dispositivos
  Given que o usuário está na página inicial da Amazon Brasil usando <navegador> em <dispositivo>
  When o usuário digita "tablet" na barra de pesquisa
  Then o sistema deve exibir sugestões relacionadas a "tablet"

  Examples:
    | navegador | dispositivo |
    | Chrome    | Desktop     |
    | Firefox   | Desktop     |
    | Safari    | Desktop     |
    | Chrome    | Mobile      |
    | Firefox   | Mobile      |
```text

## 📖 Documentação do Código

### Classe `SugestoesPesquisaLogic`

Esta classe contém a lógica principal para interagir com a barra de pesquisa e validar as sugestões exibidas.

- **Método `acessaHome()`**  
  Navega até a página inicial da Amazon Brasil e aguarda a visibilidade da barra de pesquisa.

- **Método `digitarNaBarraDePesquisa(String termo)`**  
  Simula a digitação do termo na barra de pesquisa, caractere por caractere.

- **Método `validarSugestoesRelacionadas(String termo)`**  
  Valida se as sugestões exibidas contêm o termo digitado.

### Classe `AmazonSteps`

Define os passos do Cucumber para os cenários de teste.

## 🧪 Testes Automatizados

Os testes são escritos em Gherkin e executados com o runner do Cucumber. Certifique-se de que o driver do navegador está configurado corretamente antes de executar os testes.

## 🛡️ Contribuição

Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature ou correção:
   ```bash
   git checkout -b minha-feature
   ```text
3. Faça commit das suas alterações:
   ```bash
   git commit -m "Minha nova feature"
   ```text
4. Envie suas alterações:
   ```bash
   git push origin minha-feature
   ```text
5. Abra um Pull Request.

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---
Desenvolvido com 💻 e ☕ por [Seu Nome].
