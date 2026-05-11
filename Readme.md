# Enrollment System - Scholarship & Validations

---

Author: Kiehl Alvarez

---

![SCH1.png](src/main/resources/Images/SCH1.png)
![SCH2.png](src/main/resources/Images/SCH2.png)
![SCH3.png](src/main/resources/Images/SCH3.png)
![SCH4.png](src/main/resources/Images/SCH4.png)
![SCH5.png](src/main/resources/Images/SCH5.png)
![SCH6.png](src/main/resources/Images/SCH6.png)

# Update Summary:

### Dynamic Scholarship Engine

The system now calculates tuition fees based on three distinct scholarship tiers:

ACADEMIC: 50% Tuition Discount.

ATHLETIC: 30% Tuition Discount.

FINANCIAL_AID: 75% Tuition Discount.

### Enrollment Guards & Validations

Duplicate Prevention: Checks the section's student list to ensure a student isn't enrolled twice in the same section.

Capacity Management: Enforces a maxCapacity limit. If a section is full, the system triggers a custom SectionFullException.

Input Protection: All numeric inputs are wrapped in try-catch blocks. Typing non-numeric data (like "test") will no longer crash the application.