Scenario: Confirm connect
Given Get url ranorex
When Push disconnect
And Push connect
And Confirm the connection
Then Connected successful