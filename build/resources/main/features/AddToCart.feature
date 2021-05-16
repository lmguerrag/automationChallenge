Feature: Add to cart
  As un cliente
  I want poder agregar productos al carrito de compras

  Scenario: Agregar productos al carrito
    Given un cliente quiere agregar productos que le gustan al carrito
    When agrega uno o mas productos
    Then podra ver los productos en el carrito de compras