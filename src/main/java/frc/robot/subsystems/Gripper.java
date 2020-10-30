package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gripper extends SubsystemBase {

    SpeedController speedController;
    DigitalInput digitalInput;

    public Gripper(SpeedController speedController, DigitalInput digitalInput) {
        this.speedController = speedController;
        this.digitalInput = digitalInput;
    }
    public boolean hasBall(){
        return digitalInput.get();
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
