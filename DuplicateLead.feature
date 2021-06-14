Feature:  Verify Duplicate Lead Functionality of LeaftApps Application

@featureValidation
Scenario Outline:  
Given Click FindLeads
And click PhTab
And Enter PhNumber <phNo>
And Click Find Leads Button 
And Click FirstResultRecord
Then Click DuplicateLead Button
And click CreateLeadButton

Examples:
|phNo|
|'8754595830'|
|'999999876'|