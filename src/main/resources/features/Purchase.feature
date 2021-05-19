Feature: Compra exitosa

  As un cliente
  I want comprar productos

  Background:
    Given un cliente quiere comprar productos

  Scenario: comprar un producto
    When agrego productos al carrito
    And valide sus datos
    Then su compra fue completada

  Scenario: compra de productos sin productos en el carro
    When no agrega productos al carro
    When valide sus datos sin productos en el carro
    Then su compra fue fallida
