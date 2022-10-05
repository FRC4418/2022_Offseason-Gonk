// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Ports;
import frc.robot.constants.Settings;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.stuypulse.stuylib.math.SLMath;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class fan extends SubsystemBase {
  final WPI_TalonSRX fanMotor = new WPI_TalonSRX(Ports.fan.FAN_PORT);
  /** Creates a new fan. */
  public fan() {
    fanMotor.configFactoryDefault();
  }

  public void stop(){
    fanMotor.stopMotor();
  }

  public void setRPM(){
    double rpm = 10;
    fanMotor.set(ControlMode.PercentOutput, rpm);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
