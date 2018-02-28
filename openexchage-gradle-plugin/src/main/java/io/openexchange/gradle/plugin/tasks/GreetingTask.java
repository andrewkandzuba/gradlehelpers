package io.openexchange.gradle.plugin.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Gradle task that produces "greeting" messages into a project's build log.
 */
public class GreetingTask extends DefaultTask {
    private String message;

    /**
     * Returns message value
     *
     * @return - message's value.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message's value
     *
     * @param message - value to be set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Task's action
     */
    @TaskAction
    void sayGreeting() {
        System.out.printf("%s\n", getMessage());
    }
}
