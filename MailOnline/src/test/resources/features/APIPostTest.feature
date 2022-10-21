Feature: Verify rest assured apis

    Scenario Outline: rst_verify status and response of post request
      Given launch "<api>"
      Then verify post api status code as "<stcode>"
      Then Get the pet and verify statuscode "<stcode>" 
    
      Examples:
      |api|stcode|
      |https://petstore.swagger.io/v2/pet/|200|