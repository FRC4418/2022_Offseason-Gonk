// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.sound.sampled.Port;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Ports;

public class Climber extends SubsystemBase {
  Servo servoRight = new Servo(Ports.Climber.RCLIMB);
  Servo servoLeft = new Servo(Ports.Climber.LCLIMB);
  Servo ratchet = new Servo(Ports.Climber.RATCHET);
  final WPI_TalonFX winch = new WPI_TalonFX(Ports.Climber.WINCH);
  /** Creates a new Climber. */
  public Climber() {
    winch.configFactoryDefault();
		winch.setInverted(false);
    
  }
  public void servoRelease() {
    servoLeft.setAngle((double) 40);
    servoRight.setAngle((double) 40);
  }
  
  public void servoEngage() {
    servoRight.setAngle(0);
    servoLeft.setAngle(0);
  }
  

  


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public static void climbServos() {
  }
}
