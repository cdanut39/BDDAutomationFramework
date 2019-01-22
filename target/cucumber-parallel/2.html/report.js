$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/workspace/BDD Automation Framework/src/main/java/features/Search.feature");
formatter.feature({
  "line": 1,
  "name": "Search functionality",
  "description": "",
  "id": "search-functionality",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Search a valid product",
  "description": "",
  "id": "search-functionality;search-a-valid-product",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Search"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user is logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user search for \"\u003cproduct\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "a page with \"\u003cresults\u003e\" is displayed",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "search-functionality;search-a-valid-product;",
  "rows": [
    {
      "cells": [
        "product",
        "results"
      ],
      "line": 10,
      "id": "search-functionality;search-a-valid-product;;1"
    },
    {
      "cells": [
        "telefon samsung",
        "Samsung"
      ],
      "line": 11,
      "id": "search-functionality;search-a-valid-product;;2"
    },
    {
      "cells": [
        "laptop dell",
        "Dell"
      ],
      "line": 12,
      "id": "search-functionality;search-a-valid-product;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "Search a valid product",
  "description": "",
  "id": "search-functionality;search-a-valid-product;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Search"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user is logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user search for \"telefon samsung\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "a page with \"Samsung\" is displayed",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "SearchStepDef.user_is_logged_in()"
});
formatter.result({
  "duration": 8090087989,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "telefon samsung",
      "offset": 17
    }
  ],
  "location": "SearchStepDef.user_search_for_product(String)"
});
formatter.result({
  "duration": 3799528803,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Samsung",
      "offset": 13
    }
  ],
  "location": "SearchStepDef.a_page_with_expected_product_is_displayed(String)"
});
formatter.result({
  "duration": 1669630699,
  "status": "passed"
});
formatter.after({
  "duration": 368976,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Search a valid product",
  "description": "",
  "id": "search-functionality;search-a-valid-product;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Search"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user is logged in",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user search for \"laptop dell\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "a page with \"Dell\" is displayed",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "SearchStepDef.user_is_logged_in()"
});
formatter.result({
  "duration": 9970358075,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "laptop dell",
      "offset": 17
    }
  ],
  "location": "SearchStepDef.user_search_for_product(String)"
});
formatter.result({
  "duration": 4428147208,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Dell",
      "offset": 13
    }
  ],
  "location": "SearchStepDef.a_page_with_expected_product_is_displayed(String)"
});
formatter.result({
  "duration": 1621517708,
  "status": "passed"
});
formatter.after({
  "duration": 286648,
  "status": "passed"
});
});