// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auton;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Settings;
import frc.robot.subsystems.Drivetrain;

public class InfineteDrive extends CommandBase {
  /** Creates a new InfineteDrive. */
  private Drivetrain drivetrain;
  public InfineteDrive(Drivetrain drivetrain) {
    this.drivetrain = drivetrain;
    drivetrain.leftFrontMotor.configFactoryDefault();
		drivetrain.leftBackMotor.configFactoryDefault();
		drivetrain.rightFrontMotor.configFactoryDefault();
		drivetrain.rightBackMotor.configFactoryDefault();

		drivetrain.leftBackMotor.follow(drivetrain.leftFrontMotor);
		drivetrain.rightBackMotor.follow(drivetrain.rightFrontMotor);

    // Config closed-loop controls
    /*
    leftFrontMotor.config_kF(Settings.Drivetrain.Motion.PID.kSlot, 
                               Settings.Drivetrain.Motion.PID.kF);
		leftFrontMotor.config_kP(Settings.Drivetrain.Motion.PID.kSlot, 
                               Settings.Drivetrain.Motion.PID.kP);
    
		leftFrontMotor.config_kI(Settings.Drivetrain.Motion.PID.kSlot, 
                               Settings.Drivetrain.Motion.PID.kI);
    leftFrontMotor.config_kD(Settings.Drivetrain.Motion.PID.kSlot, 
                               Settings.Drivetrain.Motion.PID.kD);
		*/
    
    // Config integrated sensors (built-in encoders)
		drivetrain.resetEncoders();

    drivetrain.leftGroup.setInverted(true);
		drivetrain.rightGroup.setInverted(false);
    drivetrain.leftFrontMotor.setNeutralMode(NeutralMode.Brake);
		drivetrain.leftBackMotor.setNeutralMode(NeutralMode.Brake);
		drivetrain.rightFrontMotor.setNeutralMode(NeutralMode.Brake);
		drivetrain.rightBackMotor.setNeutralMode(NeutralMode.Brake);
  }
      
    // Use addRequirements() here to declare subsystem dependencies.

  public InfineteDrive() {
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.leftFrontMotor.set(ControlMode.PercentOutput, 1.0);
		drivetrain.rightFrontMotor.set(ControlMode.PercentOutput, 1.0); 
    drivetrain.leftBackMotor.set(ControlMode.PercentOutput, 1.0);
		drivetrain.rightBackMotor.set(ControlMode.PercentOutput, 1.0); 
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.tankDrive(0.0, 0.0);
    System.out.println("stopping");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
