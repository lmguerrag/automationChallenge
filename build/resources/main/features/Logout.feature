Feature: Logout

  As un usuario
  I want cerrar sesion

  Scenario: Logout exitoso
    Given un usuario logeado quiere cerrar sesion
    When click en logout
    Then cerrara sesion