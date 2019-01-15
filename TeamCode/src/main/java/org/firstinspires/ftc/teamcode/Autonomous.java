package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
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
        while(opModeIsActive() && runtime.seconds()<12.5) {
            telemetry.addData("Raising!", runtime);
            telemetry.update();
        }
        robot.lift.setPower(0);

        //drive backwards at least 2 inches (I recommend 3 inches)
        runtime.reset();
        robot.leftDrive.setPower(-1);
        robot.rightDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds()<1) {
            telemetry.addData("Backing Up!", runtime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);

        //rotate entire robot (clockwise from above) approx. 90 degrees (move left track forward and right track backward)
        runtime.reset();
        double rotation = 3.66666; // time it takes robot to rotate ones
        robot.leftDrive.setPower(1);
        robot.rightDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds()< rotation / 4) {
            telemetry.addData("Rotating!", runtime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);

        //drive backwards into crater (about 10 seconds of movement is good)
        runtime.reset();
        robot.leftDrive.setPower(-1);
        robot.rightDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds()< 5) {
            telemetry.addData("Backing Up!", runtime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }
}

