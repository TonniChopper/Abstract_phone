package sk.stuba.fei.uim.oop.phone;
import sk.stuba.fei.uim.oop.application.Application;

import java.util.Set;

public class WaitingForPassword extends State{
    WaitingForPassword(Phone phone) {
        super(phone);
    }
    @Override
    public String getName() {
        return "WaitingForPassword";
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
        return;
    }
    @Override
    public void start(Application app) {
        if (phone.getInstalledApplications().contains(app) && app.startableFromLockedScreen()){
            phone.setState(new ApplicationRunning(phone));
            phone.runningApplication = app;
        }
    }
    @Override
    public Set<Application> getInstalledApps() {
        return phone.getInstalledApplications();
    }
    @Override
    public Application getRunningApp() {
        if(phone.getRunningApplication() != null) {
            return phone.getRunningApplication();
        }
        return null;
    }
    @Override
    public void passwordEntered(String password) {
        if (password.equals("123")) {
            phone.setState(new Homescreeen(phone));
        }else {
            phone.setState(new WaitingForPassword(phone));
        }
    }
    @Override
    public State setPreviousState() {
        return phone.previousState = new WaitingForPassword(phone);
    }
}
