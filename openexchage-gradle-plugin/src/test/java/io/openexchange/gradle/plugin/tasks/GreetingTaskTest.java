package io.openexchange.gradle.plugin.tasks;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class GreetingTaskTest {

    @Test
    public void checkSetterAndGetter() {
        final String message = "Hello";

        Project project = ProjectBuilder.builder().build();
        GreetingTask task = project.getTasks().create("greetings", GreetingTask.class);
        task.setMessage(message);
        assertEquals(message, task.getMessage());

        PrintStream old = System.out;
        OutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try {
            task.sayGreeting();
        } finally {
            System.setOut(old);
        }
        assertEquals(message + "\n", baos.toString());
    }
}
