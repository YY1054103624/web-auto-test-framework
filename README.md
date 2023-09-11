Web UI Automation Test Framework
================================

This framework is built with Java-Selenium-Selenium Grid-Selenoid-Extend Report.

Features
--------------
| Operator        | Description                                                                      |
|:----------------|:---------------------------------------------------------------------------------|
| Parallel        | Execute simultaneously.                                                          |
| Flexible        | Config which test cases you are going to execute by Excel.                       |
| Cross-browser   | Execute test cases on different browsers with different vertions.                |
| Video recording | Record videos during the running process of each test case.                      |
| Detailed report | Screenshots, browser logs, videos, authors, categories and so on...              |
| Run-time report | Combine Elasticsaerch with Kibana to realize real-time report.                   |
| Docker          | Deploy the test environment wherever you want easly.                             |
| Jenkins         | Combine pipeline with shell, groovy script to trigger test at any time you want. |

Precondition
---------------
Before you start using this framework, make sure you have installed these tools:
- Java
- Maven
- Docker

Getting Started
---------------
Pull the code down to your local environment.

Create a folder **/home/admin** in the computer where your docker is running.

Copy all the files under selenoid-config and elasticsearch-kibana-config into the folder you created before.

Start selenoid
---------------
Execute **docker compose** command.
```tcsh
docker compose -f selenoid.yaml run -d
```
Make sure selenoid is started by accessing **http://your-ip:8080**.

Start Elasticsearch and Kibana
---------------
Excecute **docker compose** command.
```tcsh
docker compose -f elasticsearch.yaml run -d
```
Make sure elasticsearch is started by accessing **http://your-ip:9200**.

Make sure kibana is started by accessing **http://your-ip:5601**

Config kibana
---------------
Open url **http://your-ip:5601**. 

Enter Index Pattern page, select 'suite' as index pattern.

Create a dashboard with a visualization, please refer to [Kibana doc](https://www.elastic.co/kibana/).

Modify config file
---------------
Open config.properties file under src/test/resources/config, change several values to fit your environment.
```text
runmode=selenoid
resulttoelk=yes
elasticurl=http://your-ip:9200/suite/_doc
selenoidremoteurl=http://localhost:4445/wd/hub
logurl=http://your-ip:4445/logs/
videourl=http://your-ip:4445/video/
```

Run test cases
--------------
Enter project web-auto-test-framework you pulled, run the maven command:
```text
mvn test
```
Then you can see the running process with Kibana web page and Selenoid web page.

Check the report
--------------
Normally the test report will opened automatically, but in case it isn't opened, you can find it under target/generated-reports.

What isn't covered here
--------------
- Create test cases
- Config test cases
- Config the number of threads
- Clear the test environment after testing
- Execute test cases on selenium-hub
- Log with Extend Reports
