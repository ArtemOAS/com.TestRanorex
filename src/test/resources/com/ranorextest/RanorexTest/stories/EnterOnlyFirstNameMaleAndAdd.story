Scenario: Enter only firstName male and add
Given User open ranorex page
When Enter user first name
When Choose male
When Add user
When Confirm the incorrect filling
Then Not users female