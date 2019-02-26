package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.RobotMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class ExperimentalTest extends LinearOpMode { //I might be able to put this class in another file, idk but that'd be great
    private ElapsedTime runtime = new ElapsedTime(); //Also note, I may still need to add the WhileOpModeIsActive to every loop
    RobotMap robot = new RobotMap();

    public void downLift(int time) {
        runtime.reset();
        robot.lift.setPower(-1);
        while(opModeIsActive() && runtime.seconds < time) {
            telemetry.addData("Retracting Body!",runtime);
            telemetry.update();
            if(robot.touch.getState()) {
                break;
            }
        robot.lift.setPower(0);
        }    
    }

    public void upLift(int time) {
        runtime.reset();
        robot.lift.setPower(1);
        while(opModeIsActive() && runtime.seconds < time) {
            telemetry.addData("Extending Body!",runtime);
            telemetry.update();
            }
        robot.lift.setPower(0);
    }    

    public void hookOut(int time) {
        runtime.reset();
        robot.hook.setPower(-1);
        while(opModeIsActive() && runtime.seconds < time) {
            telemetry.addData("Rotating Hook Out!", runtime);
            telemetry.update();
        }
        robot.hook.setPower(0);
    }
    
    public void hookIn(int time) {
        runtime.reset();
        robot.hook.setPower(1);
        while(opModeIsActive() && runtime.seconds < time) {
            telemetry.addData("Rotating Hook In!", runtime);
            telemetry.update();
        }
        robot.hook.setPower(0);
    }

    public void rightForward(int time) {
        runtime.reset();
        robot.rightDrive.setPower(1);
        while(opModeIsActive() && runtime.seconds < time) {
            telemetry.addData("Moving Right Tread Forward!", runime);
            telemetry.update();
        }
        robot.rightDrive.setPower(0);
    }

    public void rightBackward(int time) {
        runtime.reset();
        robot.rightDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds < time) {
            telemetry.addData("Moving Right Tread Backward!", runime);
            telemetry.update();
        }
        robot.rightDrive.setPower(0);
    }

    public void leftForward(int time) {
        runtime.reset();
        robot.leftDrive.setPower(1);
        while(opModeIsActive() && runtime.seconds < time) {
            telemetry.addData("Moving Left Tread Forward!", runime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
    }

    public void leftBackward(int time) {
        runtime.reset();
        robot.leftDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds < time) {
            telemetry.addData("Moving Left Tread Backward!", runime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
    }

    public void armForward(int time) {
        runtime.reset();
        robot.arm.setPower(0.5); //Note I don't know which way is positive or negative
        while(opModeIsActive() && runtime.seconds < time) {
            telemetry.addData("Arm Forward!", runtime);
            telemetry.update();
        }
        robot.arm.setPower(0);
    }

    public void armBackward(int time) {
        runtime.reset();
        robot.arm.setPower(-0.5); //Note I don't know which way is positive or negative
        while(opModeIsActive() && runtime.seconds < time) {
            telemetry.addData("Arm Backward!", runtime);
            telemetry.update();
        }
        robot.arm.setPower(0);
    }

    public void rotateLeft(int time) {
        runtime.reset();
        robot.rightDrive.setPower(1);
        robot.leftDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds < time) {
            telemetry.addData("Rotating Left!", runtime);
            telemetry.update();
        }    
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }

    public void rotateRight(int time) {
        runtime.reset();
        robot.rightDrive.setPower(-1);
        robot.leftDrive.setPower(1);
        while(opModeIsActive() && runtime.seconds < time) {
            telemetry.addData("Rotating Right!", runtime);
            telemetry.update();
        }    
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }

    public void goForward(int time) {
        runtime.reset();
        robot.leftDrive.setPower(1);
        robot.rightDrive.setPower(1);
        while(opModeIsActive() && runtime.seconds < time) {
            telemetry.addData("Driving Forward!", runtime);
            telemetry.update();
        }    
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }

    public void goBackward(int time) {
        runtime.reset();
        robot.leftDrive.setPower(-1);
        robot.rightDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds < time) {
            telemetry.addData("Driving Backward!", runtime);
            telemetry.update();
        }    
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }

    public void pause(int time) {
        runtime.reset();
        while(opModeIsActive() && runtime.seconds < time) {
            telemetry.addData("Waiting!", runtime);
            telemetry.update();
        }
    }

    public void closeLid() {
        lidPos = 1;
        robot.lid.setPosition(lidPos); //closes
    }

    public void openLid() {
        lidPos = 0;
        robot.lid.setPosition(lidPos); //opens
    }


    public void runOpMode() {
        waitforstart();
        robot.init(hardwareMap);
        lidPos = 1;  //sets lid position to close
        robot.lid.setPosition(lidPos);
        
        downLift(5);
        upLift(3);
        pause(2);
       
        rightForward(0.5);
        pause(0.3);
        rightBackward(0.5);
        pause(0.3);

        leftForward(0.5);
        pause(0.3);
        leftBackward(0.5);
        pause(0.3);

        rotateRight(0.75);
        pause(0.3);
        rotateLeft(0.75);
        pause(0.3);

        goForward(1);
        pause(0.3);
        goBackward(1);
        pause(0.3);
        
        armForward(0.8);
        pause(0.1);
        openLid();
        pause(0.3);
        closeLid();
        armBackward(0.5);
        pause(0.5);
    }
}

