# Feature 1: tankDrive

## Method:`arcadeDrive(double throttle, double rotate)`

### BVA Step 1: describe the input and output

* Input: The throttle and rotation values of a joystick
* Output: The left and right motors move at a speed between -1 and 1

### BVA Step 2: determine the data type

* Input: Interval [-1, 1]
* Output: Interval [-1, 1]

### BVA Step 3: select values along the edges

* Input: -1.01, -1, 1, 1.01
* Output: -1, 0, 1

### BVA Step 4: determine the test cases


| Done | Throttle | Rotate | *Left* | *Right* | *Exception*     |
| ------ | :--------- | -------- | -------- | --------- | :---------------- |
| X    | -1.01    | 1      | X      | X       | IllegalArgument |
| X    | 1.01     | 0      | X      | X       | IllegalArgument |
| X    | 0        | -1.01  | X      | X       | IllegalArgument |
| X    | -1       | 1.01   | X      | X       | IllegalArgument |
| X    | -1       | -1     | -1     | 0       | X               |
| X    | -1       | 0      | -1     | -1      | X               |
| X    | -1       | 1      | 0      | -1      | X               |
| X    | 0        | -1     | -1     | 1       | X               |
|      | 0        | 0      | 0      | 0       | X               |
|      | 0        | 1      | 1      | -1      | X               |
|      | 1        | -1     | 0      | 1       | X               |
|      | 1        | 0      | 1      | 1       | X               |
|      | 1        | 1      | 1      | 0       | X               |
|      | 1        | 0.5    | 1      | 0.33    | X               |
