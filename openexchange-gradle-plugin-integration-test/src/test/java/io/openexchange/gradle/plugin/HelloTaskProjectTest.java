package io.openexchange.gradle.plugin;

import io.openexchange.gradle.plugin.test.GradleProjectTest;
import org.junit.Test;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class HelloTaskProjectTest extends GradleProjectTest {

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"plugin-sample-project", "build.gradle"}
        };
    }

    @Test
    public void success() {
        assertNotNull(buildResult.getOutput());
        assertTrue(buildResult.getOutput().contains("Hello from OpenExchangePlugin"));
    }

    @Override
    protected String[] tasks() {
        return new String[]{OpenExchangePlugin.HELLO_DEPENDENCIES_TASK};
    }
}
