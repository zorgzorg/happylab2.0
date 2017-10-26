package kz.epam.happylab.entity;

import kz.epam.happylab.action.ActionFactory;
import kz.epam.happylab.enumtype.EntityType;
import org.apache.log4j.Logger;

import static kz.epam.happylab.constant.ExceptionMessage.EXCEPTION_WRONG_OPTION;

public class EntityFactory {
    private final static Logger logger = Logger.getLogger(ActionFactory.class);

    public static Entity createEntity(String option){
        Entity entity = new Entity();

        if(option == null || option.isEmpty()){
            return entity;
        }

        try {
            EntityType entityType = EntityType.valueOf(option.toUpperCase());
            entity = entityType.getEntity();
        } catch (IllegalArgumentException e) {
            logger.error(EXCEPTION_WRONG_OPTION, e);
        }

        return entity;
    }
}
