package io.openexchange.gradle.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * Common entry point to dependency management Gradle helper tasks.
 */
public class DependenciesManagementPlugin implements Plugin<Project> {

    private static final String HELLO_DEPENDENCIES_TASK = "dependenciesHello";

    /**
     * Heath check.
     *
     * @param project - reference to project.
     */
    @Override
    public void apply(Project project) {
        project.task(HELLO_DEPENDENCIES_TASK)
                .doLast(a -> System.out.println("Hello from " + this.getClass().getCanonicalName()));
    }
}
