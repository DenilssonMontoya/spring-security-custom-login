# Spring security with custom login

**Demo project to show how to implement a custom login page for spring security.**

## Prerequisites

- Java 17.

## Run Locally
**Execute following commands to build and run the project.**

```bash
# Run project 
./mvnw spring-boot:run
```


## Testing

Open a web browser and access the URL http://localhost:8080/home. Once this is completed you will be requested to log in.

**Step 1** Login is requested. As there is no existing user we need to create one, to do so lets click on Sign Up link.

![Test01.png](img%2FTest01.png)

**Step 2** Complete the information required to create a new user.

![Test02.png](img%2FTest02.png)

**Step 3** Once our user is created we will be redirected to the login page.

![Test03.png](img%2FTest03.png)

Finally, the application will show us the home page.

![Test04.png](img%2FTest04.png)