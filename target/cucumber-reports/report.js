$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login",
  "description": "",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Login with valid credentials",
  "description": "",
  "id": "login;login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Login"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user is on eMAG page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user wants to access his account",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user enters his email",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user enters the password",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user clicks on Login button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "a new page with a welcome message is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.user_is_on_eMAG_page()"
});
formatter.result({
  "duration": 6305573375,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDef.user_wants_to_access_his_account()"
});
formatter.result({
  "duration": 4277077467,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDef.user_enters_his_credentials()"
});
formatter.result({
  "duration": 260485252,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDef.userEntersThePassword()"
});
formatter.result({
  "duration": 122077072,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDef.user_clicks_on_Login_button()"
});
formatter.result({
  "duration": 3160519114,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDef.a_new_page_with_a_welcome_message_is_displayed()"
});
formatter.result({
  "duration": 240800306,
  "status": "passed"
});
formatter.after({
  "duration": 482253,
  "status": "passed"
});
});