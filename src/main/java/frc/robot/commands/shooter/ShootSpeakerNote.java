package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotMap;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.swerve.Drivetrain;

public class ShootSpeakerNote extends Command {
    private final Timer timer = new Timer();

    public ShootSpeakerNote() {
        addRequirements(Shooter.getInstance());
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    public void execute() {
        if (Drivetrain.getInstance().alignedToSpeaker())
            Shooter.getInstance().setIndexer(RobotMap.Shooter.SHOOTING_SPEED);
    }

    public boolean isFinished() {
        return (!Shooter.getInstance().shooterIndexerOccupied()) ||
            (timer.get() >= 2);
    }

    public void end(boolean interrupted) {
        Shooter.getInstance().setShooter(0);
        Shooter.getInstance().setIndexer(0);
    }
}
