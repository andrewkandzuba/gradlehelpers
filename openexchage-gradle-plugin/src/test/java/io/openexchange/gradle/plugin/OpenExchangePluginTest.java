package io.openexchange.gradle.plugin;

import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;

import static io.openexchange.gradle.plugin.OpenExchangePlugin.HELLO_DEPENDENCIES_TASK;
import static org.junit.Assert.assertNotNull;

public class OpenExchangePluginTest {

    @Test
    public void testHello() {
        Project project = ProjectBuilder.builder().build();
        project.getPlugins().apply(OpenExchangePlugin.class);

        Task task = project.getTasks().findByName(HELLO_DEPENDENCIES_TASK);
        assertNotNull(task);
    }
}
