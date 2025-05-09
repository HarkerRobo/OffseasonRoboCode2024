package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;

public class RobotMap {

    // Global Robot Constants
    public static final boolean FIRST_BOT = true;
    public static final double MAX_VOLTAGE = 12;
    public static final double ROBOT_LOOP = 0.02;
    public static final String CAN_CHAIN = "rio";
    public static final String CAN_BUS_LEFT = "Left Drivetrain";
    public static final String CAN_BUS_RIGHT = "Right Drivetrain";
    
    public static final class Field {
        // field dimensions in meters
        public static final double FIELD_LENGTH = 16.54;
        public static final double FIELD_WIDTH = 8.21;
        public static final Field2d FIELD = new Field2d();
        public static final Translation2d SPEAKER = new Translation2d(Units.inchesToMeters(-1.5), Units.inchesToMeters(218.42));
        public static final Translation2d AMP = new Translation2d(Units.inchesToMeters(76.1), Units.inchesToMeters(323.00));

        public static final Translation2d STAGE_CENTER = new Translation2d(Units.inchesToMeters(211.034),Units.inchesToMeters(218.42-56.785));
        public static final Translation2d STAGE_LEFT = new Translation2d(Units.inchesToMeters(184.252),Units.inchesToMeters(218.42-41.287));
        public static final Translation2d STAGE_RIGHT = new Translation2d(Units.inchesToMeters(184.222),Units.inchesToMeters(218.42-72.23));
    }

    public static final class OI {
        public static final double JOYSTICK_DEADBAND = 0.15;
        public static final double TRIGGER_DEADBAND = 0.1;
      
        public static final int DRIVER_ID = 0;
        public static final int OPERATOR_ID = 1;
    }

    public static final class PID {
        public static final int PID_PRIMARY = 0;
        public static final int PID_AUXILIARY = 1;
      
        public static final int SLOT_INDEX = 0;
    }

    public static final class SwerveModule {
        // id of translation motors
        // FL, FR, BL, BR
        public static final int[] TRANSLATION_IDS = {22, 5, 28, 10};

        // translation motors inverted
        public static final InvertedValue[] TRANSLATION_INVERTS = (FIRST_BOT) ? new InvertedValue[]{InvertedValue.CounterClockwise_Positive, InvertedValue.CounterClockwise_Positive, InvertedValue.CounterClockwise_Positive, InvertedValue.CounterClockwise_Positive}
                                                                              : new InvertedValue[]{InvertedValue.Clockwise_Positive, InvertedValue.Clockwise_Positive, InvertedValue.Clockwise_Positive, InvertedValue.Clockwise_Positive};

        // ids for rotation motors
        public static final int[] ROTATION_IDS = {15, 18, 27, 25};

        // rotation motors inverted
        public static final InvertedValue[] ROTATION_INVERTS = {InvertedValue.Clockwise_Positive, InvertedValue.Clockwise_Positive, InvertedValue.Clockwise_Positive, InvertedValue.Clockwise_Positive};

        // cancoder ids
        public static final int[] CAN_CODER_ID = {9, 10, 11, 12};

        // offsets of cancoders of each swerve module (in rotations)
        public static final double[] CAN_CODER_OFFSETS = (FIRST_BOT) ? new double[]{0.399414, -0.399170, 0.340820, 0.403320}
                                                                     : new double[]{-0.141357+0.5, -0.115479+0.5, 0.099609, -0.030518};
        // current limit constants for translation motors
        public static final double TRANS_CURRENT_LIMIT = 40;
        public static final double TRANS_THRESHOLD_CURRENT = 55;
        public static final double TRANS_THRESHOLD_TIME= 0.1;

        // current limit constants for rotation motors
        public static final double ROT_CURRENT_LIMIT = 25;
        public static final double ROT_THRESHOLD_CURRENT = 40;
        public static final double ROT_THRESHOLD_TIME = 0.1;

        // gear ratios
        public static final double TRANSLATION_GEAR_RATIO = 6.12;
        public static final double ROTATION_GEAR_RATIO = 150.0 / 7.0; 
        // diameter of the wheel
        public static final double WHEEL_DIAMETER = Units.inchesToMeters(4.0); // meters

        // conversions from rotations -- NO GEAR RATIOS!!!
        public static final double TRANS_ROT_TO_METERS = WHEEL_DIAMETER * Math.PI; // rotations to meters
        public static final double ROT_ROT_TO_ANGLE = 360.0; // rotations to degrees

        // rotation kP
        public static final double ROTATION_kP = 50; // TODO
        public static final double ROTATION_kI = 0;
        public static final double ROTATION_kD = 0;

