Feature: Test MyApplication Page

   @SmokeTest
   Scenario: Sample Test Application
   Given Open Chrome Browser
   When User Navigates to url
   And User Searches In Google
   | EdSheeran | Test@153 |
   Then Simple Say Page Title is not Null
   
   @SanityTest
   Scenario: Demo Application
   Given Open Demo Browser
   When User moves to URL
   And Use clicks on Something
   Then Check Simple Message