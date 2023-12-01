// package org.firstinspires.ftc.teamcode;
// 
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.DcMotorSimple;
// import com.qualcomm.robotcore.util.ElapsedTime;
// 
// 
// @TeleOp(name="Movement: No Lift", group="Linear Opmode")
// public class BasicOmniOpMode_NoLiftMotor extends LinearOpMode {
//     HardwarePushbot robot = new HardwarePushbot();
// 
//     // Declare OpMode members for each of the 4 motors..
//     private ElapsedTime runtime = new ElapsedTime();
//     private DcMotor leftFrontDrive = null; //motor 3
//     private DcMotor leftBackDrive = null; //motor 2
//     private DcMotor rightBackDrive = null; //motor 1
//     private DcMotor rightFrontDrive = null; //motor 0
// 
// 
//     double MIN_POSITION = 0;
//     double MAX_POSITION = 1;
// 
// 
//     @Override
//     public void runOpMode() {
// 
//         robot.init(hardwareMap);
// 
//         // Initialize the hardware variables. Note that the strings used here must correspond
//         // to the names assigned during the robot configuration step on the DS or RC devices.
//         leftFrontDrive  = hardwareMap.get(DcMotor.class, "left_front_drive"); //motor 0
//         leftBackDrive  = hardwareMap.get(DcMotor.class, "left_back_drive"); //motor 1
//         rightFrontDrive = hardwareMap.get(DcMotor.class, "right_front_drive"); //motor 2
//         rightBackDrive = hardwareMap.get(DcMotor.class, "right_back_drive"); //motor 3
// 
//         // ########################################################################################
//         // !!!            IMPORTANT Drive Information. Test your motor directions.            !!!!!
//         // ########################################################################################
//         // Most robots need the motors on one side to be reversed to drive forward.
//         // The motor reversals shown here are for a "direct drive" robot (the wheels turn the same direction as the motor shaft)
//         // If your robot has additional gear reductions or uses a right-angled drive, it's important to ensure
//         // that your motors are turning in the correct direction.  So, start out with the reversals here, BUT
//         // when you first test your robot, push the left joystick forward and observe the direction the wheels turn.
//         // Reverse the direction (flip FORWARD <-> REVERSE ) of any wheel that runs backward
//         // Keep testing until ALL the wheels move the robot forward when you push the left joystick forward.
//         leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
//         leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
//         rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
//         rightBackDrive.setDirection(DcMotor.Direction.FORWARD);
// 
// 
//         // Wait for the game to start (driver presses PLAY)
//         telemetry.addData("Status", "Initialized");
//         telemetry.update();
// 
//         waitForStart();
//         runtime.reset();
// 
//         // run until the end of the match (driver presses STOP)
//         while (opModeIsActive()) {
//             double max;
// 
//             // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
//             double axial   = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
//             double lateral =  -gamepad1.left_stick_x;
//             double yaw     =  gamepad1.right_stick_x;
// 
//             // Combine the joystick requests for each axis-motion to determine each wheel's power.
//             // Set up a variable for each drive wheel to save the power level for telemetry.
//             double leftFrontPower  = axial + lateral + yaw;
//             double rightFrontPower = axial - lateral - yaw;
//             double leftBackPower   = axial - lateral + yaw;
//             double rightBackPower  = axial + lateral - yaw;
// 
//             // Normalize the values so no wheel power exceeds 100%
//             // This ensures that the robot maintains the desired motion.
//             max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
//             max = Math.max(max, Math.abs(leftBackPower));
//             max = Math.max(max, Math.abs(rightBackPower));
// 
//             if (max > 1.0) {
//                 leftFrontPower  /= max;
//                 rightFrontPower /= max;
//                 leftBackPower   /= max;
//                 rightBackPower  /= max;
//             }
// 
//             // Send calculated power to wheels
//             leftFrontDrive.setPower(leftFrontPower / 2);
//             rightFrontDrive.setPower(rightFrontPower / 2);
//             leftBackDrive.setPower(leftBackPower / 2);
//             rightBackDrive.setPower(rightBackPower / 2);
// 
//             // Show the elapsed game time and wheel power.
//             telemetry.addData("Status", "Run Time: " + runtime.toString());
//             telemetry.addData("Front left/Right", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
//             telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
//             telemetry.update();
// 
//             //sleep(50);
//         }
// 
// 
//     }}