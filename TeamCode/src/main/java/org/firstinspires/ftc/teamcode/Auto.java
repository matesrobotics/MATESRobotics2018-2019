package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous

public class Auto extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    RobotMap robot = new RobotMap();

    @Override
    public void runOpMode() {

        waitForStart();

        robot.init(hardwareMap);
        runtime.reset();
        robot.lift.setPower(1);
        while(opModeIsActive() && runtime.seconds()<13) {
            telemetry.addData("Raising!", runtime);
            telemetry.update();
        }
        robot.lift.setPower(0);

        //drive backwards at least 2 inches (I recommend 3 inches)
        runtime.reset();
        robot.leftDrive.setPower(-1);
        robot.rightDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds()<0.215) {
            telemetry.addData("Backing Up!", runtime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);

        runtime.reset();
        while(opModeIsActive() && runtime.seconds()< 1) {
        }

        //rotate entire robot (clockwise from above) approx. 90 degrees (move left track forward and right track backward)
        runtime.reset();
        double rotation = 3.66666; // time it takes robot to rotate ones
        robot.leftDrive.setPower(-1);
        robot.rightDrive.setPower(1);
        while(opModeIsActive() && runtime.seconds()< rotation) {
            telemetry.addData("Rotating!", runtime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);

        //drive backwards into crater (about 10 seconds of movement is good)
        //Note: it's only 4 seconds for now for easier testing
        runtime.reset();
        robot.leftDrive.setPower(-1);
        robot.rightDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds()< 4) {
            telemetry.addData("Backing Up!", runtime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);

        //Go down at the end
        runtime.reset();
        robot.lift.setPower(-1);
        while(opModeIsActive() && runtime.seconds()<12) {
            telemetry.addData("Lowering!", runtime);
            telemetry.update();
            if (robot.touch.getState()) {
                break;
            }
        }
        robot.lift.setPower(0);
    }
}

