//This is just the basics, I just wanted to lay out the general idea for the button
@Override
public void loop() {

    if(A IS PRESSED&&!robot.touch.getState()) { //idk how i would actually do that
            while(true){ //A while loop takes the place of continuous user input
                robot.lift.setPower(-1); //The lift power is constantly set to -1, moving the lift down
                if(robot.touch.getState()){ //Checks to see if the button is pressed; repeats in the while loop
                    robot.lift.setPower(0); //Stops the lift
                    break; //Closes the loop
        }
                continue; //Continues the loop
        }
        }
        }