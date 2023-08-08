# Feature 1: lightSensorTransitioned

## Method:`lightSensorTransitioned(boolean currentReading, boolean prevReading)`

### BVA Step 1: describe the input and output

* Input: The current and previous sensor readings
* Output: True if the sensor transitioned, false otherwise

### BVA Step 2: determine the data type

* Input: boolean
* Output: boolean

### BVA Step 3: select values along the edges

* Input: true, false
* Output: true, false

### BVA Step 4: determine the test cases


| Done:heavy_check_mark: | currentReading | previousReading | *sensorTransitioned* |
| ------------------------ | ---------------- | ----------------- | ---------------------- |
|      X                  | false          | false           | false                |
|                        | false          | true            | true                 |
|                        | true           | false           | true                 |
|                        | true           | true            | false                |
