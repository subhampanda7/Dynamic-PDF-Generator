
# Dynamic PDF Generator

Dynamic PDF Generator is a Java application that allows users to generate PDF documents on-the-fly. It is designed to simplify the process of generating PDFs. With Dynamic PDF Generator, users can create custom PDFs that include a wide range of details and more.

The application is built on top of the Java programming language, making it highly portable and easy to use. It helps create invoices, reports, or other types of documents, Dynamic PDF Generator can help streamline workflow and produce professional-looking PDFs with ease.

# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8080

    spring.datasource.url=jdbc:mysql://localhost:3306/databasename;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

# API Root Endpoint
```
https://localhost:8088/pdf
```


### Thank You
