
INSERT INTO `address` (`ID`, `Building_Number`, `City`, `Mail_Room_No`, `Room_Number`, `State`, `Street`, `Zip`) VALUES ('1', '332', 'fairfield', '322', '233', 'Iowa', 'N.4th', '52557');


INSERT INTO `credential` (`ID`, `Password`, `UserName`) VALUES ('1', 'admin', 'admin');


INSERT INTO `employee` (`EmployeeID`, `SocialSecurity`, `BirthDate`, `EmailAddress`, `FirstName`, `HomePhone`, `LastName`, `MiddleName`, `MobilePhone`, `officePhone`, `officeName`, `Salary`, `address_ID`, `userCredential_ID`) VALUES ('1', '3434543', '2015-11-05 00:00:00', 'abdfudll@ymail.com', 'Ronald', '343443', 'Regan', 'USA', '+16419190483', '2332324', 'softwarehouse', '3455', '1', '1');


INSERT INTO `role` (`RoleID`, `RoleName`, `RoleDescription`) VALUES
(1, 'HR', 'HR is responsible for creating/updating users'),
(2, 'ScrumMaster', 'Scrum Master is responsible for creating and updating userstories and sprint'),
(3, 'Tester', 'Tester is responsible for Updating Test Worklog and Estimate Testing Effort for User Stories'),
(4, 'Developer', 'Developer is responsible for Updating Development Worklog and Estimate Development Effort for User Stories');



INSERT INTO `credential_role` (`Credential_ID`, `employeeRole_RoleID`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4);