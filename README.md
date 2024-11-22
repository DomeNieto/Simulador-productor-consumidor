# Producer-Consumer Simulation 
This project simulates a real-world scenario involving farmers and clients interacting with a shared vegetable storage. Farmers produce vegetables and deliver them to the storage, while clients consume the vegetables from the storage. The storage has a limited capacity, and synchronization is required to manage concurrent access.

## Objects

### Store:
Represents the shared storage used by farmers and clients.

#### Funcionalities:
- Allow farmers to deposit vegetables into the storage.
- Allow clients to consume vegetables from the storage.
- Enforce synchronization to avoid race conditions when accessing the shared storage.
- Block producers when the storage is full and consumers when the storage is empty.

#### Key Attributes:
- limit: The maximum number of vegetables the storage can hold.

- storage: A list that acts as the storage container for vegetables.

#### Key Methods:
- deposit(String vegetable, String nameFarmer)

    Allows a farmer to add a vegetable to the storage. Blocks the farmer if the storage is full.

- consumes(String client)

    Allows a client to consume a vegetable from the storage. Blocks the client if the storage is empty.

---
---

## Threads

### Farmer
A thread representing a farmer who produces vegetables and delivers them to the storage.

#### Funcionalities:
- Produce a set number of vegetables, as configured in the properties file.
- Deliver vegetables to the shared storage, waiting if the storage is full.

#### Key Attributes:
- name: The farmer's unique identifier.

- store: The shared storage instance where vegetables are deposited.

- AMOUNT_OF_VEGETABLES: The total number of vegetables the farmer is responsible for producing.

#### Key Methods:
- run()

    Simulates the farmer's lifecycle: growing vegetables (with random growth time) and depositing them into storage.


---
### Client

A thread representing a client who consumes vegetables from the storage.

#### Funcionalities:
- Consume a set number of vegetables, as specified at initialization.
- Wait for vegetables to be available in the storage if it is empty.

#### Key Attributes:
- name: The client's unique identifier.
- store: The shared storage instance from which vegetables are consumed.
- amount: The total number of vegetables the client will consume.

#### Key Methods:
- run()

    Simulates the client’s lifecycle: consuming vegetables with random intervals between each consumption.