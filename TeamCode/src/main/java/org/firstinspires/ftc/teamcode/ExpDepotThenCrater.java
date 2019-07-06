package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.RobotMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime; //All this is just importing everything needed for the robot to function
//(Thank you qualcomm)

@Autonomous
public class ExpDepotThenCrater extends LinearOpMode { //Begins the class that starts the entire thing
    private ElapsedTime runtime = new ElapsedTime(); //Creates runtime as the time elapsed 
    RobotMap robot = new RobotMap(); //Creates the RobotMap from the file
    double lidPos = 1; //Sets the lid position variable (not the actual position) to closed

    public void downLift(double time) { //This method retracts the body
        runtime.reset();
        robot.lift.setPower(-1);
        while(opModeIsActive() && runtime.seconds() < time) { //When runtime reaches the defined time, the loop stops running and power is set to 0
            telemetry.addData("Retracting Body!",runtime);  
            telemetry.update();
            if(!robot.touch.getState()) { //This is the Currie switch that prevents the robot from breaking every time it goes too far down
                break;                    
            }
        }
        robot.lift.setPower(0);
    }

    public void upLift(double time) { //Extends the robot
        runtime.reset();
        robot.lift.setPower(1);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Extending Body!",runtime);
            telemetry.update();
            }
        robot.lift.setPower(0);
    }    

    public void hookOut(double time) { //Moves our hook out from the hook on the lander
        runtime.reset();
        robot.hook.setPower(-0.4);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Rotating Hook Out!", runtime);
            telemetry.update();
        }
        robot.hook.setPower(0);
    }
    
    public void hookIn(double time) { //Moves our hook into the lander's hook
        runtime.reset();
        robot.hook.setPower(0.4);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Rotating Hook In!", runtime);
            telemetry.update();
        }
        robot.hook.setPower(0);
    }

    public void leftForward(double time) { //Moves the left tread forward
        runtime.reset();
        robot.rightDrive.setPower(1); //Note how leftDrive and rightDrive are reversed, that's "by design"
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Moving Right Tread Forward!", runtime);
            telemetry.update();
        }
        robot.rightDrive.setPower(0);
    }

    public void leftBackward(double time) { //Moves the left tread backward
        runtime.reset();
        robot.rightDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Moving Right Tread Backward!", runtime);
            telemetry.update();
        }
        robot.rightDrive.setPower(0);
    }
 
    public void rightForward(double time) { //Moves the right tread forward
        runtime.reset();
        robot.leftDrive.setPower(1);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Moving Left Tread Forward!", runtime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
    }

    public void rightBackward(double time) { //Moves the right tread backward
        runtime.reset();
        robot.leftDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Moving Left Tread Backward!", runtime);
            telemetry.update();
        }
        robot.leftDrive.setPower(0);
    }

    public void armForward(double time) { //Moves the arm forward
        runtime.reset();
        robot.arm.setPower(0.5); //Half power since it is a strong motor and will break if set to 1
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Arm Forward!", runtime);
            telemetry.update();
        }
        robot.arm.setPower(0);
    }

    public void armBackward(double time) { //Moves the arm backward
        runtime.reset();
        robot.arm.setPower(-0.5); 
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Arm Backward!", runtime);
            telemetry.update();
        }
        robot.arm.setPower(0);
    }

    public void rotateRight(double time) { //Rotates the bot right by moving the right tread back and the left tread forward
        runtime.reset();               
        robot.rightDrive.setPower(1);
        robot.leftDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Rotating Left!", runtime);
            telemetry.update();
        }    
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }

    public void rotateLeft(double time) { //Opposite of rotateRight
        runtime.reset();
        robot.rightDrive.setPower(-1);
        robot.leftDrive.setPower(1);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Rotating Right!", runtime);
            telemetry.update();
        }    
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }

    public void goForward(double time) { //Moves both treads forward to go forward
        runtime.reset();
        robot.leftDrive.setPower(1);
        robot.rightDrive.setPower(1);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Driving Forward!", runtime);
            telemetry.update();
        }    
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }

    public void goBackward(double time) { //Moves both treads to go backward
        runtime.reset();
        robot.leftDrive.setPower(-1);
        robot.rightDrive.setPower(-1);
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Driving Backward!", runtime);
            telemetry.update();
        }    
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }

    public void pause(double time) { //Waits for a certain amount of time
        runtime.reset();             
        while(opModeIsActive() && runtime.seconds() < time) {
            telemetry.addData("Waiting!", runtime);
            telemetry.update();
        }
    }

    public void closeLid() { //Closes the lid of the arm
        lidPos = 1;
        robot.lid.setPosition(lidPos); //closes
    }

    public void openLid() { //Opens the lid of the arm
        lidPos = 0;
        robot.lid.setPosition(lidPos); //opens
    }


    public void runOpMode() { //The loop that runs when play is pressed
        waitForStart();
        robot.init(hardwareMap);
        lidPos = 1;  //sets lid position to close
        robot.lid.setPosition(lidPos);
        
        upLift(11); //Lower from lander
        hookOut(0.1);
        pause(0.1);
        downLift(5.5);
        leftForward(0.2);
        
        leftBackward(0.25); //Jerk to move away from lander
        leftForward(0.25);
        leftBackward(0.13);
        pause(0.2);

        rotateLeft (0.65); //Go to the depot
        goForward(1.5);
        
        armForward(0.6); //Move arm forward and release marker
        openLid();
        pause(0.7);
        
        armBackward(0.1); //Close lid
        closeLid();
        armBackward(0.4);
        
        rotateLeft(1.15); //Rotate towards enemy crater
        goForward(1.5); 
        goForward(1.5);
        armForward(0.05);
        goForward(3.73); //These are in separate lines in case I need to make the (shaky) arm move backward as the bot moves forward
    }
}