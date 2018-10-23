Feature:  User calls webFeature: GET request

  Scenario: User calls web services in order to get all pet types

    Given I have acces to perform GET request
    When I perform GET request to "/pettypes"
    Then I will have status code "200"


  Scenario: services in order to add a new pet type

      Given I have acces to perform POST resquest
      When I have acces to perform POST request to "/pettypes"
      Then I will have status code "201"

     Scenario: User calls web service in order to put pet type

       Given  I have acces to perform PUT request
       When I have acces to perfom PUT request to "/pettypes/{petTypeId}"
       Then I will have status code "204"

       Scenario: User calls web service in order to DELETE request

         Given I have acces to perfotm DELETE request
         When I have acces to perform DELETE reguest to"/pettypes"
         Then I will have status code "404"
