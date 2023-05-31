package ru.get.db_date_handler.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для работы со значениями полей по умолчанию при маппинге из базы данных
 * Вешается над полем, значение по умолчанию которого нам нужно сохранить. Само значение поля указывается в самом поле.
 * Имеет возможность задать аттрибут DefaultType который укажет в каих случаях надо заполнять поле из БД:
 * - DefaultType.ALWAYS (по умолчанию) - сохранять default значение всегда
 * - DefaultType.IFNULL - сохранять default значение если значение в БД null
 */
@Retention(RetentionPolicy.RUNTIME) // область действия аннотации
@Target(ElementType.FIELD) //к какому уровню будет применяться аннотация:класс, поле, метод и т.д.
public @interface Default {
//    public String key() default "";
    DefaultType key() default DefaultType.NONE;
}
