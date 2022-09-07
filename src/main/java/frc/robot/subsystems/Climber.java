// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.sound.sampled.Port;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Ports;
import frc.robot.constants.Settings;

public class Climber extends SubsystemBase {
  Servo servoRight = new Servo(Ports.Climber.RCLIMB);
  Servo servoLeft = new Servo(Ports.Climber.LCLIMB);
  Servo ratchet = new Servo(Ports.Climber.RATCHET);
  double setRPM;
  double setPin;
  final WPI_TalonFX winch = new WPI_TalonFX(Ports.Climber.WINCH);
  /** Creates a new Climber. */
  public Climber() {
    winch.configFactoryDefault();
		winch.setInverted(false);
  }
  public void ratchetRelease() {
    double rAngle = Settings.Climber.RATCHET_ANGLE.get();
     ratchet.setAngle(rAngle);
  }
  public void servoRelease() {
    setPin = Settings.Climber.PIN_ANGLE.get();
    servoLeft.setAngle(setPin);
    servoRight.setAngle(setPin);
  }
  
  public void servoEngage() {
    setPin = Settings.Climber.PIN_ANGLE.get();
    servoRight.setAngle(0);
    servoLeft.setAngle(0);
  }

  public void armsUp() {
    setRPM = Settings.Climber.WINCH_POWER.get();
  }

  public void armsDown() {
    setRPM = -(Settings.Climber.WINCH_POWER.get());
  }
  
  public void ending() {
    setRPM = 0;
    ratchet.setAngle(0);
  }
  

  


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public static void climbServos() {
  }
}
