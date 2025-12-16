# springrestapi
# Spring boot REST API project




## Here, {{url}} = "localhost:9090/api"


 ## GET Request:

- 0#  App Details      = {{url}} / version
- 1#. Read Employees   = {{url}} / employees
- 2#. Read Employees   = {{url}} / employees /6
- 3#. Read Employees By Name  = {{url}} /employee / searchByName?name=nahi
- 4#. Read Employee By Name and Location [RequestParam] = {{url}} / employee / searchByNameAndLocation?name=nahi&location=Bangladesh
- 5#. Read Employee By Name and Location [PathBariable]  = {{url}}/employee/Wasim/Dhaka
- 6#. Read Employee By Keyword  = {{url}}/employee/searchByKeyword?keyword=ah
- 7#. Read Employee By Age Greater Than [RequestParam]    = {{url}} / employee / searchByAgeGreaterThan?age=30
- 8#. Read Employee By Age Greater Than [PathBariable]   = {{url}} / employee/30
- 9#. Read Employee Age Between FromAge to ToAge         = {{url}} / employee/searchByAgeFromAndAgeTo?ageFrom=20&ageTo=32

<hr>
 
## POST Request:
- 1#. Create Employee [POST] = {{url}}/employees

 <hr>
 
## PUT Request:
- 1#  Update Employee [PUT]  = {{url}}/employees/8


 <hr>
 
## DELETE Request:
 - 1#. Delete Employee [DELETE] = {{url}}/employees?id=6
 <hr>
 
 ## If you have any query regarding this, you can catch me "md.talalwasim@gmail.com". Thank You!
 

