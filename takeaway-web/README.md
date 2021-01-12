
# takeaway-web

**This is the Gradle subproject containing web automation framework and tests for Lieferando Website.**

This assignment is done using Java as programming language, Serenity as Junit wrapper and Selenium. BDD approach & Single-responsibility principle (SRP) is followed while creating the framework.


**Testing Scope** - Only given filter scenarios are automated. 

Requirements :
1.  Java 1.8+ should be installed on the machine.
2.  Gradle should be installed on the machine.

Steps :
1. Clone the repo using - git clone  [https://github.com/hbanafal/takeaway-assignment.git](https://github.com/hbanafal/takeaway-assignment.git)
2.  Go to the subproject directory - cd takeaway-assignment/takeaway-web
3.  Run tests using command - ./gradlew clean test 
4.  Generate Serenity Reports using - ./gradlew aggregate
5.  Open report from the path - takeaway-web/target/site/serenity/index.html
6.  Click on Test Results in the report and check the stories and steps involved in the test.

Configuration - /serenity.properties contains Selenium capabilities.

