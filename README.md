# 🧪 Reqres API Test Framework

Automation framework for testing the [Reqres.in](https://reqres.in) API using **REST Assured**, **TestNG**, and **Java**.

---

## 🚀 Features

- 🧱 CRUD operations for users
- ✅ POJO-based request/response models
- ❗ Robust API error handling
- 🔧 Configurable setup via `config.properties`
- 📏 Clean structure using `BaseTest` and utility classes
- 📊 Assertion handler for clean and readable tests

---

## 🛠 Tech Stack

- Java 17
- Maven 3.8+
- REST Assured
- TestNG
- IntelliJ IDEA (recommended)

---
## 🚚 Installation

- Clone Repo using this command:
  ```bash
  git clone https://github.com/Hussien-Adel-Saad/RestAssured_Framework.git
  ```
---
## Dependencies
  ```
  <dependencies>
        <!-- Rest Assured -->
        <!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.5.1</version>
            <scope>test</scope>
        </dependency>
        <!-- JSON Parsing (e.g., Jackson) -->
        <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.18.3</version>
        </dependency>
        <!-- Test Framework (e.g., TestNG) -->
        <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.11.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
  ```
---
## 📦 Project Structure

```text
📦 RestAssured_Framework
├── 📁 .idea
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java
│   │   └── 📁 resources
│   └── 📁 test
│       ├── 📁 java
│       │   ├── 📁 models
│       │   │   ├── 📁 requests
│       │   │   │   └── CreateUserRequest.java
│       │   │   └── 📁 responses
│       │   │       ├── CreateUserResponse.java
│       │   │       ├── GetSingleUserResponse.java
│       │   │       └── UpdateUserResponse.java
│       │   ├── 📁 tests
│       │   │   ├── BaseTests.java
│       │   │   └── UserAPITests.java
│       │   └── 📁 utils
│       │       ├── APIAssertionsHandler.java
│       │       ├── ConfigLoader.java
│       │       └── RequestSpecificationBuilder.java
│       └── 📁 resources
│           └── config.properties
├── testng.xml
├── .gitignore
├── pom.xml
└── README.md

```
---
## ⚙️ Configuration

Edit the `config.properties` file located at:
src/test/resources/config.properties
---

## ➕ Adding New Tests

```
        Response response = RequestSpecificationBuilder.getDefaultRequestSpec()
                .pathParam("id", 2)
                .when()
                .get("/users/{id}");


        GetSingleUserResponse getSingleUserResponse = response.as(GetSingleUserResponse.class);

        assertStatusCode(response, 200);
        assertResponseTimeUnder(response, 2000);
        assertResponseFieldEquals("id",getSingleUserResponse.getData().getId(), "2");
        assertResponseFieldEquals("email",getSingleUserResponse.getData().getEmail(), "janet.weaver@reqres.in");
        assertResponseFieldEquals("first_name",getSingleUserResponse.getData().getFirst_name(), "Janet");

```
---
## 🙌 Author

**Hussien Adel**  
[🔗 LinkedIn](https://www.linkedin.com/in/hussien-adel-saad)  
📫 Email: [hussien.adel.1195@gmail.com](mailto:your@email.com)
---



