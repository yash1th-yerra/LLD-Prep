## Parking Lot Management System

1. Park Vehicles.
2. Collecting Payments.
3. Managing available space efficiently.

system should accomodate different types of vehicles, provide various payment options and ensure smooth user operation.

#### Rough Flow & Discussion :

---

1. A parking lot has multiple slots available for vehicles.
2. Different vehicle types occupy spots that support specified spot type mapped to vehicle type
3. Each vehicle gets a parking ticket upon entry.
4. the system calculates parking fee based on duration of stay and vehicle type.

Exit & Payment:
- A vehicle must complete payment before exiting.
- system should facilitate multiple payment methods
- once payment is completed , vehicle exits and spot is freed.
Pricing :
- pricing should be done based on vehicle type
  - cars having more parking price than bikes etc. 
- as well as situation basis:
  - Time based pricing (peak & non peak hours)
  - Event based pricing (concerts & weekends etc).
Invalid states:
- A vehicle cannot park in already occupied slots.
- vehicles cannot vacate without payment.


## Requirements:

- System manages different vehicle types.
- vehicle enters & exit after making payment.
- a parking slot is assigned upon entry and freed upon exit.
- payment must be completed before leaving.
- system should handle different vehicle sizes and slot allocations efficiently.


##### Clarifying Requirements:
Extensibilty:
- What types of vehicles should system support ?
- Should parking spot accommodate any vehicle type ?
- How pricing can be done? different strategies?
- Should system support different payment methods?

Dynamic:
- How many floors and spots should system support ?
- How many entry/exit gates ?

Concurrency:
- Single or Multiple parking lot ?
- Do we need to ensure that no two vehicles get same spot ?

### Identifying Key Components:

---

Core Entities:
- Parking Lot
- Parking Floor
- Parking Spot
- Vehicle
- Entry Gate
- PricingStrategy
- Ticket
- Exit Gate
- PaymentMethod

ParkingLot
- floors
- entryGate
- exitGate
- pricingStrategy
- paymentMode

Parking Floor
- floorId
- parkingSpot

Parking Spot
- spotId
- vehicleType

Vehicle (I)
- vehicleNumber
- vehicleType
- vehicleDetails...
- CAR,BIKE,TRUCK

EntranceGate
- gateId
- vehicle
- entryTime
- Ticket

Ticket
- ticketId
- entryTime
- vehicle

PricingStrategy (I)
- TIME_BASED
- EVENT_BASED

ExitGate
- gateId
- PaymentMethod

PaymentMethod (I)
- CARD
- UPI
- CASH

Design Patterns considerations( not strictly followable):
- Payment Methods - Strategy 
- Pricing - Strategy 
- Vehicle Creation - Factory 
- Gate creations - Factory 
- Spots - factory or just normal list kind 
- paymentStatus - state 
- spotStatus - state 
- notifications ( upon successfull spot booking/payment successful) - observer








