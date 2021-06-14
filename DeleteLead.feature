Feature: DeleteLead verification of LeaftApps application


@featureValidation
Scenario Outline:
Given Click FindLeads
When click PhTab
And Enter PhNumber <phNo>
And Click Find Leads Button 
Then Store FirstResultRecord
And Click FirstResultRecord
And Click Delete
When Click FindLeads Option
And Give StoredResultRecordandFindLeads
Then Verify if record is displayed

Examples:
|phNo|
|'8754595830'|
|'999999876'|