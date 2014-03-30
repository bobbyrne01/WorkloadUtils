WorkloadUtils
=============

Web app that provides common workload utilities


## HTTP API available to clients

### RandomNumber

* `GET http://localhost:8080/WorkloadUtils/RandomNumber`
* Example response
 * -2114550233

### RandomWord

* `GET http://localhost:8080/WorkloadUtils/RandomWord`
* Example response
 * Socrates's

### RandomWord (specifying numberOfWords)

* `GET http://localhost:8080/WorkloadUtils/RandomWord?numberOfWords=10`
* Example response
 * clammy gallivanted jabbed Kirsten's monotheist's rectors quirks accredit concentrically moisturizing 

### GenerateEmailAddresses

* `GET http://localhost:8080/WorkloadUtils/GenerateEmailAddresses?numOfAddresses=5&localPart=awesome&domain=computer.com`
* Example response<br/>
awesome1@computer.com<br/>
awesome2@computer.com<br/>
awesome3@computer.com<br/>
awesome4@computer.com<br/>
awesome5@computer.com


## Building

Project uses [Apache Ant](http://ant.apache.org/) for compilation and packaging.
Open a terminal ..

* `git clone https://github.com/bobbyrne01/WorkloadUtils.git`
* `cd WorkloadUtils`
* Inside build.xml, change `war destfile=` value to your prefered location e.g `/home/user/tomcat/webapps/`
* `ant -Darg0=war`
