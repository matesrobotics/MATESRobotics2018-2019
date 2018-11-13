/*
Copyright 2018-2019 FIRST Tech Challenge Team 12365

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.*;
@TeleOp

public class Drive extends LinearOpMode {
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private DcMotor lift;
    
    private Servo grabber;
    
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        
        double newTime = 0;
        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        lift = hardwareMap.get(DcMotor.class, "lift");
        grabber = hardwareMap.get(Servo.class, "grabber");


        // Reverse the motor that runs backwards when connected directly to the battery
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        lift.setDirection(DcMotor.Direction.FORWARD);

        //Initializes raise variable
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
        double grabberPos = 1;
        grabber.setPosition(grabberPos);
        
        int liftPos = 0;
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();

            //Tank Driving Controls (left and right joystick)
            double leftPower;
            double rightPower;
            
            leftPower  = -gamepad1.left_stick_y ;
            rightPower = gamepad1.right_stick_y ;

            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);
            
            //Servo Control (activated by left and right bumpers)
            grabberPos = 0.5;
            
            if (gamepad1.right_trigger > 0) {
            	grabberPos += gamepad1.right_trigger / 50;
            }
            
            if (gamepad1.left_trigger > 0) {
            	grabberPos -= gamepad1.left_trigger / 50;
            }
            
            grabberPos = Range.clip(grabberPos, 0, 0.5);
            
            grabber.setPosition(grabberPos);
            
            
            //Lift System for robot (activated by dpad up)
            boolean raiseLift = gamepad1.dpad_up;
            
            if (raiseLift) {
            	lift.setTargetPosition(liftPos + 5);
            	lift.setPower(1); //set power adjusts strength + speed of lift mechanism
            	
            } else {
            	lift.setTargetPosition(liftPos);
            	lift.setPower(0);
            }

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "Left Drive (%.2f), Right Drive (%.2f), Lift Status (%.2f)", leftPower, rightPower, raiseLift);
            telemetry.addData("Grabber Position: ", grabberPos);
            telemetry.addData("Status", "Running");
            telemetry.update();

        }

    }

}

//hi this is brady
//hi this is corbin
//hi this is michael
//hi this is ryan
//hi this is logan
// my nam jf
