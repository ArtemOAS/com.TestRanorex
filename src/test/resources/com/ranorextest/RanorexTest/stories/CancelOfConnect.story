Scenario: Cancel of connect
Given Get url ranorex
When Push disconnect
And Push connect
And Cancel of connection
Then Not connected