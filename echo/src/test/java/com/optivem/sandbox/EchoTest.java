package com.optivem.sandbox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EchoTest {

    private Echo echo;

    @BeforeEach
    void setup() {
        this.echo = new Echo();
    }

    @Test
    void should_echo() {
        var message = "Hello World!";

        var result = echo.echo(message);

        assertThat(result).isEqualTo(message);
    }
}
