# Use the following URL to write the test. Please note that you will need to register with the website in order to utilise their API: 
https://openweathermap.org/stations 
Using the API specification detailed in the URL above, develop the following tests(Each # is one test) 
1.	Validate that attempt to register a weather station without an API key will return the following in message body. 
HTTP RESPONSE CODE: 401
RESPONSE MESSAGE: "Invalid API key. Please see http://openweathermap.org/faq#error401 for more info." 
2.	Successfully register two stations with the following details and verify that HTTP response code is 201. 

"external_id": "DEMO_TEST001",
"name Interview Station <Random Number>", "latitude": 33.33,
"longitude": -111.43,
"altitude": 444 
 
"external_id": "Interview1 ",
"name": "Interview Station <Random Number>", "latitude": 33.44,
"longitude": -12.44,
"altitude": 444 
 

3.	Using “[GET] /stations” API verify that the stations were successfully stored in the DB and their values are the same as specified in the registration request. 
4.	Delete both of the created stations and verify that returned HTTP response is 204. 
5.	Repeat the previous step and verify that returned HTTP response is 404 and that message body contains “message”: “Station not found". 


References:https://openweathermap.org/stations
