# Getting Started

* Import project into Intellij with auto-imports and gradle wrapper
* Run

### Rest localhost:8080/applicatios
 * GET /{id} returns application with id equal to @PathVariable
 * POST /  @RequestBody {BODY} to create new application, throws if duplicate found
 * PUT / @RequestBody {BODY} to edit existing application
 * Delete /{id} delete application  with id equal to @PathVariable from database and returns it
## All methods returns processing application
 
 
# body for test 
* {"phone":"77085343129","fullName":"test","org":"Tst asd","abbr":"Ta","bid":1}