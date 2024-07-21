package sk.stuba.fei.uim.oop.phone;
import sk.stuba.fei.uim.oop.application.Application;

import java.util.Set;

public class Locked extends State{
    Locked(Phone phone) {
        super(phone);
    }
    @Override
    public String getName() {
        return "Locked";
    }
//    @Override
//    public String getState(phone) {
//        return "Locked";
//    }
    @Override
    public void powerButtonPressed() {
        phone.setState(new WaitingForPassword(phone));
    }
    @Override
    public void backButtonPressed() {
        return;
    }
    @Override
    public void install(Application app) {
        return;
    }
    @Override
    public void uninstall(Application app) {
        return;
    }
    @Override
    public void start(Application app) {
        return;
    }
    @Override
    public void passwordEntered(String password) {
        return;
    }

    @Override
    public Set<Application> getInstalledApps() {
        return null;
    }
    @Override
    public Application getRunningApp() {
        if(phone.getRunningApplication() != null) {
            return phone.getRunningApplication();
        }
        return null;
    }
    @Override
    public State setPreviousState() {
        return phone.previousState = new Locked(phone);
    }

}
