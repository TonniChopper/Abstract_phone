package sk.stuba.fei.uim.oop.phone;
import sk.stuba.fei.uim.oop.application.Application;

import java.util.Set;

public class Homescreeen extends State{
    Homescreeen(Phone phone) {
        super(phone);
    }
    @Override
    public String getName() {
        return "Homescreen";
    }
    @Override
    public void powerButtonPressed() {
        phone.setState(new Locked(phone));
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
        if (phone.getInstalledApplications().contains(app)){
            phone.getInstalledApplications().remove(app);
        }
    }
    @Override
    public void start(Application app) {
        if (phone.getInstalledApplications().contains(app)){
            phone.setState(new ApplicationRunning(phone));
            phone.runningApplication = app;
        }
    }

    @Override
    public void passwordEntered(String password) {
        return;
    }
    @Override
    public Set<Application> getInstalledApps() {
//        return Set<Application>phone.getInstalledApplications();
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
        return phone.previousState = new Homescreeen(phone);
    }
}
