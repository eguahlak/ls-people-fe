package dk.cphbusiness.people.view;

import dk.cphbusiness.dummy.control.PeopleDummyManager;
import dk.cphbusiness.people.contract.PeopleManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Bridge {
  private static Bridge instance = null;
  private PeopleManager manager;
  
  private Bridge() {
    manager = lookupPeopleManagerBeanRemote();
    // manager = new PeopleDummyManager();
    }
  
  public static Bridge getInstance() {
    if (instance == null) instance = new Bridge();
    return instance;
    }

  public PeopleManager getManager() {
    return manager;
    }

  private PeopleManager lookupPeopleManagerBeanRemote() {
    try {
      Context c = new InitialContext();
      return (PeopleManager) c.lookup("java:global/PeopleBackend/PeopleManagerBean!dk.cphbusiness.people.contract.PeopleManager");
      }
    catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
      }
    }
  
  }
