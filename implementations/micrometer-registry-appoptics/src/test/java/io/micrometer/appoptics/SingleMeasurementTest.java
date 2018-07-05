/**
 * Copyright 2017 Pivotal Software, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.appoptics;

import io.micrometer.core.instrument.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SingleMeasurementTest {

    private final SingleMeasurement mockMeasurement = SingleMeasurement.newBuilder()
        .withName("Mock Single Measurement")
        .withValue(1d)
        .withTags(Arrays.asList(new Tag() {
            @Override
            public String getKey() {
                return "Mock Key";
            }

            @Override
            public String getValue() {
                return "Mock Value";
            }
        }))
        .build();

    private final String expectedJson = "{\"name\":\"MockSingleMeasurement\"," +
        "\"value\":1.0," +
        "\"tags\":{\"MockKey\":\"Mock Value\"}},";

    @Test
    public void testJson() {

        final StringBuilder sb = new StringBuilder();
        mockMeasurement.appendJson(sb);

        assertEquals(
            expectedJson,
            sb.toString()
        );
    }
}