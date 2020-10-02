package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class Shot extends CommandBase {
    private Shooter shoot;
    private double timer;

    public Shot(Shooter shot) {
        this.shoot = shot;
        this.timer = Timer.getFPGATimestamp();
        addRequirements(shot);
    }

    @Override
    public void execute() {
        shoot.shot();
    }

    @Override
    public boolean isFinished() {
        return (Timer.getFPGATimestamp() - timer >= 500);
    }

    @Override
    public void end(boolean interrupted) {
        shoot.stopShot();
    }

}

