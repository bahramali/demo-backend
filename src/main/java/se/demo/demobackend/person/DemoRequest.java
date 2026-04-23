package se.demo.demobackend.person;

import com.fasterxml.jackson.databind.JsonNode;

public record DemoRequest(String name, JsonNode personnelNumber) {
}
