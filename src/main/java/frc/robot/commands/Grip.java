package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gripper;

public class Grip extends CommandBase {

    private Gripper gripper;
    private double timer;

    public Grip(Gripper gripper) {
        this.gripper = gripper;
        this.timer = Timer.getFPGATimestamp();
        addRequirements(gripper);
    }

    @Override
    public void execute() {
        gripper.grip();
    }

    @Override
    public boolean isFinished() {
        return (Timer.getFPGATimestamp() - timer >= 0.5);
    }

    @Override
    public void end(boolean interrupted) {
        gripper.stopGriper();
    }

}
