Feature: Testing Rest Get Response
Scenario Outline: Get successfull response Message
Given body with "<userName>" "<password>" "<scope>" "<Status>"
When when user calls "getSuccess" with "GET" request
Then API call got success with status code 200 
And "Status" in response message is "OK"
And "Scope" in response message is "APP"

Examples:
|userName|password|scope|Status	|
|Harneet1|abcd1	  |T1	|Good	|
|Harneet |abcd	  |T2	|Poor	|
|Harneet |abcd2	  |T3	|Poor	|

