Feature: Login Swaglabs

  As un usuario
  I want acceder a la tienda

  Scenario Outline: Login
    Given que un usuario quiere ingresar a la tienda
    When el usuario <type> ingresa usuario <username> y password <password>
    Then accede a la tienda

    Examples:
    |type       |username               |password    |
    |standard   |standard_user          |secret_sauce|
    |locked     |locked_out_user        |secret_sauce|
    |problem    |problem_user           |secret_sauce|
    |performance|performance_glitch_user|secret_sauce|

