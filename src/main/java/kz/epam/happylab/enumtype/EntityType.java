package kz.epam.happylab.enumtype;

import kz.epam.happylab.entity.*;

public enum EntityType {
    CUSTOMER{
        {
            this.entity = new Customer();
        }
    },
    ORDER{
        {
            this.entity = new Order();
        }
    },
    PROBE{
        {
            this.entity = new Probe();
        }
    },
    AES{
        {
            this.entity = new AES();
        }
    },
    SSA{
        {
            this.entity = new SSA();
        }
    },
    SANPIN{
        {
            this.entity = new Sanpin();
        }
    },
    EMPLOYEE{
        {
            this.entity = new Employee();
        }
    },
    ASSISTANT{
        {
            this.entity = new Assistant();
        }
    },
    POSITION{
        {
            this.entity = new Position();
        }
    },
    USER{
        {
            this.entity = new User();
        }
    },
    PROFILE{
        {
            this.entity = new User();
        }
    },
    USERTYPE{
        {
            this.entity = new Usertype();
        }
    };

    Entity entity;
    public Entity getEntity(){
        return entity;
    }
}
