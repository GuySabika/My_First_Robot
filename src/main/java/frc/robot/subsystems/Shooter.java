package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    private SpeedController speedController;
    private Encoder encoder;

    public Shooter(SpeedController speedController ,Encoder encoder) {
        this.speedController = speedController;
        this.encoder = encoder;
        encoder.setDistancePerPulse(4096.0/360.0);
    }
    public void reset(){
         this.encoder.reset();
    }

    public double getDistance(){
        return encoder.getDistance();
    }

    public void  shot(){
        speedController.set(0.6);
    }

    public void stopShot(){
        speedController.stopMotor();
    }

    public void speedShoot(Double speed){
        speedController.set(speed);
    }
}
