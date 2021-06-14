Feature: CreateLead Functionality of application

@smoke @regression
Scenario Outline: TC001_CreateLead with positive data 

When Click CreateLead option
And Enter CompanyName <CompanyName>
And Enter FirstName <FName>
And Enter LastName <LName>
And Enter PhNum <PhNum>
And click CreateLeadButton
Then Verify Lead is successfully created

Examples:
|CompanyName|FName|LName|PhNum|
|'TechnoSoft'|'Jan'|'Albert'|'9999999'|
|'FirstData'|'Benny'|'Jamine'|'9962040678'|
|'AppliedMaterials'|'Ravichander'|'Rao'|'999999876'|
