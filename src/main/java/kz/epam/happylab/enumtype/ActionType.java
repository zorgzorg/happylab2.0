package kz.epam.happylab.enumtype;

import kz.epam.happylab.action.*;

public enum ActionType {
    ADD {
           {
                this.action =  new AddAction();
        }
    },
    EDIT{
            {
                this.action =   new EditAction();
        }
    },
    APPLY {
            {
                this.action =   new ApplyAction();
        }
    },
    SAVE{
            {
                this.action =   new SaveAction();
        }
    },
    SAVE_ASSISTANT{
            {
                this.action =   new SaveAssistantAction();
        }
    },
    SAVE_SIGNATURE{
            {
                this.action =   new SaveSignatureAction();
        }
    },
    DELETE {
            {
                this.action =   new DeleteAction();
        }
    },
    REPORT{
            {
                this.action =   new ReportAction();
        }
    },
    BLOCK{
            {
                this.action =   new BlockAction();
        }
    },
    LOGIN{
            {
                this.action =   new LoginAction();
        }
    },
    LOGOUT{
            {
                this.action =   new LogoutAction();
        }
    },
    EMPTY{
            {
                this.action =   new ShowAction();
        }
    };

    Action action;

    public Action getCurrentAction(){
       return action;
    }
}
