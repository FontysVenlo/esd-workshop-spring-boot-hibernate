# How to use
There are many different ways to use Java Spring Boot which cannot all be explained in this document. However the most common way to use it is as a Backend for a Website. Spring Boot makes it really easy to setup a Backend for connecting frontend and backend.

For that it uses a layered Architecture internally, consisting of Controllers, Services, Repositories and Entities.

A controller contains the Endpoints of the Backend which are exposed to the outside world. For this example it is shown based on a REST (Representational State Transfer) API.


``` Java
package com.ESD.steamed.game;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAll(){
       return ResponseEntity.status(HttpStatus.CREATED).body(gameService.getAll());
    }
}


```

This Controller will listen to any HTTP requests coming in from outside with the specification ```/game```.
To give an example: ```localhost:8080/game```

This is done by this line:

```Java
@RequestMapping("/game") 
```

Within the controller the ```@GetMapping``` Defines a method ```getAll()```which will be executed if the incoming request to ```/game``` is a GET request.

To keep it simple we will ignore the rest of this code and move to the service that is now called with ```gameService.getAll()``` This Service has been injected into the Controller using the constructor. Under the hood Spring manages this dependency automatically.

----

References
[REFERENCE 1](www..nl)