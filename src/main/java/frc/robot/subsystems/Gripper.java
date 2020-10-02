package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gripper extends SubsystemBase {

    SpeedController speedController;

    public Gripper(DigitalInput digitalInput, SpeedController speedController) {
        this.speedController = speedController;
    }

    public void grip() {
        speedController.set(1);
    }

    public void release() {
        speedController.set(-1);
    }

    public void stopGriper() {
        speedController.stopMotor();
    }


}
