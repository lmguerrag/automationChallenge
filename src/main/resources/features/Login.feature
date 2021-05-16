Feature: Login Swaglabs

  As un cliente
  I want acceder a la tienda

  Scenario: Login exitoso
    Given que un cliente quiere ingresar a la tienda
    When ingresa las credenciales correctas
    Then accede a la tienda exitosamente