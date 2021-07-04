# Citrus App: Vaadin UI

Vaadin UI for Citrus App provides a front end to the application.

### Built with

* [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
* [Vaadin](https://vaadin.com/)
* [Maven](https://maven.apache.org/download.cgi)
* [Eclipse IDE 2021-06 4.20.0](https://www.eclipse.org/downloads/)

### Running the application
The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project. Read more on [how to set up a development environment for
Vaadin projects](https://vaadin.com/docs/latest/guide/install) (Windows, Linux, macOS).

## Deploying to Production
To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw  clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/myapp-1.0-SNAPSHOT.jar` (NOTE, replace 
`myapp-1.0-SNAPSHOT.jar` with the name of your jar).
