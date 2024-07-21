package sk.stuba.fei.uim.oop.phone;

import sk.stuba.fei.uim.oop.application.Application;

import java.util.HashSet;
import java.util.Set;

public class Phone {

    private State state = new Locked(this);
    protected State previousState = null;
    //predinstalovane appky su firefox,appstore,camera
    private Set<Application> installedApplications = new HashSet<>(Set.of(new Application("Firefox", false,false), new Application("AppStore",true ,false), new Application("Camera",false,true)));
    public Application runningApplication;

    public Phone() {
        this.state = new Locked(this);
        this.previousState = null;
    }

    protected void setState(State state) {
        this.state = state;
    }

    protected State getState() {
        if (state == null)
            return new Locked(this);
        return state;
    }
    public void powerButtonPressed() {
        state.powerButtonPressed();
    }

    public void backButtonPressed() {
        state.backButtonPressed();
//        if (state.getName().equals("ApplicationRunning")){
//            if(previousState.getName().equals("Homescreeen")) {
//                state = new Homescreeen(this);
//            } else {
//                state = new LockedState(this);
//            }
//        }
    }

    public void install(Application app) {
        state.install(app);
    }
    protected State getPreviousState() {
        return state.setPreviousState();
    }
    public void uninstall(Application app) {
        state.uninstall(app);
    }

    public void start(Application app) {
        state.start(app);
    }

    public void passwordEntered(String password) {
//       if (state.getName().equals("WaitingForPassword")) {
//           if (password.equals("123")) {
//               state = new Homescreeen(this);
//           } else {
//               state = new WaitingForPassword(this);
//           }
//       }
        state.passwordEntered(password);
    }

    public Set<Application> getInstalledApplications() {
        return installedApplications;
    }

    public Application getRunningApplication() {
        if(runningApplication != null) {
            return runningApplication;
        }
        return null;
    }

    public String getStateName() {
        return state.getName();
    }
}
