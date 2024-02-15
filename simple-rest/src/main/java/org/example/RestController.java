package org.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Getter
    @Setter
    public static class RestResponse {
        private String param1;
        private String param2;
    }

    @RequestMapping(value = "/hello",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse restMethod(String name) {
        RestResponse restResponse = new RestResponse();
        restResponse.setParam1("Hello");
        restResponse.setParam2(name);
        return restResponse;
    }

//    @GetMapping(value = "/hello/{name}",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public RestResponse restMethodIvan(@PathVariable String name) {
//        RestResponse restResponse = new RestResponse();
//        restResponse.setParam1("Hello");
//        restResponse.setParam2(name);
//        return restResponse;
//    }
}