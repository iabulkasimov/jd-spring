package service;

import implementation.Mentor;

public class FullTimeMentor implements Mentor {

    @Override
    public void createAccount() {
        System.out.println("The Full Time Mentor Account is created....");
    }
}
