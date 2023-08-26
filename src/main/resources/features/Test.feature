@TC-1233
Feature: feature

  Scenario: scenario

    Given user opens the homepage
    When  user clicks the "GİRİŞ Yap" button
    And   user into the field "username" enters the value "demomovita"
    And   user into the field "password" enters the value "1192movita"
    And   user clicks the "Giriş Yap" button
    Then  should be visible "Demo Filo (129)"
