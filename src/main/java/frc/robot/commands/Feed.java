package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class Feed extends CommandBase {
    private Feeder feed;
    private double timer;

    public Feed(Feeder feed) {
        this.feed = feed;
        this.timer = Timer.getFPGATimestamp();
        addRequirements(feed);
    }

    @Override
    public void execute() {
        feed.feed();
    }

    @Override
    public boolean isFinished() {
        return (Timer.getFPGATimestamp()-timer >= 500);
    }

    @Override
    public void end(boolean interrupted) {
        feed.stopFeed();
    }

}
