package org.example.repositories;

import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.example.entity.BinSig;
import org.example.handlers.rowprocessors.AnaSigRowProcessor;
import org.example.handlers.rowprocessors.BinSigRowProcessor;

import java.util.Properties;

public class BSigRepository extends RepositoryBase<BinSig> {
    private static RowProcessor rowProcessor = new BinSigRowProcessor();
    public BSigRepository(String url, Properties dbProperties) {
        super(url, dbProperties,
                new BeanHandler<>(BinSig.class, rowProcessor),
                new BeanMapHandler<>(BinSig.class, rowProcessor),
                new BeanListHandler<>(BinSig.class, rowProcessor));
    }

    public BSigRepository(String url) {
        super(url,
                new BeanHandler<>(BinSig.class, rowProcessor),
                new BeanMapHandler<>(BinSig.class, rowProcessor),
                new BeanListHandler<>(BinSig.class, rowProcessor));
    }
}
