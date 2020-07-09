package co.com.gsdd.docker.config.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

public class DockerEnvLoaderTest {

    @Test
    @EnabledIfEnvironmentVariable(named = "DOCKER_HOST", matches = "tcp://192.168.99.113:2376")
    public void testGetDockerServiceIp() {
        Assertions.assertEquals("192.168.99.113", DockerEnvLoader.getDockerServiceIp());
    }
}
