package kz.epam.happylab.action;

import kz.epam.happylab.enumtype.ActionType;
import org.apache.log4j.Logger;

import static kz.epam.happylab.constant.ExceptionMessage.EXCEPTION_WRONG_ACTION;

public abstract class ActionFactory {
    private final static Logger logger = Logger.getLogger(ActionFactory.class);

    public static Action createAction(String parameter){
        Action action = new ShowAction();

        if(parameter == null || parameter.isEmpty()){
            return action;
        }

        try {
            ActionType actionType = ActionType.valueOf(parameter.toUpperCase());
            action = actionType.getCurrentAction();
        } catch (IllegalArgumentException e) {
            logger.error(EXCEPTION_WRONG_ACTION, e);
        }

        return action;
    }
}
