/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;
import org.usfirst.frc4682.Audacity.RobotMap;
/**
 *
 * @author luis
 */
public class ReboundFeeder extends CommandBase {
    boolean notifyExecute;
    
    
    
    public ReboundFeeder() {
        requires(feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        notifyExecute = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (notifyExecute == true) {
            System.out.print("Beginning to drive backwards\n");
            notifyExecute = false;
        }
        feeder.setSpeed(-RobotMap.feederSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return feeder.atStartLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.print("Feeder to startpoint command is finished.\n");
        feeder.setSpeed(0.0);
        System.out.print("Stopped feeder wheel\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.print("Feeder To startpoint command has been interrupted\n");
    }
}
