Feature: Merge Lead functionality verificaiton of LeaftApps Application

@Merge
Scenario Outline:
When Click MergeLead Link
And Click FromLead Lookup Search
And Enter First MergeLead Name <FMName> 
And Click Find Leads Button 
Then Store FirstResultRecord
And Click FirstResultRecord 
And Navigate to Main Window
When Click ToLead Lookup Search
And Enter Second MergeLead Name <SMName>
And Click Find Leads Button 
And Click FirstResultRecord
And Navigate to Main Window again
And Click Merge Button
And Accept Alert
When Click FindLeads Option
And Give StoredResultRecordandFindLeads
Then Verify if record is displayed

Examples:
|FMName|SMName|
|'Srividhya'|'Ravichander'|