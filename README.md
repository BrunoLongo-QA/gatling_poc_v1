# Gatling Proof of Concept

![Project Version](https://img.shields.io/badge/Project%20Version-1.0.0-138c18?labelColor=gray&style=for-the-badge)

The idea of this project is to create a proof of concept for a Gatling simulation that can be used to test the performance of a web application. 
The simulation will be run using the Gatling tool, which is a powerful load testing tool for web applications.

<div style="text-align: center;">

[![LICENSE](https://img.shields.io/badge/License-MIT-blue)](LICENSE.md)

[![Maven](https://img.shields.io/badge/Maven-3.9.9-FF0000)](https://maven.apache.org/)
[![Gatling](https://img.shields.io/badge/Gatling-3.3.1-fd6b00)](https://gatling.io/) 
[![Scala](https://img.shields.io/badge/Scala-2.12.10-f5537f)](https://www.scala-lang.org/)
[![Java](https://img.shields.io/badge/Java-17.0.14-21b008)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![SDKMAN](https://img.shields.io/badge/SDKMAN-5.0.0-yellow)](https://sdkman.io/)

</div>

### 😁 "Gatling" Started 😁

First, you need to install [SDKMAN](https://sdkman.io/) to manage your Java and Scala versions. After that, you can install the required versions of Java and Scala using the following commands:

```bash
sdk install java 17.0.14-open
sdk install scala 2.12.10
sdk install maven 3.9.9
```

After that because of the Gatling version, you need to install the Gatling version 3.3.1 using the following command:

```bash
mvn archetype:generate 
```
After that you need to type Gatling in the terminal and follow the instructions to install the Gatling version 3.3.1.

### 🎽 Running the Simulation 🎽
First you need to fork the repository and clone it to your local machine. You can do this by clicking the "Fork" button in the top right corner of the page. 

This will create a copy of the repository in your own GitHub account.

Then you can clone the repository to your local machine using the following command changing the URL to your own repository:

```bash
git clone git@github.com:BrunoLongo-QA/gatling_poc_v1.git
```

To run the simulation, you need to navigate to the `src/test/scala` directory and run the following command:

```bash
mvn gatling:test
```

This will run the simulation and generate a report in the `target/gatling` directory.

This run all the scenarios in the `src/test/scala` directory.

### 📊 Project Versions 📊

* 1.0.1 - Adjust to upscale the tests on the User List so instead of 2 request (list and single) we start with 10 requests at the same time, them 25, them 50, them 100 and finally 200. ⚙️ **IN PROGRESS**
* 1.0.0 - Initial version of the project with the first simulation. ✅ **CURRENT VERSION**

## 🖊️ Contributors 🖊️
[![GitHub](https://img.shields.io/badge/GitHub-Bruno%20Longo%20QA-008000?labelColor=gray&style=for-the-badge&link=https://github.com/BrunoLongo-QA)](https://github.com/BrunoLongo-QA)
