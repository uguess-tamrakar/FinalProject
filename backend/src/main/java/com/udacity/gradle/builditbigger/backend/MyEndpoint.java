package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.tamrakar.uguess.jokesources.JokesProvider;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that gets the joke from Jokes Provider */
    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke() {
        MyBean response = new MyBean();
        JokesProvider jokesProvider = new JokesProvider();
        response.setData(jokesProvider.tellJoke());

        return response;
    }

}
