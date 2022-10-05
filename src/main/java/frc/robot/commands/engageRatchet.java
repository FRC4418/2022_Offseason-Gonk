// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class engageRatchet extends CommandBase {
<<<<<<< Updated upstream
  private Climber climber;
 
  public engageRatchet(Climber climber) {
    this.climber = climber;
    }
=======
  /** Creates a new engageRatchet. */
  private Climber climber;
  public engageRatchet(Climber climber) {
    this.climber = climber;
    addRequirements(climber);
    // Use addRequirements() here to declare subsystem dependencies.
  }
>>>>>>> Stashed changes

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
<<<<<<< Updated upstream
    climber.ratchetEngage(); 
     }
=======
    climber.ratchetEngage();
>>>>>>> Stashed changes
  }

  // Called once the command ends or is interrupted.
  @Override
<<<<<<< Updated upstream
  public void end(boolean interrupted) {
    climber.ending();
  }
=======
  public void end(boolean interrupted) {}
>>>>>>> Stashed changes

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
