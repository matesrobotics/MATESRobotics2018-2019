// Copyright 2018-2019 FIRST Tech Challenge Team 12365
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotMap {
    /* Public OpMode members. */
    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public DcMotor lift = null;
    public DcMotor arm = null;
    public Servo lid = null;
    public DigitalChannel touch = null;

    /* local OpMode members. */

    /* Constructor */
    public RobotMap(){
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap hwMap) {
        // Define and Initialize Motors
        leftDrive = hwMap.get(DcMotor.class, "leftDrive");
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftDrive.setPower(0);

        rightDrive = hwMap.get(DcMotor.class, "rightDrive");
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setPower(0);

        lift = hwMap.get(DcMotor.class, "lift");
        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift.setPower(0);

        arm = hwMap.get(DcMotor.class, "arm");
        arm.setDirection(DcMotor.Direction.FORWARD);
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize all installed servos.
        lid = hwMap.get(Servo.class, "lid");

        // Define and initialize sensors
        touch = hwMap.get(DigitalChannel.class, "touch");
        touch.setMode(DigitalChannel.Mode.INPUT);

    }
}

