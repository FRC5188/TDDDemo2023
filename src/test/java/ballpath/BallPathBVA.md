# Feature 1: updateBallPathState

## Method:`updateBallPathState(BallPathState currentState, int numberOfBalls)`

### BVA Step 1: describe the input and output

* Input: The current ball path state, the value of each light sensor, the number of balls the robot currently has
* Output: The new state of the ball path

### BVA Step 2: determine the data type

* Input: Cases for each ball path state enum, boolean, Interval [0, 2]
* Output: Cases for each ball path state enum

### BVA Step 3: select values along the edges

* Input: Stopped, loading, shooting, true, false, -1, 0, 1, 2, 3,
* Output:Stopped, loading, shooting

### BVA Step 4: determine the test cases


| Done:heavy_check_mark: | CurrentState | NumOfBalls | LowerLightSensor:wrench: | UpperLightSensor:wrench: | *NewState* | *Exception*     |
| ------------------------ | :------------- | ------------ | -------------------------- | -------------------------- | ------------ | :---------------- |
| X                      | -            | -1         | -                        | -                        | X          | IllegalArgument |
| X                      | -            | 3          | -                        | -                        | X          | IllegalArgument |
| X                      | Stopped      | 0          | False                    | False                    | Stopped    | -               |
| X                      | Stopped      | 2          | True                     | True                     | Stopped    | -               |
| X                      | Stopped      | 1          | True                     | True                     | Loading    | -               |
| X                      | Stopped      | 0          | True                     | False                    | Loading    | -               |
| X                      | Stopped      | 1          | True                     | False                    | Loading    | -               |
|                        | Loading      | 0          | True                     | False                    | Loading    | -               |
|                        | Loading      | 1          | False                    | True                     | Stopped    | -               |
|                        | Loading      | 1          | True                     | True                     | Loading    | -               |
|                        | Loading      | 1          | False                    | False                    | Loading    | -               |
|                        | Shooting     | 2          | -                        | -                        | Shooting   | -               |
|                        | Shooting     | 1          | -                        | -                        | Shooting   | -               |
|                        | Shooting     | 0          | -                        | -                        | Stopped    | -               |
