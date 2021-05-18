Feature: Eliminar productos del carro

  As un usuario
  I want Eliminar productos del carrito

  Scenario: Eliminar un producto del carrito
    Given un usuario quiere eliminar un producto agregado al carrito
    When elimine el producto del carrito
    Then el producto no se visualizara en el carrito