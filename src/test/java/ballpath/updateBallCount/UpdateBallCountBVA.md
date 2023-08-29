# Feature 1: updateBallCount

## Method:`updateBallCount(BallPathState currentState, int numberOfBalls)`

### BVA Step 1: describe the input and output

* Input: The current state of the ball path, the number of balls the robot currently has, and the transition state of each light sensor
* Output: The new state of the ball path

### BVA Step 2: determine the data type

* Input: Interval [0, 2], boolean
* Output: The current number of balls

### BVA Step 3: select values along the edges

* Input: Shooting, true, false, -1, 0, 1, 2, 3,
* Output: Interval [0, 2]

### BVA Step 4: determine the test cases


| Done:heavy_check_mark: | CurrentState | NumOfBalls | LowerLightSensorTransitioned:pencil2: | ShooterLightSensorTransitioned:pencil2: | *NewNumBalls* | *Exception*     |
| ------------------------ | :------------- | ------------ | --------------------------------------- | ----------------------------------------- | --------------- | :---------------- |
| X                       | -            | -1         | -                                     | -                                       | -             | IllegalArgument |
| X                       | -            | 3          | -                                     | -                                       | -             | IllegalArgument |
| X                        | Stopped      | 1          | -                                     | -                                       | 1             | -               |
| X                      | Loading      | 0          | true                                  | -                                       | 1             | -               |
| X                       | Loading      | 1          | true                                  | -                                       | 2             | -               |
| X                       | Loading      | 0          | false                                 | -                                       | 0             | -               |
| X                       | Loading      | 1          | false                                 | -                                       | 1             | -               |
| X                       | Shooting     | 2          | -                                     | true                                    | 1             | -               |
| X                       | Shooting     | 1          | -                                     | true                                    | 0             | -               |
| X                       | Shooting     | 2          | -                                     | false                                   | 2             | -               |
| X                       | Shooting     | 1          | -                                     | false                                   | 1             | -               |
