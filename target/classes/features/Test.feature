@TC-1233
Feature: feature

  Scenario: scenario

    Given user opens the homepage
    When  user into the field "Username" enters the value "Admin"
    And   user into the field "Password" enters the value "admin123"
    And   user clicks the "Login" button
    And   user clicks the "Admin" button
    And   user into the field "Username" enters the value "Admin"
    And   user clicks the "Search" button
    And   user clicks with locator type "xpath" and locator value "//li[.//*[contains(.,'Job')]]"

  Scenario: Menu

    Given user opens the homepage
    And User Clicks Menu "Kurumsal" , "Hakkımızda"