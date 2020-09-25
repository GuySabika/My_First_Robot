package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

import java.util.function.Supplier;

public class TankDrive extends CommandBase {

    private Drivetrain drivetrain;
    private Supplier<Double> left;
    private Supplier<Double> right;

    public TankDrive(Drivetrain drivetrain, Supplier<Double> left, Supplier<Double> right) {
        this.drivetrain = drivetrain;
        this.left = left;
        this.right = right;
    }

    @Override
    public void execute() {
        drivetrain.tankDrive(left.get(),right.get());
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}
