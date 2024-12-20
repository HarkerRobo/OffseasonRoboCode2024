package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotMap;
import frc.robot.subsystems.Shooter;

public class RevShooter extends Command {

    private RobotMap.Shooter.Goal setpoint;

    public RevShooter(RobotMap.Shooter.Goal goal) {
        setpoint = goal;
        addRequirements(Shooter.getInstance());
    }

    public void execute() {
        switch (setpoint) {
            case AMP:
                Shooter.getInstance().setShooter(RobotMap.Shooter.INDEXING_SPEED);
                break;
            case SPEAKER:
                Shooter.getInstance().setShooter(RobotMap.Shooter.SHOOTING_SPEED);
                break;
            case FERRY:
                Shooter.getInstance().setShooter(RobotMap.Shooter.FERRY_SPEED);
                break;
        }
    }

    public boolean isFinished() {
        switch (setpoint) {
            case AMP:
                return Shooter.getInstance().isShooterAmpRevved();
            case SPEAKER:
                if (DriverStation.isAutonomous())
                    return Shooter.getInstance().isAutonShooterSpeakerRevved();
                return Shooter.getInstance().isShooterSpeakerRevved();
            case FERRY:
                return Shooter.getInstance().isShooterFerryRevved();
            default:
                return false;
        }
    }

    @Override
    public void end(boolean interrupted) {
        Shooter.getInstance().setIndexer(0);
    }
    
}