        // Translation FF Values
        public static final double TRANSLATION_kS = 0.13561; // TODO
        public static final double TRANSLATION_kV = 1.9051; // TODO
        public static final double TRANSLATION_kA = 1.5737; // TODO

        // pid
        public static final double TRANSLATION_kP = 1.7; // TODO
        public static final double TRANSLATION_kI = 0.5; // TODO
        public static final double TRANSLATION_kD = 0.00;  // TODO
    }

    public static final class Drivetrain {
        // Pigeon ID
        public static final int PIGEON_ID = 1;

        public static final double PIGEON_kP = 0.00012; // TODO

        public static final double MIN_OUTPUT = 0.05;

        // PID for omega (turning) control
        public static final double OMEGA_kP = 0.05; // TODO
        public static final double OMEGA_kI = 0.0;
        public static final double OMEGA_kD = 0.0;
        public static final double MAX_ERROR_SPEAKER = 5.0; // DEGREES

        public static final double VX_AMP_kP = 0.5;
        public static final double VY_AMP_kP = 0.5;
        public static final double MAX_ERROR_VX_AMP = Units.inchesToMeters(1.0);
        public static final double MAX_ERROR_VY_AMP = Units.inchesToMeters(3.0);
        public static final double OMEGA_AMP_KP = 2.5;
        public static final double MAX_ERROR_AMP_DEG = 1;

        public static final double VX_STAGE_kP = 0.19;
        public static final double VY_STAGE_kP = 0.17;
        public static final double OMEGA_STAGE_kP = 0.1;
        public static final double MAX_ERROR_DEG_TX_STAGE = 0.5;
        public static final double MAX_ERROR_DEG_TY_STAGE = 0.5;
        public static final double VERTICAL_DEG_STAGE = 10;
        
        // Robot Dimensions
        public static final double ROBOT_LENGTH = Units.inchesToMeters(28.5);
        public static final double ROBOT_WIDTH = Units.inchesToMeters(28.5);

        public static final double MAX_DRIVING_SPEED = 5.0; // m/s //TODO
        public static final double EXTENDED_MAX_DRIVING_SPEED_MULTIPLIER = 0.4;
        public static final double MAX_ACCELERATION = 8.5;
        public static final double MAX_ANGLE_VELOCITY = Math.PI;
        public static final double EXTENDED_MAX_ANGLE_VELOCITY_MULTIPLIER = 0.7;
        public static final double MAX_ANGLE_ACCELERATION = MAX_ANGLE_VELOCITY / 2.0;

        /**
         * PID values for X, Y, and Rotation (THETA)
         */

        public static double X_kP = 1.0; // TODO
        public static double X_kI = 0.0;
        public static double X_kD = 0.0;

        public static double Y_kP = 0.85; // TODO
        public static double Y_kI = 0.0;
        public static double Y_kD = 0.0;

        public static double THETA_kP = 5.3; // TODO
        public static double THETA_kI = 0.0;
        public static double THETA_kD = 0.0;
    }

    public static final class Shooter {
        public static final int MASTER_ID = 38;
        public static final int FOLLOWER_ID = 6;
        public static final int INDEXER_ID = 4;

        public static final InvertedValue MASTER_INVERT = InvertedValue.Clockwise_Positive;

        public static final int PROX_SENSOR_ID = 2;

        public static final boolean INDEXER_INVERT = true;

        public static final int SHOOTER_CURRENT_LIMIT = 90;
        public static final int SHOOTER_CURRENT_LIMIT_THRESHOLD = 100;
        public static final double SHOOTER_CURRENT_LIMIT_TIME = 0.1;
        public static final int INDEXER_CURRENT_LIMIT = 80;

        public static final double INDEXING_SPEED = 0.2;
        public static final double SHOOTING_SPEED = 1.0;
        public static final double FERRY_SPEED = 0.5;

        public static final double AUTON_REVVED_RPS = 370.0 / 60.0;
        public static final double REVVED_RPS = 1000.0 / 60.0;
        public static final double REVVED_AMP_RPS = 60.0 / 60.0;
        public static final double REVVED_FERRY_RPS = 800.0/ 60.0;

        public static enum Goal {
            AMP,
            SPEAKER,
            FERRY
        }
    }

    public static final class Pivot {
        public static final int MASTER_ID = 24;
        public static final int LIMIT_SWITCH_ID = 4;
        public static final int CAN_CODER_ID = 30;

        public static final double CAN_CODER_OFFSET = 0.032717;

        public static final InvertedValue MASTER_INVERT = InvertedValue.CounterClockwise_Positive;
        
