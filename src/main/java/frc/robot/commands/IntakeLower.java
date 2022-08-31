// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import com.stuypulse.stuylib.input.Gamepad;
import com.stuypulse.stuylib.math.SLMath;
import com.stuypulse.stuylib.streams.IStream;
import com.stuypulse.stuylib.streams.filters.LowPassFilter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Settings;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeLower extends CommandBase {
  private Intake intake;
  private Gamepad driver;

  /** Creates a new Intake. */
  public IntakeLower(Intake intake) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intake = intake;
    //this.driver = driver;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (driver.getRawTopButton()) {
      intake.raiseIntake(-300.0);
    }

  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
