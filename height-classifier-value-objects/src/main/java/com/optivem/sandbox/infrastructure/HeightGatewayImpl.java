package com.optivem.sandbox.infrastructure;

import com.optivem.sandbox.core.Height;
import com.optivem.sandbox.core.HeightGateway;

import java.math.BigDecimal;
import java.math.MathContext;

public class HeightGatewayImpl implements HeightGateway {
    private static final BigDecimal CENTIMETERS_PER_INCH = BigDecimal.valueOf(2.54);

    private final HeightPort heightPort;

    public HeightGatewayImpl(HeightPort heightPort) {
        this.heightPort = heightPort;
    }

    @Override
    public Height getHeight(String ssn) {
        var heightInches = heightPort.getHeightInches(ssn);
        var heightCentimeters = heightInches.multiply(CENTIMETERS_PER_INCH, MathContext.DECIMAL64);
        return Height.ofCentimeters(heightCentimeters);
    }
}
