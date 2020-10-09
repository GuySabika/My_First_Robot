package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    private SpeedController speedController;

    public Shooter(SpeedController speedController) {
        this.speedController = speedController;
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
