Feature: Login to BandLab

  Background: setups
    Given Initilize diver
    And Disable notifications
    And Maximize the browser
    And Initilize url
    And Set wait duration

  Scenario: login with valid credentials
    Given BandLab page is open
    When User clicks the login button
    And Login Page is open
    When User inserts valid credentials
    And clicks login
    Then home page should open
    Then User opens New Project
    And New Project should open
    Then User click play button
    And The music should play

#  Scenario Outline: login with valid credentials
#    Given BandLab page is open for "https://www.bandlab.com/"
#    When User clicks login button
#    And LogIn Page is opens
#    When User inserts valid <username> and <password>
#    And The User Clicks login
#    Then The Home page should open
#    Then The User Opens New Project
#    And The New Project should open
#    Then The User click play button
#    And Music should play

#    Examples: 
#      | username                 | password   |
#      | master_73_97@bk.ru       | admin12345 |
#      | muhammadjon690@gmail.com | admin12345 |
