Feature: Comprar un producto

  As un cliente
  I want poder comprar productos en la tienda

  Scenario: Compra exitosa
    Given un cliente quiere comprar productos
    And agrego productos al carrito
    When quiera validar su compra
    And ingrese sus datos
    Then su compra es exitosa