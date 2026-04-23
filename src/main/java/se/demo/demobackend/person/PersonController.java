package se.demo.demobackend.person;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class PersonController {

    @PostMapping
    public DemoResponse demo(@RequestBody DemoRequest request) {
        return new DemoResponse(
                request.name(),
                request.personnelNumber() == null ? null : String.valueOf(request.personnelNumber()),
                "Request received successfully"
        );
    }
}
