package io.heapy.komodo.r2dbc

import java.sql.DriverManager




fun main(args: Array<String>) {
    DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/bkug",
        "user",
        "password"
    ).use { connection ->
        connection
            .createStatement()
            .use { stmt -> stmt.executeUpdate("INSERT INTO Meetup(name) VALUES ('BKUG #11') ") }
    }
}
