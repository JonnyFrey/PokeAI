package com.waffel.pokeai.database.query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jonny on 7/3/2017.
 */
public interface Query<T> {

    String getQuery();

    void setParameters(final PreparedStatement statement) throws SQLException;

    T buildFromResultSet(final ResultSet resultSet);

}
