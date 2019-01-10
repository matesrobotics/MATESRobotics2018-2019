
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous

public class Autonomous extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    RobotMap robot = new RobotMap();

    //@Override //Code to run ONCE when the driver hits INIT
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void runOpMode() {
        runtime.reset();
        robot.lift.setPower(1);

        while(runtime.seconds()<5) {
        }

        robot.lift.setPower(0);

        //drive backwards at least 2 inches (I recommend 3 inches)
        runtime.reset();
        robot.leftDrive.setPower(-1);
        robot.rightDrive.setPower(-1);

        while(runtime.seconds()<2) {
        }

        //lower scissor lift
        runtime.reset();

        //rotate entire robot (clockwise from above) approx. 90 degrees (move left track forward and right track backward)
        runtime.reset();

        while(runtime.seconds()<3) {
            robot.leftDrive.setPower(1);
            robot.rightDrive.setPower(-1);
        }

        //drive backwards into crater (about 10 seconds of movement is good)
        runtime.reset();

        while(runtime.seconds()<10) {
            robot.leftDrive.setPower(-1);
            robot.rightDrive.setPower(-1);
        }
    }
}

