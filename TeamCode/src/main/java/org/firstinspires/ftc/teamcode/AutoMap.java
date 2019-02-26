package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.RobotMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


public class AutoMap { //I might be able to put this class in another file, idk but that'd be great
    private ElapsedTime runtime = new ElapsedTime(); //Also note, I may still need to add the WhileOpModeIsActive to every loop
    double lidPos = 1;
    RobotMap robot = new RobotMap();
    
    public void goForward(double time) {
        //robot.init(hardwareMap);
        runtime.reset();
        robot.leftDrive.setPower(1);
        robot.rightDrive.setPower(1);
        while(runtime.seconds() < time) {
        }    
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }
}

