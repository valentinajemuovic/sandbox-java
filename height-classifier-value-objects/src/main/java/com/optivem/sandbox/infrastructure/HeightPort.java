package com.optivem.sandbox.infrastructure;

import java.math.BigDecimal;

public interface HeightPort {
    BigDecimal getHeightInches(String ssn);
}
