Feature: Testing the Happy Flow for Clark

  Background: User is on the landing page 
    Given The landing page is 'https://www.clark.de/de/app/contracts?cv=2&utm_source=QA-engineers- interview.'
    
  Scenario: Verify correct contract is shown in a happy flow
    When I click on 'Angebote'
    Then 'Privathaftpflicht' is present on the landing page
    When I click on 'Privathaftpflicht'
    Then I land on the request quote page
    Then I request a quote
    Then I select the following options from the consecutive pages
    | Single | Ja | Nein | Nein |
    And I again request a quote
    Then I am on the offers page
    When I click on 'Jetzt abschlien'
    Then I land on login page
    When I login using the following credentials
    | hotmbvdpdggrrtrrr@grhapac.com | Hello624@123 |
    And  I fill in the following details and continue
    |First Name | Last Name | DOB         | road      | house no  | PLZ | place | phone     |
    | bruce	  |  wayne 	  | 02.08.1991  | some road | 01        | 60306 | germany | 015229320777   |
    Then I fill in the bank details 'DE55500105174529223988' and continue
    Then I verify the details on the verification page and click on Buy now
    Then I land on the order completed page
    When I click on 'Overview'
    Then I land on the manager page
    And I see my contract as expected
    
    