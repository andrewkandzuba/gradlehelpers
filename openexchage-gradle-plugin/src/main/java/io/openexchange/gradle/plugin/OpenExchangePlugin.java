package io.openexchange.gradle.plugin;

import io.openexchange.gradle.plugin.tasks.GreetingTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * Common entry point to dependency management Gradle helper tasks.
 */
public class OpenExchangePlugin implements Plugin<Project> {

    public static final String HELLO_DEPENDENCIES_TASK = "dependenciesHello";

    /**
     * Heath check.
     *
     * @param project - reference to project.
     */
    @Override
    public void apply(Project project) {
        project.getTasks().create(HELLO_DEPENDENCIES_TASK, GreetingTask.class, task -> task.setMessage("Hello from OpenExchangePlugin"));
    }
}
