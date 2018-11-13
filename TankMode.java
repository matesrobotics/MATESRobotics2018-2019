/* Copyright 2018-2019 FIRST Tech Challenge Team 12365
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

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

    /* Declare OpMode members. */
    RobotMap robot = new RobotMap(); // use the class created to define a Pushbot's hardware
    private double bridgePos;
    private int liftPos;
    private int lift;
    private int i = 0;
    
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {    // Code to run ONCE when the driver hits INIT
        // Initialize the hardware variables.
        robot.init(hardwareMap);
        bridgePos = 1;

        // Send telemetry message to signify robot waiting;
        telemetry.addData("v1.2.5", "Hello Driver!");
    }

    @Override
    public void init_loop() {    //Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
    }
    
    @Override
    public void start() {    //Code to run ONCE when the driver hits PLAY
         //sets bridge position all the way down
        liftPos = 2100;
        bridgePos = 0.5; //initialize bridge to desired position when games starts
        robot.lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void loop() {    //Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
        
        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        robot.leftDrive.setPower(-gamepad1.left_stick_y);
        robot.rightDrive.setPower(gamepad1.right_stick_y);

        // Use Dpad-Up to run lift motor
        if (gamepad1.dpad_up) { //if dpad-up is pressed, lift position increases
            liftPos += 5;
            if (liftPos % 2160 == 0) { //lift position is increased in half-revolution increments
                i++;
                lift = 2160 * i;
            }
            robot.lift.setTargetPosition(lift); //sets position to motor
            robot.lift.setPower(1); //starts motor
        } 
        
        if (robot.lift.getCurrentPosition() % 4320 <= 25 ){ //if motor is on ground (one full revolution), motor turns off
            robot.lift.setPower(0);
        }

        // Use left and right bumpers to control the bridge servo

        if (gamepad1.right_trigger > 0) { //raises bridge
            bridgePos += gamepad1.right_trigger / 50;
        }
        if (gamepad1.left_trigger > 0) { //lowers bridge
            bridgePos -= gamepad1.left_trigger / 50;
        }

        bridgePos = Range.clip(bridgePos, 0, 0.5); //limits position value to between 0 and 0.5
        robot.bridge.setPosition(bridgePos); //assigns servo to bridge value

        // Send telemetry message to signify robot running;
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "Left Drive (%.2f), Right Drive (%.2f), Lift (%.2f)", -gamepad1.left_stick_y, gamepad1.right_stick_y, (double) lift);
        telemetry.addData("Bridge Position: ", bridgePos);
        telemetry.addData("Current Lift Position", robot.lift.getCurrentPosition());
        telemetry.addData("Status", "Running");
        telemetry.update();
    }

    @Override
    public void stop() { //Code to run ONCE after the driver hits STOP
    }
}
