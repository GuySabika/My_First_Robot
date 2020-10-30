package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;

public class Shooter extends SubsystemBase {
    public static final Supplier<Double> KP = ()->(0.5);
    public static final Supplier<Double> KI = ()->(0.005);
    public static final Supplier<Double> KD = ()->(0.05);
    public static final Supplier<Double> TOLERANCE = ()->(10.0);
    public static final Supplier<Double> SETPOINT = ()->(720.0);
    private SpeedController speedController;
    private Encoder encoder;

    public Shooter(SpeedController speedController ,Encoder encoder) {
        this.speedController = speedController;
        this.encoder = encoder;
        encoder.setDistancePerPulse(4096.0/360.0);
    }
    public void reset(){
         this.encoder.reset();
    }

    public double getDistance(){
        return encoder.getDistance();
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
