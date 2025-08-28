@pesquisa
Feature: Sugestões de Pesquisa (Autocomplete)
  @Test1
  Scenario: Exibir sugestões ao digitar um termo válido
    Given que o usuario esta na pagina inicial da Amazon Brasil
    When o usuário digita "laptop" na barra de pesquisa
    Then o sistema deve exibir sugestões relacionadas a "laptop"

  @Test2
  Scenario: Não exibir sugestões para caracteres especiais aleatórios
    Given que o usuario esta na pagina inicial da Amazon Brasil
    When o usuário digita "@#$%" na barra de pesquisa
    Then o sistema não deve exibir nenhuma sugestão

  @Test3
  Scenario: Atualizar sugestões conforme o usuário digita mais caracteres
    Given que o usuario esta na pagina inicial da Amazon Brasil
    When o usuario digitar "lap" na barra de pesquisa
    And continua digitando "top"
    Then o sistema deve exibir sugestões relacionadas a "laptop"

  @Test4
  Scenario: Sugestões são clicáveis e redirecionam para a página correta
    Given que o usuario esta na pagina inicial da Amazon Brasil
    When o usuário digita "phone" na barra de pesquisa
    And clica em uma sugestão exibida
    Then o usuário deve ser redirecionado para a página de resultados da pesquisa correspondente

  @Test5
  Scenario: Medir tempo de carregamento no desktop
    Given que o usuario esta na pagina inicial da Amazon Brasil
    Then o tempo de carregamento deve ser menor que 3 segundos

  @Test6
  Scenario: Validar tempo de resposta da busca por "laptop"
    Given que o usuario esta na pagina inicial da Amazon Brasil
    When o usuário digita "laptop" na barra de pesquisa
    Then o tempo de resposta da busca deve ser menor que 5 segundos

  @Test7
  Scenario: Busca por termo inválido demora mais que 5 segundos para responder
    Given que o usuario esta na pagina inicial da Amazon Brasil
    When realizo uma busca por "termoInvalido123"
    Then o tempo de resposta da busca deve ser maior ou igual a 5 segundos

  @Test8
  Scenario: Falha na busca por "livros" com tempo de resposta menor que 5 segundos
    Given que o usuario esta na pagina inicial da Amazon Brasil
    When realizo uma busca por "livros"
    Then o tempo de resposta da busca deve ser maior ou igual a 3 segundos

  @Test9
  Scenario: Sugestão de busca no caso de erro de digitação
    Given que o usuario esta na pagina inicial da Amazon Brasil
    When realizo uma busca por "lattop"
    Then o sistema deve exibir sugestões relacionadas a "laptop"

#  Scenario Outline: Verificar autocomplete em diferentes navegadores e dispositivos
#    Given que o usuário está na página inicial da Amazon Brasil usando <navegador> em <dispositivo>
#    When o usuário digita "tablet" na barra de pesquisa
#    Then o sistema deve exibir sugestões relacionadas a "tablet"
#
#    Examples:
#      | navegador | dispositivo |
#      | Chrome    | Desktop     |
#      | Firefox   | Desktop     |
#      | Safari    | Desktop     |
#      | Chrome    | Mobile      |
#      | Firefox   | Mobile      |