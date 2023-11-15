### Running the project

Install gradle and run the app using
```gradle bootRun```

### Usage

Send a GET request to localhost:8080/stats/players/{fullPlayerName}

Example:
 * localhost:8080/stats/players/Sgdaifiso Abdalla
 * localhost:8080/stats/players/inexistentPlayer

### Used technologies
Spring & spring boot (basic RESTful architecture with a controller, service & repository).
An in-memory hashmap with calculated data for each player constructed in the repository using a file stored in resources/static.

### Tiny TODOs
* Swagger-ui docs
* .env for the file in resources/static
* Optimise calculations

### NOTE
I did not round the values to 1 decimal place because of possible errors when rounding numbers:
what if your test case rounds numbers every single time a value is read and a new average is calculated, or at after all values are accumulated and divided before rounding?