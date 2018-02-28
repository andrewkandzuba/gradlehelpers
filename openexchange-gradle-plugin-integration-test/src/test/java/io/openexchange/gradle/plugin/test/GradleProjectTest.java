package io.openexchange.gradle.plugin.test;

import org.apache.commons.io.FileUtils;
import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public abstract class GradleProjectTest {

    private final static String PATH_TO_LOCAL_MAVEN = "pathToLocalMaven";
    private final static String PROJECT_VERSION = "projectVersion";

    @Rule
    public final TemporaryFolder temporaryFolderDir = new TemporaryFolder();

    @Parameterized.Parameter
    public String projectName;

    @Parameterized.Parameter(1)
    public String buildScript;

    protected BuildResult buildResult;

    @Before
    public void setUp() throws Exception {
        assertTrue("Temporary directory has been created", temporaryFolderDir.getRoot().exists());

        String pathToLocalMaven = System.getProperty(PATH_TO_LOCAL_MAVEN);
        assertNotNull("Path to local maven must be set to $PATH_TO_LOCAL_MAVEN system property", pathToLocalMaven);
        assertTrue("Path to local maven exist", new File(pathToLocalMaven).exists());

        String projectVersion = System.getProperty(PROJECT_VERSION, "");

        URL projectUrl = this.getClass().getClassLoader().getResource(projectName);
        assertNotNull("Project should exist", projectUrl);

        File projectDir = new File(projectUrl.getFile());
        assertTrue("Project directory should exists", temporaryFolderDir.getRoot().exists());

        FileUtils.copyDirectory(projectDir, temporaryFolderDir.getRoot());

        buildResult = GradleRunner.create()
                .withProjectDir(temporaryFolderDir.getRoot())
                .withArguments(
                        String.join(" ", tasks()),
                        "--debug",
                        "--stacktrace",
                        "--build-file", buildScript,
                        "-PpathToLocalMaven=" + pathToLocalMaven,
                        "-PprojectVersion=" + projectVersion)
                .forwardOutput()
                .build();
    }

    /**
     * Returns specific tasks to be triggered
     *
     * @return - tasks.
     */
    protected abstract String[] tasks();
}
