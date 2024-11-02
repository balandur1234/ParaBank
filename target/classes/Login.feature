
@Smoke @Regression @Functional
Feature: Login function test

Background:
    Given Open browser
    And Go to Para Bank application


  @Positive @TC_BOL12
  Scenario: As a Para Bank user, login should success with valid credential
    
    When Put valid user
    And Put valid password
    And Click login button
    Then Login should pass and should logout button visible
    
  @Negative @TC_BOL13
  Scenario: As a Para Bank user, login should fail with invalid credential
    
    When Put invalid user
    And Put invalid password
    And Click login button
    Then Login should fail and an error msg contain An internal error has occurred and has been logged.

    @Negative @TC_BOL14
  Scenario: As a Para Bank user, login should fail with null credential
   
    When Put null user
    And Put null password
    And Click login button
    Then Login should fail and an error msg contain please enter username and password.
    
  
