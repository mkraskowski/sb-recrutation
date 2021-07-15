$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("PurchaseOperation.feature");
formatter.feature({
  "line": 1,
  "name": "Purchasing book from bookstore",
  "description": "",
  "id": "purchasing-book-from-bookstore",
  "keyword": "Feature"
});
formatter.before({
  "duration": 15926478600,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "purchasing first of new arrivals book",
  "description": "",
  "id": "purchasing-book-from-bookstore;purchasing-first-of-new-arrivals-book",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User choose book and proceeding purchase operation",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Click on place order button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Order details are correct",
  "keyword": "Then "
});
formatter.match({
  "location": "TestSteps.stepsToBuyBook()"
});
formatter.result({
  "duration": 19159437100,
  "status": "passed"
});
formatter.match({
  "location": "TestSteps.stepToCreateOrder()"
});
formatter.result({
  "duration": 203460400,
  "status": "passed"
});
formatter.match({
  "location": "TestSteps.assertOrderDetailFields()"
});
formatter.result({
  "duration": 7302723600,
  "status": "passed"
});
formatter.after({
  "duration": 265787200,
  "status": "passed"
});
});