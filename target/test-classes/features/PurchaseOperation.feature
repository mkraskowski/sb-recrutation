Feature: Purchasing book from bookstore

  Scenario: purchasing first of new arrivals book

    Given User choose book and proceeding purchase operation
    When Click on place order button
    Then Order details are correct