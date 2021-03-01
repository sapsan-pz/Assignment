@Packages&FlightsSearch
Feature: Packages & Flights Search Functionality

  Background: User navigates to Packages & Flights page
    Given User navigates to Packages & Flights page

  @Packages&Flights
  Scenario Outline: Package & Flights Tests
    And User selects "Flight + Hotel" option
    And User inputs "<origin>", "<destination>", "<departing date>", "<returning date>", "<number of Travelers>", and "<Airline Class>"
    And User clicks "Search" button
    #Then User sees a list of hotels within 2 miles distance from downtown
    And User applies filters for "<property class>", "<neighborhood>", and "<guest rating>"
    And User verifies the "<property class>", "<neighborhood>", "<guest rating>" filters have been applied appropriately

    Examples:
      | origin         | destination | departing date | returning date | number of Travelers | Airline Class   | property class | neighborhood | guest rating |
      | Miami FL       | Prague      | 05/21/2021     | 05/28/2021     | 1                   | Economy         | 5 stars        | Stare Mesto  | Exceptional  |
      | Los Angeles CA | Zurich      | 06/21/2021     | 06/28/2021     | 3                   | Business        | 4 stars        | Opfikon      | Very good    |
      | Chicago        | London      | 07/21/2021     | 07/21/2021     | 2                   | First class     | 3 stars        | Kensington   | Good         |
      | Seattle        | Oslo        | 08/21/2021     | 08/21/2021     | 4                   | Premium economy | 5 stars        | Asker        | Exceptional  |
      | Boston         | Paris       | 09/21/2021     | 09/21/2021     | 1                   | First class     | 4 stars        | Paris        | Very good    |