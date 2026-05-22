package com.example;

public class MusicCenterCommand implements Command {
    private MusicCenter musicCenter;

    public MusicCenterCommand(MusicCenter musicCenter) {
        this.musicCenter = musicCenter;
    }

    @Override
    public void execute() {
        musicCenter.turnOn();
    }

    @Override
    public void undo() {
        musicCenter.turnOff();
    }
}
