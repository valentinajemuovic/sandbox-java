package com.optivem.sandbox.infrastructure;

import com.optivem.sandbox.core.Height;
import com.optivem.sandbox.core.HeightGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HeightGatewayTest {
    private HeightPort heightPort;
    private HeightGateway heightGateway;

    @BeforeEach
    void setup() {
        this.heightPort = mock(HeightPort.class);
        this.heightGateway = new HeightGatewayImpl(heightPort);
    }

    @Test
    void should_return_height_for_existent_ssn() {
        var ssn = "247582352";
        when(heightPort.getHeightInches(ssn)).thenReturn(BigDecimal.valueOf(10));

        var height = heightGateway.getHeight(ssn);

        assertThat(height).isEqualByComparingTo(Height.ofCentimeters(25.4));
    }
}