# Codex Challenge

> Projeto criado para realização do teste prático para vaga de desenvoledor de software Java/Kotlin na empresa Codex.



## 🚀 Steps to build/run and test the project

> #Basic info about the project - This project was built using: 
> >SpringBoot Framework version: v3.1.4 \
> MySQL version: 8.0.34 \
> Java JDK: 17.0.8 \
> Language: Kotlin \
> IDE: Intellij Community

To install and test this project follow this steps: \
    *Make sure to have Mysql and Java jdk-17 pre-installed in you machine!

1. Clone this repository
2. In src\main\resources\application.yml file, change mysql database credentials to your own username and password
3. Go to main class, CodexChallengeApplication, and run application.
4. Use postman collection file that you can find in the root folder of this repository.
   - 4.1 File name: CodexChallenge.postman_collection.json
5. A video with some basic tests can also be find in root folder of this repo.
   - 5.1 File name: 

## Tasks and Validations

You can use the postman collection or reproduce the tests follow the steps below: 


- [ ] Task 1 - Validate CNPJ format and check digits
  - HttpMethod: POST
  - End-point: localhost:8080/validate_cnpj
  - Body content example:
     ```Json
     {
       "cnpj": "12.648.266/0001-24"
     }
     ```
  - Example of body response for the entry above:
       ```Json
         {
            "cnpj": "12.648.266/0001-24",
            "isValid": true
         }
      ```
#
- [ ] Task 2 - Test if two rectangles intersect
  - HttpMethod: POST
  - End-point: localhost:8080/rectangle/check_intersection
  - Body content example:
    ```Json 
        {
          "rec1": {
              "p1": {
                  "x": 3.0,
                  "y": 5.0
              },
              "p2": {
                  "x": 11.0,
                  "y": 11.0
              }
          },
          "rec2": {
              "p1": {
                  "x": 7.0,
                  "y": 2.0
              },
              "p2": {
                  "x": 13.0,
                  "y": 7.0
              }
          }
       }
    ```
  - Example of body response for the entry above:
       ```Json
         {
             "intersectionDetected": true
         }
      ```
    
- [ ] Task 3 - Compute the area of intersection between two rectangles
  - HttpMethod: POST
  - End-point: localhost:8080/rectangle/compute_area
  - Body content example:
    ```Json 
        {
          "rec1": {
              "p1": {
                  "x": 3.0,
                  "y": 5.0
              },
              "p2": {
                  "x": 11.0,
                  "y": 11.0
              }
          },
          "rec2": {
              "p1": {
                  "x": 7.0,
                  "y": 2.0
              },
              "p2": {
                  "x": 13.0,
                  "y": 7.0
              }
          }
       }
    ```
  - Example of body response for the entry above:
       ```Json
         {
              "intersectionDetected": true,
              "areaOfIntersection": 15
         }
      ```
#

- [ ] Task 4 - Simple Todo List
  - Create a task:
    - Http method: POST
    - End-point: localhost:8080/tasks
    - Body content example:
     ```Json
     {
          "taskDescription": "Feed the cat"
     }
     ```
     - Body content empty - Status: 201 Created
  - List all tasks:
      - Http method: GET
      - End-point: localhost:8080/tasks
      - Body content example: *empty body for request
      - Body content response - Status: 200 Ok

    ```Json
    [
      {
        "id": 1,
        "taskDescription": "Feed the cat"
      },
      {
        "id": 2,
        "taskDescription": "Study Java"
      },
      {
        "id": 3,
        "taskDescription": "Pay bills"
      }
    ]
    ```
  - Delete a task by {id}
    - Http method: DELETE
    - End-point: localhost:8080/tasks/{id}
    - Body content response - Status: 204 No Content

  - Get a task by {id}
      - Http method: GET
      - End-point: localhost:8080/tasks/{id}
      - Body content response - Status: 200 OK
      ```Json
        {
              "id": 8,
              "taskDescription": "Feed the cat"
        }
     ```
    
#

- [ ] Task 5 - Rest Client - World Clock
  - PS: this solution is not 100% correct, the target server takes too long to respond and sometimes is out of service.
  - Http method: GET
  - End-point: localhost:8080/world_clock/client
  - Body response content - Status: 200 OK
    ```Json
        {
             "datetime": "2023-10-10T16:03Z",
             "utc_datetime": "utcOffset: 00:00:00"
        }
    ```

#

- [ ] Task 6 - Rest Server - World Clock
  - Http method: GET
  - End-point: localhost:8080/world_clock/server
  - Body response content - Status: 200 OK
    ```Json
        {
             "currentDateTime": "2023-10-10T13:09Z"
        }
    ```

