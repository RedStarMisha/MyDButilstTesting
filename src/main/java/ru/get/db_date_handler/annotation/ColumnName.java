package ru.get.db_date_handler.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // область действия аннотации
@Target(ElementType.FIELD) //к какому уровню будет применяться аннотация:класс, поле, метод и т.д.
public @interface ColumnName {
    String key() default "";
}
