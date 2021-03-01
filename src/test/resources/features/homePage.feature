
Feature: HomePage tests

  Background: Open Home Page
    Given User navigates to Hotels webpage

    @Banner
    Scenario: Top Page Banner
      Then User verifies Banner contains the following links:
        | Deals                   |
        | Things to do            |
        | Packages & Flights      |
        | Groups & Meetings       |
        | Gift Cards              |
        | List your property      |
        | Hotels.com® Credit Card |
