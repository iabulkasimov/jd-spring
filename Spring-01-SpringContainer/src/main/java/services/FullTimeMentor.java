package services;

import interfaces.Mentor;

import javax.sound.midi.Soundbank;

public class FullTimeMentor implements Mentor {
    @Override
    public void createAccount() {
        System.out.println("the Full time mentor is created...");
    }
}
