package com.udacity.gradle.builditbigger.backend;

import com.example.yousef.jokeprovider.JokeGenerator;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v2",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName =   "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        JokeGenerator jokeGenerator = new JokeGenerator();
        String joke = jokeGenerator.getJoke();

        MyBean response = new MyBean();
        response.setJoke(joke);

        return response;
    }

}
