package com.optivem.sandbox.adapters;

import com.optivem.sandbox.application.HeightGateway;

import java.util.HashMap;

public class ThirdPartyHeightGateway implements HeightGateway {

    // TODO: This is for demo purposes only, it would not exist in the real implementation
    private final HashMap<String, Integer> heights = new HashMap<>() {{
        put("835839506", 20);
        put("247582352", 40);
        put("568496963", 60);
    }};

    @Override
    public int getHeight(String ssn) {
        // TODO: In the real implementation, we would make a here a call to some third party system (e.g. via REST API)
        //  to retrieve a height for some person via their SSN
        return heights.get(ssn);
    }
}
