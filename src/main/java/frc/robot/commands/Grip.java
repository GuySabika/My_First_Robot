package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gripper;

public class Grip extends CommandBase {
    private Gripper gripper;

    public Grip(Gripper gripper) {
        this.gripper = gripper;
    }

    @Override
    public void execute() {
        gripper.grip();
    }

    @Override
    public boolean isFinished() {
        return gripper.ballInSide();
    }

    @Override
    public void end(boolean interrupted) {
        gripper.stopGriper();
    }

}
