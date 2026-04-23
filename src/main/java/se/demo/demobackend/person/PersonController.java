package se.demo.demobackend.person;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddPersonResponse addPerson(@RequestBody AddPersonRequest request) {
        return new AddPersonResponse(request.name(), request.personalNumber());
    }
}
