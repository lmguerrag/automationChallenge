Feature: Compra exitosa

  As un cliente
  I want comprar productos

  Scenario: comprar un producto
    Given un cliente quiere comprar productos
    And agrego productos al carrito
    When valide sus datos
    Then su compra fue completada