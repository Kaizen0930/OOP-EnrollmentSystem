# Enrollment System - JUnit Testing

---

Author: Kiehl Alvarez

---

### 1. Confirms that courses are properly linked to departments and that removal logic operates without errors.
![CourseRegTest.png](src/main/resources/Images/CourseRegTest.png)

### 2. Ensures the system correctly manages section limits and triggers the SectionFullException when capacity is exceeded.
![enrollmentregistest.png](src/main/resources/Images/enrollmentregistest.png)

### 3. Validates the successful handling, modification, and assignment of complex Instructor objects within departments.
![Instructorregistest.png](src/main/resources/Images/Instructorregistest.png)

### 4. Verifies that student data is added correctly and ensures duplicate IDs are blocked by the system.
![studentregistest.png](src/main/resources/Images/studentregistest.png)

### 5. Tests the accuracy of fee calculations based on units and validates the update of remaining balances.
![tuitionregistest.png](src/main/resources/Images/tuitionregistest.png)

Update:

The system now uses JUnit 5 to automate validation and ensure logic accuracy.

Information is verified in lists through assertions rather than manual console checks.

Services handle all the work to keep the Main class simple and are fully unit-tested.

Refined the service layer. Added automated tests for enrollment and tuition.