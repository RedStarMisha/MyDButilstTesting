package org.example.repositories;

import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.example.entity.AnaSig;
import org.example.handlers.rowprocessors.AnaSigRowProcessor;

import java.util.Properties;

public class ASigRepository extends RepositoryBase<AnaSig> {
    private static RowProcessor rowProcessor = new AnaSigRowProcessor();

    public ASigRepository(String url, Properties dbProperties) {
        super(url, dbProperties,
                new BeanHandler<>(AnaSig.class, rowProcessor),
                new BeanMapHandler<>(AnaSig.class, rowProcessor),
                new BeanListHandler<>(AnaSig.class, rowProcessor));
    }

    public ASigRepository(String url) {
        super(url, new BeanHandler<>(AnaSig.class, rowProcessor),
                new BeanMapHandler<>(AnaSig.class, rowProcessor),
                new BeanListHandler<>(AnaSig.class, rowProcessor));
    }
}