        public static final double ZERO_SPEED = -0.35;

        public static final double PIVOT_AMP_kP = 25; // 11
        public static final double PIVOT_AMP_kS = 0;
        public static final double PIVOT_AMP_kD = 3.1;
        public static final double PIVOT_AMP_kG = 0.4;

        public static final double PIVOT_kG = 0.6;
        public static final double PIVOT_kP = 62; // 13
        public static final double PIVOT_kI = 0; //2.7
        public static final double PIVOT_kD = 6.5; //0;
        public static final double PIVOT_kS = 0; // 0.69673;
        public static final double OFFSET_ANGLE = 21;

        public static final double CLIMB_ANGLE = 100;
        public static final double AMP_ANGLE = 80;
        public static final double QUICK_ANGLE = 30;
        public static final double FERRY_ANGLE = 20;

        public static final double PIVOT_GEAR_RATIO = 37.5;
        
        public static final double PIVOT_ROT_TO_ANGLE = 360; // motor rotations to degrees

        public static final double STALLING_CURRENT = 50; // stalls when current is 50
        
        public static final double MAX_ERROR_SPEAKER = 1.5; // degrees
        public static final double MAX_ERROR_AMP = 2;
        public static final double MAX_ERROR_FERRY = 5;
    
        public static final double PIVOT_FORWARD_SOFT_LIMIT = 65 / 67.76 * 37.5;
        public static final double PIVOT_REVERSE_SOFT_LIMIT = 0;

        public static final double MAX_CRUISE_ACCLERATION = 817.03 / 2;
        public static final double MAX_CRUISE_VElOCITY = 817.03 * 0.8;

        public static enum Goal {
            AMP,
            SPEAKER,
            CLIMB,
            FERRY
        }

    }

    public static final class Elevator {
        public static final int MASTER_ID = 13;
        public static final int FOLLOWER_ID = 23; 
        public static final int LIMIT_SWITCH_ID = 1; 

        public static final double ELEVATOR_kP = 1;
        public static final double ELEVATOR_kG = 0.01;

        public static final double TRAP_HEIGHT = 0; // motor rotations
        public static final double STAGE_HEIGHT = 88;

        public static final double ELEVATOR_FORWARD_SOFT_LIMIT = 0;
        public static final double ELEVATOR_REVERSE_SOFT_LIMIT = 0;

        public static final double ELEVATOR_STALLING_CURRENT = 80;

        public static final InvertedValue MASTER_INVERT = InvertedValue.Clockwise_Positive;

        public static final double EXTEND_SPEED = 0.5;

        public static final double MAX_ERROR = 2; // motor rotations
    }

    public static final class Intake {
        public static final int DEPLOY_ID = 8;
        public static final int ROLLER_ID = 7;
        public static final int LIMIT_SWITCH_ID = 0;

        public static final boolean DEPLOY_INVERT = true;
        public static final boolean ROLLER_INVERT = false;

        public static final double ZERO_SPEED = -0.5;
        public static final double ROLLER_SPEED = 0.7;
        public static final double ROLLER_OUTAKE_SPEED = -0.8;

        public static final double DEPLOY_kP = 0.07;
        public static final double INTAKE_DEPLOY = 23.5; // rotations

        public static final double INTAKE_STALLING_CURRENT = 70;

        public static final int ROLLER_CURRENT_LIMIT = 70;
    }

    public static final class Indexer {
        public static final int MASTER_ID = 43;

        public static final InvertedValue MASTER_INVERT = InvertedValue.CounterClockwise_Positive;

        public static final double INDEXING_SPEED = 0.795;

        public static final int CURRENT_LIMIT = 50;
        public static final int CURRENT_LIMIT_THRESHOLD = 70;
        public static final double CURRENT_LIMIT_TIME = 0.2;

    }

    public static final class Camera {
        public static final double FORWARD = Units.inchesToMeters(11.823); // TODO
        public static final double UP = Units.inchesToMeters(21.47); // meters
        public static final double PITCH = -30.494; // degrees

        public static final Pose3d CAMERA_POSE_ROBOT_SPACE = new Pose3d(FORWARD, 0, UP, new Rotation3d(0, PITCH, 0));

        public static final int[] ID_SPEAKER_BLUE = {7, 8};
        public static final int[] ID_SPEAKER_RED = {3, 4};
        public static final int ID_AMP_BLUE = 6;
        public static final int ID_AMP_RED = 5;
        public static final int[] ID_STAGE_BLUE = {14, 15, 16};
        public static final int[] ID_STAGE_RED = {11, 12, 13};

        public static final double MAX_ERROR_VISION_POSE = 5; // meters
    }

}
