//This is just the basics, I just wanted to lay out the general idea for the button
@Override
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class Logan extends OpMode{
    RobotMap robot = new RobotMap();
    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    public void loop() {
        if (gamepad1.a && !robot.touch.getState()) {
            boolean isRunning = true;
            while (isRunning) { //A while loop takes the place of continuous user input
                robot.lift.setPower(-1); //The lift power is constantly set to -1, moving the lift down
                if (robot.touch.getState()) { //Checks to see if the button is pressed; repeats in the while loop
                    robot.lift.setPower(0); //Stops the lift
                    isRunning = false; //Closes the loop
                }
            }
        }
    }

}
