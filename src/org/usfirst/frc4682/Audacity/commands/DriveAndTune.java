package org.usfirst.frc4682.Audacity.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author luis
 * This command allows the bot to tank drive while tuning the shooter wheels with the
 * throttles on the joysticks
 */
public class DriveAndTune extends CommandGroup {
    
    public DriveAndTune() {
        addParallel(new TuneShooter());
        addParallel(new TankDrive());

    }
}
