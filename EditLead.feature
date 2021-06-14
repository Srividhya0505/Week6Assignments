Feature: EditLead functionality of LeaftApps Application

@sanity
Scenario Outline:
Given Click FindLeads
When click PhTab
And Enter PhNumber <phNo>
And Click Find Leads Button 
And Click FirstResultRecord
And Click EditButton
And UpdateCompanyName <CompName>
And click UpdateButton

Examples:
|phNo|CompName|
|'8754595830'|'TCSEur'|
|'9999999'|'MicrosoftUS'|
|'9962040678'|'AxelisBang'|