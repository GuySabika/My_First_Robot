package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class Feeder implements Subsystem {

    private SpeedController speedController;
    static final int MAX_BALLS = 5;
    private int nowBalls;

    public Feeder(SpeedController speedController) {
        this.speedController = speedController;
        this.nowBalls = 0;
    }

    public void addBall(){
        nowBalls++;
    }

    public void lessBall(){
        nowBalls--;
    }

    public boolean checkMax(){
        return nowBalls<MAX_BALLS;
    }

    public void feed() {
        speedController.set(0.5);
    }

    public void stopFeed() {
        speedController.stopMotor();
    }
}