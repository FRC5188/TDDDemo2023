# Feature 1: updateBallPathState

## Method:`updateBallPathState(BallPathState currentState, int numberOfBalls)`

### BVA Step 1: describe the input and output

* Input: The current ball path state, the value of each light sensor, the number of balls the robot currently has
* Output: The new state of the ball path

### BVA Step 2: determine the data type

* Input: Cases for each ball path state enum, boolean, Interval [0, 2]
* Output: Cases for each ball path state enum

### BVA Step 3: select values along the edges

* Input: Stopped, loading, shooting, true, false, -1, 0, 2, 3,
* Output:Stopped, loading, shooting

### BVA Step 4: determine the test cases


| Done | CurrentState | NumOfBalls | ~~LowerLightSensor~~ | ~~UpperLightSensor~~ | *NewState* | *Exception*     |
| ------ | :------------- | ------------ | ---------------------- | ---------------------- | ------------ | :---------------- |
|      | Stopped      | -1         | -                    | -                    | X          | IllegalArgument |
|      | Loading      | 3          | -                    | -                    | X          | IllegalArgument |
|      | Stopped      | 0          | False                | False                | Stopped    | X               |
|      | Stopped      | 2          | True                 | True                 | Stopped    | X               |
|      | Stopped      | 1          | True                 | True                 | Loading    | X               |
|      | Stopped      | 0          | True                 | False                | Loading    | X               |
|      | Stopped      | 1          | True                 | False                | Loading    | X               |
|      | Loading      | 0          | True                 | False                | Loading    | X               |
|      | Loading      | 1          | False                | True                 | Stopped    | X               |
|      | Loading      | 1          | True                 | True                 | Loading    | X               |
|      | Loading      | 1          | False                | False                | Loading    | X               |
|      | Shooting     | 2          | -                    | -                    | Shooting   | X               |
|      | Shooting     | 1          | -                    | -                    | Shooting   | X               |
|      | Shooting     | 0          | -                    | -                    | Stopped    | X               |
