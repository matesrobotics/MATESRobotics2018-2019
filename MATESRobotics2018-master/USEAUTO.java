/*
Copyright 2018 FIRST Tech Challenge Team 12365

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
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Remove a @Disabled the on the next line or two (if present) to add this opmode to the Driver Station OpMode list,
 * or add a @Disabled annotation to prevent this OpMode from being added to the Driver Station
 */
@Autonomous

public class USEAUTO extends LinearOpMode {
  
    private ElapsedTime runtime = new ElapsedTime();
    RobotMap robot = new RobotMap();
    //@Override //Code to run ONCE when the driver hits INIT
     //public void init() {
    //     //Initialize the hardware variables.
    //    robot.init(hardwareMap);

    //     //Send telemetry message to signify robot waiting;
    //     telemetry.addData("v1.2.7", "Hello Driver!");

    // }


 

   // @Override
    public void runOpMode() {
    //RobotMap robot = new RobotMap(); // use the class created to define a Pushbot's hardware

     

//     // todo: write your code here



//     public void AutonomousMode() {

         //waitForStart();



//         //lower main body (equivalent to raising the scissor lift)

        runtime.reset();

        robot.lift.setPower(1);


         while(runtime.seconds()<5) {

// //            robot.lift.setPower += 5;
// //
// //            if (liftPos % 2160 == 0) { //lift position is increased in half-revolution increments
// //
// //                i++;
// //
// //                lift = 2160 * i;
// //
// //            }
// //
// //            robot.lift.setTargetPosition(lift); //sets position to motor
// //
// //            robot.lift.setPower(1); //starts motor

         }

        robot.lift.setPower(0);

//         //drive backwards at least 2 inches (I recommend 3 inches)

        runtime.reset();

        robot.leftDrive.setPower(-1);

        robot.rightDrive.setPower(-1);
         while(runtime.seconds()<2) {
        }




//         //lower scissor lift

         runtime.reset();

// //        while(opModeIsActive()&&runtime.seconds()<5) {
// //
// //            liftPos -= 5;
// //
// //            if (liftPos % 2160 == 0) { //lift position is increased in half-revolution increments
// //
// //                i++;
// //
// //                lift = -2160 * i;
// //
// //            }
// //
// //            robot.lift.setTargetPosition(lift); //sets position to motor
// //
// //            robot.lift.setPower(1); //starts motor
// //
// //        }



//         //rotate entire robot (clockwise from above) approx. 90 degrees (move left track forward and right track backward)

         runtime.reset();

        while(runtime.seconds()<3) {

             robot.leftDrive.setPower(1);

             robot.rightDrive.setPower(-1);

         }



//         //drive backwards into crater (about 10 seconds of movement is good)

        runtime.reset();

        while(runtime.seconds()<10) {

            robot.leftDrive.setPower(-1);

            robot.rightDrive.setPower(-1);

        }

//     
        }
    }

