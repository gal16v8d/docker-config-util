package com.gsdd.docker.config.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class DockerEnvLoaderTest {

    @Test
    @EnabledIfEnvironmentVariable(named = "DOCKER_HOST", matches = "tcp://192.168.99.113:2376")
    void testGetDockerServiceIp() {
        Assertions.assertEquals("192.168.99.113", DockerEnvLoader.getDockerServiceIp());
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testDockerServiceIpOs() {
        Assertions.assertEquals("localhost", DockerEnvLoader.getDockerServiceIp());
    }
}
