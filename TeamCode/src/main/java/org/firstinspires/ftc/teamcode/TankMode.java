// Copyright 2018-2019 FIRST Tech Challenge Team 12365
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
//Imports important stuff needed for the bot to run

@TeleOp(name="Tank Mode")
public class TankMode extends OpMode{ //Creates the class containing everything
    double lidPos = 1;
    RobotMap robot = new RobotMap(); //Defines the hardware
    private ElapsedTime runtime = new ElapsedTime();

    @Override // Code to run ONCE when the driver hits INIT
    public void init() {
        // Initialize the hardware variables.
        robot.init(hardwareMap);
        // Send telemetry message to signify robot waiting;
        telemetry.addData("Last Modified: March 5th, 2019", "Hello MATES Driver!");
    }

    @Override
    public void init_loop() { //Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
    }

    @Override // Code to run ONCE when the driver hits PLAY
    public void start() {
        robot.arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.hook.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODERS);
    }

    @Override // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    public void loop() {

        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        robot.leftDrive.setPower(-gamepad1.right_stick_y);
        robot.rightDrive.setPower(-gamepad1.left_stick_y);

        // Use the bumpers to move the lift up and down
        if (gamepad1.right_bumper  || gamepad2.right_bumper) { //if dpad-up is pressed, lift position increases
            robot.lift.setPower(1);
        } else if ((gamepad1.left_bumper && robot.touch.getState()) || (gamepad2.left_bumper && robot.touch.getState())) {
            robot.lift.setPower(-1); //The line above contains the aforementioned Currie switch to prevent the bot from breaking if it goes down too far.
        } else {                     
            robot.lift.setPower(0);
        }
        
        if (gamepad1.dpad_right) { //Changes the hook power in or out
            robot.hook.setPower(-0.4);
        } else if (gamepad1.dpad_left) {
            robot.hook.setPower(0.4);
        } else {
            robot.hook.setPower(0);
        }

        // Control arm using left and right triggers
        if (gamepad1.left_trigger != 0) {
            robot.arm.setTargetPosition(-100);
            robot.arm.setPower(-gamepad1.left_trigger / 2);
        } else if (gamepad1.right_trigger != 0){
            robot.arm.setTargetPosition(100);
            robot.arm.setPower(gamepad1.right_trigger / 2);
        } else if (gamepad2.left_trigger != 0) {
            robot.arm.setTargetPosition(-100);
            robot.arm.setPower(-gamepad2.left_trigger / 2);
        } else if (gamepad2.right_trigger != 0){
            robot.arm.setTargetPosition(100);
            robot.arm.setPower(gamepad2.right_trigger / 2);
        } else {
            robot.arm.setPower(0);
        }
        
        // Use bumpers to set lidPos
        int position = robot.arm.getCurrentPosition();
        if (gamepad1.dpad_down || gamepad2.dpad_down) {
            lidPos = 0; //open
        } else if (gamepad1.dpad_up || gamepad2.dpad_up) {
            lidPos = 1; //closed
        }

        lidPos = Range.clip(lidPos, 0, 1);
        robot.lid.setPosition(lidPos);

        if (robot.touch.getState()) { //Touch sensor for Currie switch
                telemetry.addData("Digital Touch", "Is Not Pressed");
            } else {
                telemetry.addData("Digital Touch", "Is Pressed");
            }

        // Send telemetry message to signify robot running;
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "Left Drive (%.2f), Right Drive (%.2f)", -gamepad1.left_stick_y, gamepad1.right_stick_y);
        telemetry.addData("Current Arm Position", "Left (%.2f), Right (%.2f)", gamepad1.left_trigger, gamepad1.right_trigger);
        telemetry.addData("Arm Encoder Position", position);
        telemetry.addData("Current Lid Position", robot.lid.getPosition());
        telemetry.addData("Requested Lid Position", lidPos);
        telemetry.addData("Status", "Running");
        telemetry.update();
    }

    @Override
    public void stop() { //Code to run ONCE after the driver hits STOP
    }
}