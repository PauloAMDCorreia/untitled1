Feature: Menu de Navegação Responsivo

  Scenario: Exibir menu corretamente no desktop
    Given que o usuário está na página inicial da Amazon Brasil em um desktop
    Then o menu de navegação deve estar visível e funcional

  Scenario: Adaptar menu para tamanho de tablet
    Given que o usuário está na página inicial da Amazon Brasil em um tablet
    Then o menu deve ajustar seu layout para o formato tablet (ex: menu hamburger)

  Scenario: Adaptar menu para tamanho móvel
    Given que o usuário está na página inicial da Amazon Brasil em um dispositivo móvel
    Then o menu deve ser responsivo e utilizável

  Scenario: Itens do menu são clicáveis e redirecionam corretamente
    Given que o usuário está na página inicial da Amazon Brasil
    When o usuário clica em cada item do menu de navegação
    Then o sistema deve redirecionar para a página correta correspondente a cada item

  Scenario: Navegação no menu via teclado
    Given que o usuário está na página inicial da Amazon Brasil
    When o usuário navega pelo menu usando o teclado (tab e enter)
    Then os itens do menu devem receber foco e ativar corretamente

  Scenario: Menu responde corretamente em rede lenta
    Given que o usuário está na página inicial da Amazon Brasil com conexão lenta
    Then o menu deve carregar e responder sem erros
