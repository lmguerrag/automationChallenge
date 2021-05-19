Feature: Login Swaglabs

  As un usuario
  I want acceder a la tienda

  Background:
    Given que un usuario quiere ingresar a la tienda

  Scenario Outline: Login success
    When el usuario <type> ingresa usuario <username> y password <password>
    Then accede a la tienda

    Examples:
    |type       |username               |password    |
    |standard   |standard_user          |secret_sauce|
    |problem    |problem_user           |secret_sauce|
    |performance|performance_glitch_user|secret_sauce|

  Scenario: Locked user login
    When ingresa las credenciales siendo un usuario bloqueado
    Then se le negara el acceso a la tienda

  Scenario: Login fail
    When el usuario ingresa credenciales incorrectos
    Then no podra acceder a la tienda