package com.gsdd.docker.config.util;

import java.util.Optional;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DockerEnvLoader {

  public static String getDockerServiceIp() {
    String dockerHost = System.getenv("DOCKER_HOST");
    return Optional.ofNullable(dockerHost)
        .map(host -> host.substring(0, host.lastIndexOf(':')))
        .map(modifiedHost -> modifiedHost.substring(modifiedHost.lastIndexOf('/') + 1))
        .orElseGet(() -> "localhost");
  }
}
