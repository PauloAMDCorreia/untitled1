@desempenho
Feature: Desempenho de Carregamento da Página Inicial

  Scenario: Medir tempo de carregamento no desktop
    Given que o usuário está na página inicial da Amazon Brasil em um desktop
    When o usuário acessa a página inicial
    Then o tempo de carregamento deve ser menor que 3 segundos

  Scenario: Medir tempo de carregamento no mobile
    Given que o usuário está na página inicial da Amazon Brasil em um dispositivo móvel
    When o usuário acessa a página inicial
    Then o tempo de carregamento deve ser menor que 5 segundos

  Scenario Outline: Carregamento correto em diferentes navegadores
    Given que o usuário está na página inicial da Amazon Brasil usando <navegador>
    When o usuário acessa a página inicial
    Then a página deve carregar sem erros

    Examples:
      | navegador |
      | Chrome    |
      | Firefox   |
      | Safari    |

  Scenario: Elementos críticos carregam progressivamente
    Given que o usuário está na página inicial da Amazon Brasil
    When o usuário acessa a página inicial
    Then os elementos críticos da página devem aparecer primeiro durante o carregamento
