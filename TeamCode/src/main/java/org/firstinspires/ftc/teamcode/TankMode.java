// Copyright 2018-2019 FIRST Tech Challenge Team 12365

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Tank Mode")
public class TankMode extends OpMode{

    RobotMap robot = new RobotMap(); // use the class created to define a Pushbot's hardware

    private ElapsedTime runtime = new ElapsedTime();

    @Override //Code to run ONCE when the driver hits INIT
    public void init() {
        //Initialize the hardware variables.
            robot.init(hardwareMap);

    //Send telemetry message to signify robot waiting;
        telemetry.addData("v1.2.7", "Hello Driver!");
}

    @Override
    public void init_loop() {    //Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
    }

    @Override //Code to run ONCE when the driver hits PLAY
    public void start() {
        robot.arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override //Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    public void loop() {

        //Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        robot.leftDrive.setPower(gamepad1.left_stick_y);
        robot.rightDrive.setPower(gamepad1.right_stick_y);

        //Use Dpad-Up to run lift motor
        if (gamepad1.dpad_up) { //if dpad-up is pressed, lift position increases
            robot.lift.setPower(1);
        } else if (gamepad1.dpad_down) {
            robot.lift.setPower(-1);
        } else {
            robot.lift.setPower(0);
        }

        //Use triggers to set armPos
        int armPos = 0;

        armPos -= gamepad1.left_trigger * 5;
        armPos += gamepad1.right_trigger * 5;

        robot.arm.setTargetPosition(armPos);

        //Use bumpers to set lidPos
        int lidPos = 0;

        lidPos -= gamepad1.left_trigger / 50;
        lidPos += gamepad1.right_trigger / 50;

        lidPos = Range.clip(lidPos,0, 1);

        robot.lid.setPosition(lidPos);

        // Send telemetry message to signify robot running;
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "Left Drive (%.2f), Right Drive (%.2f)", -gamepad1.left_stick_y, gamepad1.right_stick_y);
        telemetry.addData("Current Arm Position", robot.arm.getCurrentPosition());
        telemetry.addData("Current Lid Position", robot.lid.getPosition());
        telemetry.addData("Status", "Running");
        telemetry.update();
    }

    @Override
    public void stop() { //Code to run ONCE after the driver hits STOP
    }
}
