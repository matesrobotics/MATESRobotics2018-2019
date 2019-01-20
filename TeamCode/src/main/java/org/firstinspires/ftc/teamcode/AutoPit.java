package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous

public class AutoPit extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    RobotMap robot = new RobotMap();
    double lidPos = 1;

    //@Override //Code to run ONCE when the driver hits INIT
    //public void init() {
    //  robot.init(hardwareMap);

    //}

    @Override
    public void runOpMode() {

        waitForStart();

        robot.init(hardwareMap);
        runtime.reset();
        robot.lift.setPower(1);
        while(opModeIsActive() && runtime.seconds()<15.5) {
            telemetry.addData("Lowering to Ground!", runtime);
            telemetry.update();
        }
        robot.lift.setPower(0);

        //drive backwards at least 2 inches (I recommend 3 inches)
        runtime.reset();
        robot.leftDrive.setPower(-1);
        robot.rightDrive.setPower(-1);
        robot.lift.setPower(-1);
        while(opModeIsActive() && runtime.seconds()<0.215) {
            telemetry.addData("Backing Up!", runtime);
            telemetry.update();
            if (robot.touch.getState()) {
                break;
            }
            
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);

        runtime.reset();
        while(opModeIsActive() && runtime.seconds()< 1) {
            
        }

        //rotate entire robot (clockwise from above) approx. 90 degrees (move left track forward and right track backward)
        runtime.reset();
        double rotation = 3.66666; // time it takes robot to rotate 360 degrees
        robot.leftDrive.setPower(1);
        robot.rightDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds()< .9) {
            telemetry.addData("Rotating!", runtime);
            telemetry.update();
            if (robot.touch.getState()) {
                break;
            }
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);

        //drive backwards into crater (about 10 seconds of movement is good)
        //Note: it's only 1 second for now for easier testing
        runtime.reset();
        robot.lift.setPower(-1);
        robot.leftDrive.setPower(1);
        robot.rightDrive.setPower(1);
        while(opModeIsActive() && runtime.seconds()< 2.8) {
            telemetry.addData("Going Forward!", runtime);
            telemetry.update();
            if (robot.touch.getState()) {
                break;
            }
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
        
        //Using arm to get Around
        runtime.reset();
        robot.arm.setPower(.5);
        while(opModeIsActive() && runtime.seconds()<1) {
            telemetry.addData("Arm Active!", runtime);
            telemetry.update();
            if (robot.touch.getState()) {
                break;
            }
        }
        robot.arm.setPower(0);
        robot.arm.setPower(0);
        
        runtime.reset();
        while(opModeIsActive() && runtime.seconds()<0.5) {
            telemetry.addData("Waiting!", runtime);
            telemetry.update();
            if (robot.touch.getState()) {
                break;
            }
        }
        
        
        //Go down at the end
        runtime.reset();
    
        lidPos = 0;
        
        robot.lid.setPosition(lidPos);
    
        while(opModeIsActive() && runtime.seconds()<5) {
             robot.lift.setPower(-1);
            telemetry.addData("Lowering 1!", runtime);
            telemetry.update();
            if (robot.touch.getState()) {
                break;
            }
        }
        
        
        runtime.reset();
        while(opModeIsActive() && runtime.seconds()<1) {
            telemetry.addData("Lowering 2!", runtime);
            telemetry.update();
            if (robot.touch.getState()) {
                break;
            }
        }
        robot.lift.setPower(0);
        lidPos = 1;
        
        robot.lid.setPosition(lidPos);
        
        runtime.reset();
        
        robot.leftDrive.setPower(-1);
        robot.rightDrive.setPower(1);
        while(opModeIsActive() && runtime.seconds()< 1.2) {
            telemetry.addData("Rotating!", runtime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
        
        runtime.reset();
        robot.leftDrive.setPower(1);
        robot.rightDrive.setPower(1);
        while(opModeIsActive() && runtime.seconds()< 3) {
            telemetry.addData("Going Forward!", runtime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
 
        // while(opModeIsActive() && runtime.seconds()<11) {
        //     telemetry.addData("Lowering 3!", runtime);
        //     telemetry.update();
        //     if (robot.touch.getState()) {
        //         break;
        //     }
        // }
        robot.lift.setPower(0);
}
}

