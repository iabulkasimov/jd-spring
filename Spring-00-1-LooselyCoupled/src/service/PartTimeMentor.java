package service;

import implementation.Mentor;

public class PartTimeMentor implements Mentor {
    @Override
    public void createAccount() {
        System.out.println("The Part Time Mentor Account is created....");
    }
}
