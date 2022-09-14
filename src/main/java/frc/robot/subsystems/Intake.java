// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Ports;
import frc.robot.constants.Settings;

public class Intake extends SubsystemBase {
final static WPI_TalonFX moveIntake = new WPI_TalonFX(Ports.Intake.INTAKE);
final static WPI_TalonSRX spinRollers = new WPI_TalonSRX(Ports.Intake.SPIN_SPEED);
final static WPI_TalonSRX upIntake = new WPI_TalonSRX(Ports.Intake.UPPER_INTAKE);

  /** Creates a new Intake. */
  public Intake() {}
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public static void setIntakePosition(Number position){
    moveIntake.set(ControlMode.Position, (double) position);
  }
  
  public static void setIntakeRPM(Number speed){
    spinRollers.set(ControlMode.PercentOutput, (double) speed);
  }
  
  public static void upIntake(Number Percent){
    upIntake.set(ControlMode.PercentOutput, (Double) Percent);
  }
}
