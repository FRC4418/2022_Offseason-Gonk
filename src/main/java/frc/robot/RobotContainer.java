// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.stuypulse.stuylib.input.Gamepad;
import com.stuypulse.stuylib.input.gamepads.AutoGamepad;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Intake;
import frc.robot.commands.ConveryorIdle;
import frc.robot.commands.DrivetrainDrive;
import frc.robot.commands.IntakeUp;
import frc.robot.commands.ShooterEject;
import frc.robot.commands.ShooterShoot;
import frc.robot.commands.blankAuto;
import frc.robot.commands.climberDown;
import frc.robot.commands.climberUp;
import frc.robot.commands.IntakeLower;
import frc.robot.constants.Ports;
import frc.robot.subsystems.Climber;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain drivetrain = new Drivetrain();
  private final Shooter shooter = new Shooter();
  private final Intake intake = new Intake();
  private final Climber climber = new Climber();
  
  public final Gamepad driver = new AutoGamepad(Ports.Gamepad.DRIVER);
  private final DrivetrainDrive drivetrainDrive = new DrivetrainDrive(drivetrain, driver);

  public final blankAuto blankAuto = new blankAuto();

  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    shooter.setDefaultCommand(new ConveryorIdle(shooter));
    intake.setDefaultCommand(new IntakeUp(intake));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driver.getTopButton().whenHeld(new IntakeUp(intake));
    driver.getBottomButton().whenHeld(new IntakeLower(intake));


    driver.getDPadUp().whenHeld(new climberUp(climber));
    driver.getDPadDown().whenHeld(new climberDown(climber));

    driver.getRightButton().whenHeld(new ShooterShoot(shooter, intake));
    driver.getLeftButton().whenHeld(new ShooterEject(shooter, intake));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return blankAuto;
  }
}

