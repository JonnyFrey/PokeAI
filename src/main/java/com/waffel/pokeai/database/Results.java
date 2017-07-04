package com.waffel.pokeai.database;

import com.waffel.pokeai.exceptions.PokeAiRuntimeException;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

/**
 * Created by Jonny on 7/3/2017.
 */
@Slf4j
public class Results implements Iterable<ResultSet>, AutoCloseable {

    private final ResultIterator resultIterator;

    public Results(final ResultSet resultSet) {
        this.resultIterator = new ResultIterator(resultSet);
    }

    @Override
    public Iterator<ResultSet> iterator() {
        return resultIterator;
    }

    @Override
    public void close() throws SQLException {
        this.resultIterator.close();
    }

    private class ResultIterator implements Iterator<ResultSet>, AutoCloseable {

        private final ResultSet resultSet;
        private boolean moved;
        private boolean hasNext;

        private ResultIterator(final ResultSet resultSet) {
            this.resultSet = resultSet;

        }

        @Override
        public void close() throws SQLException {
            this.resultSet.close();
        }

        @Override
        public boolean hasNext() {
            try {
                if (!moved) {
                    this.hasNext = this.resultSet.next();
                    moved = true;
                }
                return !this.resultSet.isClosed() && this.hasNext;
            } catch (SQLException e) {
                LOGGER.error("Error in checking if the result set has next", e);
                return false;
            }
        }

        @Override
        public ResultSet next() {
            if (!moved) {
                hasNext();
            }
            moved = false;
            return this.resultSet;
        }
    }

}
