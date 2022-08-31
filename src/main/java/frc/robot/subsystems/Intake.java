// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Ports;

public class Intake extends SubsystemBase {
final WPI_TalonFX MOVEINTAKE = new WPI_TalonFX(Ports.Intake.INTAKE);
final WPI_TalonSRX SPINROLLERS = new WPI_TalonSRX(Ports.Intake.SPINSPEED);

  /** Creates a new Intake. */
  public Intake() {}
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void setRPMForIntake(Number speed){
    MOVEINTAKE.set(ControlMode.PercentOutput, (double) speed);
  }
  
  public void raiseIntake(Number speed){
    SPINROLLERS.set(ControlMode.PercentOutput, (double) speed);
  }
}
