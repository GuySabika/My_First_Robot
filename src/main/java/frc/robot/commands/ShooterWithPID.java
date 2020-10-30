package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

import java.util.function.Supplier;

public class ShooterWithPID extends CommandBase {

    private Shooter shooter;
    private Supplier<Double> kp;
    private Supplier<Double> ki;
    private Supplier<Double> kd;
    private Supplier<Double> tolerance;
    private Supplier<Double> setpoint;
    private PIDController pidController;

    public ShooterWithPID(Shooter shooter, Supplier<Double> kp, Supplier<Double> ki, Supplier<Double> kd,
                          Supplier<Double> tolerance, Supplier<Double> setpoint) {
        this.shooter = shooter;
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
        this.tolerance = tolerance;
        this.setpoint = setpoint;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.reset();
        pidController = new PIDController(kp.get(),ki.get(), kd.get());
    }

    @Override
    public void execute() {
        pidController.setPID(kp.get(),ki.get(), kd.get());
        pidController.setTolerance(tolerance.get());
        shooter.speedShoot(pidController.calculate(shooter.getDistance(),setpoint.get()));           /*need encoder and max balls*/
    }

    @Override
    public void end(boolean interrupted) {
        shooter.shot();
    }
}
