package com.ihar.khdsk.plugin;

import lombok.Data;

@Data
public class StartPostgresContainerExtension {
    private String image = "postgres:latest";
    private String user = "postgres";
    private String name = "postgres";
    private String password = "password";
    private String jbdcUrlProperty = "db.url";
}
