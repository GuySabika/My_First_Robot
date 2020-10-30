package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import frc.robot.subsystems.Feeder;

public interface RobotMap {
    public interface CAN {
        static final int LEFT = 0;
        static final int RIGHT = 1;
        static final int FEEDER = 2;
        static final int GRIPPER = 3;
        static final int SHOOTER1 = 4;
        static final int SHOOTER2 = 5;
    }

    public interface DIO {
        static final int NEGATIVE = 1;
        static final int POSITIVE = 2;
        static final int DIGITAL_INPUT = 3;
    }
}
