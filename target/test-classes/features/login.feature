Feature: Login to swaglabs 

  Scenario: login with valid credentials 
    Given Login page is open
    When User inserts valid credentials and clicks login
    Then User logs in and home page should open
   