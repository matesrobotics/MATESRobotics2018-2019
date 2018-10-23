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

public class Test2018 extends LinearOpMode {
	private DcMotor tLeftDrive;
	private DcMotor tRightDrive;
	private DcMotor bLeftDrive;
	private DcMotor bRightDrive;
	private ElapsedTime runtime = new ElapsedTime();

	@Override
	public void runOpMode() {
		tLeftDrive = hardwareMap.get(DcMotor.class, "tLeftDrive");
		tRightDrive = hardwareMap.get(DcMotor.class, "tRightDrive");
		bLeftDrive = hardwareMap.get(DcMotor.class, "bLeftDrive");
		bRightDrive = hardwareMap.get(DcMotor.class, "bRightDrive");

		// Reverse the motor that runs backwards when connected directly to the battery
		tLeftDrive.setDirection(DcMotor.Direction.FORWARD);
		tRightDrive.setDirection(DcMotor.Direction.REVERSE);
		bLeftDrive.setDirection(DcMotor.Direction.FORWARD);
		bRightDrive.setDirection(DcMotor.Direction.REVERSE);

		//Initializes raise variable
		telemetry.addData("Status", "Initialized");
		telemetry.update();

		// Wait for the game to start (driver presses PLAY)
		waitForStart();

		// run until the end of the match (driver presses STOP)
		while (opModeIsActive()) {
			telemetry.addData("Status", "Running");
			telemetry.update();

			// Setup a variable for each drive wheel to save power level for telemetry
			double tLeftPower;
			double tRightPower;
			double bLeftPower;
			double bRightPower;
			
            tLeftPower  = -gamepad1.left_stick_y ;
            tRightPower = gamepad1.right_stick_y ;
            bLeftPower  = -gamepad1.left_stick_y ;
            bRightPower = gamepad1.right_stick_y ;

			// Send calculated power to wheels
			tLeftDrive.setPower(-tLeftPower);
			tRightDrive.setPower(-tRightPower);
			bLeftDrive.setPower(bLeftPower);
			bRightDrive.setPower(bRightPower);

			// Show the elapsed game time and wheel power.
			telemetry.addData("Status", "Run Time: " + runtime.toString());
			telemetry.addData("Motors", "Top Left (%.2f), Top Right (%.2f), Bottom Left (%.2f), Bottom Right (%.2f)", tLeftPower, tRightPower, bLeftPower, bRightPower);
			telemetry.addData("Status", "Running");
			telemetry.update();
			//hi this is brady
			//hi this is corbin
			//hi this is michael
			//hi this is ryan
			//hi this is logan
			// my nam jf

		}

	}

}

