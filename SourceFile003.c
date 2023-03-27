
task main()
{
	setMotorSpeed(motorB, 30);
	setMotorSpeed(motorC, 30);

	while(SensorValue[S1]==1){};

	setMotorSpeed(motorB, 0);
	setMotorSpeed(motorC, 0);


}
