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
public class Methods extends LinearOpmode { //I might be able to put this class in another file, idk but that'd be great
    private ElapsedTime runtime = new ElapsedTime(); //Also note, I may still need to add the WhileOpModeIsActive to every loop
    RobotMap robot = new RobotMap();

    public void downLift(int time) {
        runtime.reset();
        robot.lift.setPower(-1);
        while(opModeIsActive() && runtime < time) {
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
        while(opModeIsActive() && runtime < time) {
            telemetry.addData("Extending Body!",runtime);
            telemetry.update();
            }
        robot.lift.setPower(0);
    }    

    public void hookOut(int time) {
        runtime.reset();
        robot.hook.setPower(-1);
        while(opModeIsActive() && runtime < time) {
            telemetry.addData("Rotating Hook Out!", runtime);
            telemetry.update();
        }
        robot.hook.setPower(0);
    }
    
    public void hookIn(int time) {
        runtime.reset();
        robot.hook.setPower(1);
        while(opModeIsActive() && runtime < time) {
            telemetry.addData("Rotating Hook In!", runtime);
            telemetry.update();
        }
        robot.hook.setPower(0);
    }

    public void rightForward(int time) {
        runtime.reset();
        robot.rightDrive.setPower(1);
        while(opModeIsActive() && runtime < time) {
            telemetry.addData("Moving Right Tread Forward!", runime);
            telemetry.update();
        }
        robot.rightDrive.setPower(0);
    }

    public void rightBackward(int time) {
        runtime.reset();
        robot.rightDrive.setPower(-1);
        while(opModeIsActive() && runtime < time) {
            telemetry.addData("Moving Right Tread Backward!", runime);
            telemetry.update();
        }
        robot.rightDrive.setPower(0);
    }

    public void leftForward(int time) {
        runtime.reset();
        robot.leftDrive.setPower(1);
        while(opModeIsActive() && runtime < time) {
            telemetry.addData("Moving Left Tread Forward!", runime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
    }

    public void leftBackward(int time) {
        runtime.reset();
        robot.leftDrive.setPower(-1);
        while(opModeIsActive() && runtime < time) {
            telemetry.addData("Moving Left Tread Backward!", runime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
    }

    public void armForward(int time) {
        runtime.reset();
        robot.arm.setPower(0.5); //Note I don't know which way is positive or negative
        while(opModeIsActive() && runtime < time) {
            telemetry.addData("Arm Forward!", runtime);
            telemetry.update();
        }
        robot.arm.setPower(0);
    }

    public void armBackward(int time) {
        runtime.reset();
        robot.arm.setPower(-0.5); //Note I don't know which way is positive or negative
        while(opModeIsActive() && runtime < time) {
            telemetry.addData("Arm Backward!", runtime);
            telemetry.update();
        }
        robot.arm.setPower(0);
    }

    public void rotateLeft(int time) {
        runtime.reset();
        robot.rightDrive.setPower(1);
        robot.leftDrive.setPower(-1);
        while(opModeIsActive() && runtime < time) {
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
        while(opModeIsActive() && runtime < time) {
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
        while(opModeIsActive() && runtime < time) {
            telemetry.addData("Driving Forward!", runtime);
            telemetry.update();
        }    
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }

    public void pause(int time) {
        runtime.reset();
        while(opModeIsActive() && runtime < time) {
            telemetry.addData("Waiting!", runtime);
            telemetry.update();
        }
    }
} //ends class

public class Auto extends Methods { //I'm not sure if the whole 2 classes thing is gonna work but we'll see lol
    @Override
    public void runOpMode() {
        waitforstart();
        robot.init(hardwareMap);
        lidPos = 1;  //sets lid position to close
        robot.lid.setPosition(lidPos);
        
        downLift(11);
        hookOut(0.1);
        pause(0.1);
        downLift(5.5);
        rightForward(0.4);
       
        rightBackward(0.25); //jerk
        rightForward(0.25);
        rightBackward(0.25);
        pause(0.2);

        rotateRight(0.75);

        goForward(1.8);
        armForward(1.1);
        pause(0.5);
        armBackward(0.2);
        pause(0.2);
        pause(1);

        lidPos = 1;
        robot.lid.setPosition(lidPos); //closes

        downLift(2);
        rotateRight(1.5);
        goForward(4);

        robot.lift.setPower(0);

    }
}
