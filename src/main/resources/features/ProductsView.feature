Feature: Carga de productos

  As usuario
  I want visualizar los productos

  Scenario: Visualizacion de los productos
    Given un usuario quiere ver los productos
    When ingresa a la tienda
    Then se visualizan los productos correctamente
