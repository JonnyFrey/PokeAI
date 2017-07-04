package com.waffel.pokeai.database;

import com.waffel.pokeai.database.query.Query;
import com.waffel.pokeai.exceptions.PokeAiRuntimeException;

import javax.inject.Inject;
import javax.inject.Named;
import java.nio.file.Path;
import java.sql.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.waffel.pokeai.GameConstants.POKEDEX_PATH;

/**
 * Created by Jonny on 7/3/2017.
 */
public class SqliteDao implements SqlDao {

    private final Path databaseFile;
    private final String jdbcUri;

    @Inject
    public SqliteDao(
            @Named(POKEDEX_PATH) final Path databaseFile
    ) {
        this.databaseFile = databaseFile;
        this.jdbcUri = "jdbc:sqlite:" + this.databaseFile;
    }


    @Override
    public <T> List<T> getObjectsBySearch(final Query<T> query) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new PokeAiRuntimeException("Failed to load sqlite driver", e);
        }
        try (final Connection connection = DriverManager.getConnection(this.jdbcUri)) {
            try (final PreparedStatement preparedStatement = connection.prepareStatement(query.getQuery())) {
                query.setParameters(preparedStatement);
                try (final Results results = new Results(preparedStatement.executeQuery())) {
                    return StreamSupport.stream(results.spliterator(), false)
                            .map(query::buildFromResultSet)
                            .filter(Objects::nonNull)
                            .collect(Collectors.toList());
                }
            }
        } catch (SQLException e) {
            throw new PokeAiRuntimeException("There was an issue with executing a sqlite query", e);
        }
    }
}
