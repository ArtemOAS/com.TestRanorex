Scenario: Enter only firstName female and add
Given User open ranorex page
When Enter user first name
When Choose female
When Add user
When Confirm the incorrect filling
Then Not users female