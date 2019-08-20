# Technical Assessment

# How to Run

#### Framework Highlights/Tool/Libraries.
- Screenshot can be found in target directory once test finished 
- Cucucmber-Java
- Hamcrest-all
- Webdriver
- WebDriver Manager
- Cucumber 
- Page-object 
- Page-factory
- Ability to take screen shot
- Maven as build tool
- Cross browser 
- Test runs on default chrome browser, can override with mvn -D explained below how to.
- Scenarios are tag and can be run at tag level using IDE or command line (ex: -Dcucumber.options="--tags @tag")
#### via Intellj IDE
- A Cucumber runner class is defined in below package (src/test/java/com/kpmg/technical/assessment/RunCukesTest.java) 
- Run configuration can also be set to override in vm options -ea -Durl={browser_url} -Dbrowser={browser_choice}

#### via Command Line to override -Dbrowser & -Durl
```sh
mvn clean -Durl={browser_url} -Dbrowser={browser_choice}
```

