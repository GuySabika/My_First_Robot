package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.commands.Feed;
import frc.robot.commands.Grip;
import frc.robot.commands.Shoot;
import frc.robot.commands.ShooterWithPID;
import frc.robot.subsystems.Shooter;

import java.util.function.Supplier;

public class OI/*GEVALD*/ {

    static Joystick left = new Joystick(0);
    static Joystick right = new Joystick(1);
    XboxController xboxController = new XboxController(2);

    public OI() {
        Button buttonGripper = new Button(xboxController::getXButton);
        buttonGripper.whenPressed(new Grip(Robot.gripper).andThen(new Feed(Robot.feed), new InstantCommand(Robot.feed::addBall,Robot.feed)));
        Button buttonFeeder = new Button(xboxController::getYButton);
        buttonFeeder.whenPressed(new Feed(Robot.feed).andThen(new ShooterWithPID(Robot.shoot, Shooter.KP,Shooter.KI,Shooter.KD,Shooter.TOLERANCE,Shooter.SETPOINT),new InstantCommand(Robot.feed::lessBall,Robot.feed)));
    }

    public static double getLeftX() {
        return left.getX();
    }

    public static double getRightX() {
        return right.getX();
    }

    public static double getLeftY() {
        return left.getY();
    }

    public static double getRightY() {
        return right.getY();
    }


}
