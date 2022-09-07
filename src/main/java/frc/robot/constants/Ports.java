package frc.robot.constants;

import edu.wpi.first.wpilibj.Servo;

/** This file contains the different ports of motors, solenoids and sensors */
public interface Ports {

    public interface Gamepad {
        int DRIVER = 0;
        int OPERATOR = 1;
    }

    public interface Drivetrain {
        // Motors
        int LEFT_FRONT = 3;
        int LEFT_BACK = 2;

        int RIGHT_FRONT = 4;
        int RIGHT_BACK = 5;
    }

    public interface Shooter {
        // Motors
        int TOP = 15;
        int BOTTOM = 1;
    }

    public interface Intake{
        // Motors
        int INTAKE = 200;
        int UPPERINTAKE = 209;
        int SPINSPEED = 800;
    }


    public interface Climber{
        // Motors
        int WINCH = 201;
        int RATCHET = 1;
        int LCLIMB = 2;
        int RCLIMB = 3;
    }

    
}
