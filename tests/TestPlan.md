# Test Plan and Results

| ID | Scenario | Input/Action | Expected result |
|---|---|---|---|
| T01 | Normal two-wheeler entry | Enter TN01A1234 | Ticket allocated |
| T02 | Student monthly pass | Exit after 2 hours | Rs 0 |
| T03 | EV charging | Electric car, 130 minutes, 10 kWh | Parking fee plus Rs 20 charging |
| T04 | Duplicate registration | Enter same registration twice | Rejected |
| T05 | Full facility | Fill all slots, enter one more | No slot (`null`) |
| T06 | Last slot | Enter when one slot remains | Last slot allocated |
| T07 | Zero-minute stay | Exit immediately | Rs 0 |
| T08 | Fee slab boundary | 60 minutes for two-wheeler | Rs 15 |
| T09 | One minute beyond boundary | 61 minutes for two-wheeler | Rs 30 |
| T10 | Invalid release | Release floor 9 | `false` |
| T11 | E-bike day pass | Exit with visitor day pass | Rs 0 |
| T12 | Delivery van daytime | Park with interval overlapping 09:00–17:00 | Double car rate |

Actual results should be recorded after running the programs on the student's computer. Do not claim a test passed until it has been executed.
