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

    public void downLift(){
        robot.lift.setPower(-1);
        while(true){
            telemetry.addData("Lower 1!",runtime);
            telemetry.update();
            if(robot.touch.getState()){
                robot.lift.setPower(0);
                break;
            } else {
                continue;
            }
        }    
    }

    public void upLift(){
        telemetry.addData("Upwards 1!",runtime);
        telemetry.update();
        robot.lift.setPower(1);
    }

    if(gamepad1.left_bumper){
        downLift();
    } else if (!gamepad1.left_bumper && !gamepad1.right_bumper){
        robot.lift.setPower(0);
    }

    @Override
    public void runOpMode() {

        waitForStart();
        robot.init(hardwareMap);

    }