// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.Servo;

// @Autonomous

// public class OurAutoMode {
//     private DcMotor lift;
//     private DcMotor arm;
//     private DcMotor leftDrive;
//     private DcMotor rightDrive;
//     private Servo lid;'0'

//         RobotMap robot = new RobotMap(); // use the class created to define a Pushbot's hardware

//     private ElapsedTime runtime = new ElapsedTime();

//     // todo: write your code here



//     public void AutonomousMode() {

//         //waitForStart();



//         //lower main body (equivalent to raising the scissor lift)

//         runtime.reset();

//         robot.lift.setPower(1);


//         while(runtime.seconds()<4) {

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

//         }

//         robot.lift.setPower(0);

//         //drive backwards at least 2 inches (I recommend 3 inches)

//         runtime.reset();

//         robot.leftDrive.setPower(-1);

//         robot.rightDrive.setPower(-1);
//         while(runtime.seconds()<2) {
//         }




//         //lower scissor lift

//         runtime.reset();

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

//         runtime.reset();

//         while(runtime.seconds()<3) {

//             robot.leftDrive.setPower(1);

//             robot.rightDrive.setPower(-1);

//         }



//         //drive backwards into crater (about 10 seconds of movement is good)

//         runtime.reset();

//         while(runtime.seconds()<10) {

//             robot.leftDrive.setPower(-1);

//             robot.rightDrive.setPower(-1);

//         }

//     }

// }