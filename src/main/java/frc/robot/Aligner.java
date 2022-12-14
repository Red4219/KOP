package frc.robot;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Aligner {
    /* Call intakeMotor defined in RobotMap */
    //CANSparkMax intakeMotor = RobotMap.intakeMotor;

    /* Call intakeSolenoid defined in RobotMap */
    //CANSparkMax intakeLiftMotor = RobotMap.intakeLiftMotor;

    /*
     * Make this class public
     */
    public Aligner() {}

    /*
     * Lower intake
     */
    public void hood() {
        /*double alignTarget = Robot.shooterAlign.getTargetPosition(Robot.limelight.getDistance());
        if (Math.abs(Robot.shooterAlign.getPosition() - alignTarget) > Config.shootAlignTolerance) {
            //Robot.revolver.stop();

            if (Robot.shooterAlign.getPosition() > alignTarget) {
                Robot.shooterAlign.moveDown();
            } else {
                Robot.shooterAlign.moveUp();
            }
        } else {
            Robot.shooterAlign.stop();
            //Robot.revolver.rotateCW();
            //Robot.revolver.rotateCW();
        }*/
    }

    /*
     * Aims at the target if it's seen; looks around if not
     */
    public void autoAim() {
        
        if (Robot.limelight.hasTarget()) {
            aimAtTarget();
        } else {
            searchForTarget();
        }

    }

    private void aimAtTarget () {
        double degreesOff = Robot.limelight.getTx();
        if (Math.abs(degreesOff) > Config.shootTurnTolerance) {
            if (degreesOff > 0) {
                Robot.driveTrain.adjustTargetRight();
            } else {
                Robot.driveTrain.adjustTargetLeft();
            }
        } else {
            Robot.driveTrain.stopTank();
        }
    }

    private void searchForTarget () {
        Robot.driveTrain.adjustTargetLeft();
    }

    /*
     * Stops the intake
     */
    public void stop() {
        Robot.driveTrain.stopTank();
        //Robot.shooterAlign.stop();
    }
}