package sk.stuba.fei.uim.oop.phone;
import sk.stuba.fei.uim.oop.application.Application;

import java.util.Set;

abstract class State {
    Phone phone;
    State(Phone phone) {
        this.phone = phone;
    }
    String getName() {
        return getClass().getSimpleName(); // mozete upravit podla potreby
    }
//    {
//        return getClass().getSimpleName().replace("State", getState(phone)); // mozete upravit podla potreby
//    }
    //locked , waiting for password,homescreen,running app
    abstract void powerButtonPressed();
    abstract void backButtonPressed();
    abstract void install(Application app);
    abstract void uninstall(Application app);
    abstract void start(Application app);
    abstract Application getRunningApp();
    abstract Set<Application> getInstalledApps();
    abstract void passwordEntered(String password);
    abstract State setPreviousState();
//    abstract String getState(Phone phone);

}






