package com.ihar.khdsk.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.testcontainers.containers.PostgreSQLContainer;

public class StartPostgresContainerPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        StartPostgresContainerExtension extension = project.getExtensions()
                .create("postgresContainer", StartPostgresContainerExtension.class);

        project.task("startPostgresContainer").doLast(it -> {
            PostgreSQLContainer<?> db = new PostgreSQLContainer<>(extension.getImage())
                    .withUsername(extension.getUser())
                    .withDatabaseName(extension.getName())
                    .withPassword(extension.getPassword());
            db.start();
            project.setProperty(extension.getJbdcUrlProperty(), db.getJdbcUrl());
        });
    }
}
