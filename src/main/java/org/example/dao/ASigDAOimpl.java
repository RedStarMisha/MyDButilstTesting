package org.example.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.example.entity.AnaSig;
import org.example.handlers.AnaSigRowProcessor;

import java.util.Properties;

public class ASigDAOimpl extends DAOabstr<AnaSig> {

    public ASigDAOimpl(String url, Properties dbProperties) {
        super(url, dbProperties,
                new BeanHandler<>(AnaSig.class, new AnaSigRowProcessor()),
                new BeanMapHandler<>(AnaSig.class, new AnaSigRowProcessor()),
                new BeanListHandler<>(AnaSig.class, new AnaSigRowProcessor()));
    }

    public ASigDAOimpl(String url) {
        super(url, new BeanHandler<>(AnaSig.class, new AnaSigRowProcessor()),
                new BeanMapHandler<>(AnaSig.class, new AnaSigRowProcessor()),
                new BeanListHandler<>(AnaSig.class, new AnaSigRowProcessor()));
    }
}
