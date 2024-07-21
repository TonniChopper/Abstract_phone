package sk.stuba.fei.uim.oop.phone;
import sk.stuba.fei.uim.oop.application.Application;

import java.util.Set;

public class ApplicationRunning extends State{
    ApplicationRunning(Phone phone) {
        super(phone);
    }

    @Override
    public String getName() {
        return "ApplicationRunning";
    }
    @Override
    public void powerButtonPressed() {
        phone.setState(new Locked(phone));
    }
    @Override
    public void backButtonPressed() {
        if(phone.previousState == null) {
            phone.setState(new Homescreeen(phone));
        } else {
            if (phone.previousState.getName().equals("Homescreen")) {
                phone.setState(new Homescreeen(phone));
            } else {
                phone.setState(new Locked(phone));
            }
        }
    }

    @Override
    public void install(Application app) {
        if (phone.runningApplication.canInstallApplication()) {
            phone.getInstalledApplications().add(app);
        }
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
//    @Override
//    public String getName() {
//        return "ApplicationRunning";
//    }
    @Override
    public Set<Application> getInstalledApps() {
//        return phone.getInstalledApplications();
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
        return phone.previousState = new ApplicationRunning(phone);
    }
}
