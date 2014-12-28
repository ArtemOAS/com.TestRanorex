Scenario: Load and delete VIP users
Given Open ranorex
When Load VIP Users
And Choose and delete VIP user
Then Deleted all VIP users