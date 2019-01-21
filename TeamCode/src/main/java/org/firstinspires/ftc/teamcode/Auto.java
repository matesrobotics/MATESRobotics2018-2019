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

public class Auto extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    RobotMap robot = new RobotMap();
    double lidPos = 1;

    //I have no idea why these comments below are here but I'm leaving them anyway
    //@Override
    //Code to run ONCE when the driver hits INIT
    //public void init() {
    //  robot.init(hardwareMap);
    //}

    @Override
    public void runOpMode() {

        waitForStart();

        //Lowers robot to ground from hook
        robot.init(hardwareMap);
        runtime.reset();
        robot.lift.setPower(1);
        while(opModeIsActive() && runtime.seconds()<15.5) {
            telemetry.addData("Lowering to Ground!", runtime);
            telemetry.update();
        }
        robot.lift.setPower(0);

        //Backs robot away from hook
        runtime.reset();
        robot.leftDrive.setPower(-1);
        robot.rightDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds()<0.215) {
            telemetry.addData("Backing Up!", runtime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);

        //Waits after backing up
        runtime.reset();
        while(opModeIsActive() && runtime.seconds()< 1) {
            
        }

        //Rotates robot (clockwise from above) approx. 90 degrees (move left track forward and right track backward)
        runtime.reset();
        double rotation = 3.66666; // Approx. time it takes robot to rotate 360 degrees
        robot.leftDrive.setPower(1);
        robot.rightDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds()< .9) { //This is a decimal so it's easier to modify slightly
            telemetry.addData("Rotating!", runtime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);

        //Drives to front of depot
        runtime.reset();
        robot.leftDrive.setPower(1);
        robot.rightDrive.setPower(1);
        while(opModeIsActive() && runtime.seconds()< 2.8) {
            telemetry.addData("Going Forward!", runtime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
        
        //Swings arm in front of robot
        runtime.reset();
        robot.arm.setPower(.5);
        while(opModeIsActive() && runtime.seconds()<1) {
            telemetry.addData("Arm Active!", runtime);
            telemetry.update();
        }
        robot.arm.setPower(0);
        robot.arm.setPower(0);

        //Waits after moving arm
        runtime.reset();
        while(opModeIsActive() && runtime.seconds()<0.5) {
            telemetry.addData("Waiting!", runtime);
            telemetry.update();
        }
        
        
        //Lowers before releasing team marker
        //NOTE: The robot.touch.getState() section each time the bot lowers is the Currie switch
        runtime.reset();
        robot.lift.setPower(-1);
        while(opModeIsActive() && runtime.seconds()<5) {
            telemetry.addData("Lowering 1!", runtime);
            telemetry.update();
            if (robot.touch.getState()) {
                break;
            }
        }

        //Opens lid
        lidPos = 0;
        robot.lid.setPosition(lidPos);

        //Lowers slightly more while team marker is falling out
        runtime.reset();
        while(opModeIsActive() && runtime.seconds()<1) {
            telemetry.addData("Lowering 2!", runtime);
            telemetry.update();
            if (robot.touch.getState()) {
                break;
            }
        }

        //Closes lid
        lidPos = 1;
        robot.lid.setPosition(lidPos);

        //Lowers until end of autonomous period
        while(opModeIsActive() && runtime.seconds()<11) {
            telemetry.addData("Lowering 3!", runtime);
            telemetry.update();
            if (robot.touch.getState()) {
                break;
            }
        }
        robot.lift.setPower(0);
}
}

