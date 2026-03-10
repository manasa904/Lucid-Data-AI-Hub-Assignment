# Lucid-Data-AI-Hub-Assignment

# 1. Duplicate Detection

## Problem
Given a file containing up to **100 million email addresses**, identify all email addresses that appear more than once.

## Approach
- Read the file **line by line** instead of loading the entire file into memory.
- Maintain two sets:
  - **seenEmails** – stores emails encountered for the first time.
  - **duplicateEmails** – stores emails that appear multiple times.
- For each email:
  - If the email is not in `seenEmails`, add it to the set.
  - If the email already exists in `seenEmails`, add it to `duplicateEmails`.
- After processing the file, output all duplicate emails.

## Data Structures Used
- **HashSet**
  - `seenEmails` → tracks emails that have already appeared
  - `duplicateEmails` → stores duplicate emails

## Complexity

**Time Complexity**
- O(N)  

**Space Complexity**
- O(U)  

## Handling Large Input
- Uses **stream-based file reading (BufferedReader)**.
- Avoids loading the entire dataset into memory.
- Processes the file in **a single pass**, making it scalable for very large files.

---

# 2. Top 10 Most Frequent Words

## Problem
Given a file containing **millions of words**, determine the **top 10 most frequent words**.

Example input:

apple  
banana  
apple  
orange  
banana  
apple  

Example output:

apple 3  
banana 2  
orange 1  

## Approach
- Read the file **line by line**.
- Use a **HashMap** to count word frequencies.
- For each word:
  - Increment its count in the map.
- After counting all words:
  - Use a **Min Heap (PriorityQueue)** of size 10.
- Insert `(word, frequency)` pairs into the heap.
- If the heap size exceeds 10, remove the smallest element.
- The heap will contain the **top 10 most frequent words**.

## Data Structures Used

**HashMap**
- Structure: `word → frequency`

**PriorityQueue (Min Heap)**
- Maintains only the **top 10 frequent words**.

## Complexity

**Time Complexity** - **O(N)**

**Space Complexity** - **O(W)**

## Handling Large Input Efficiently
- File is processed **line by line**, avoiding large memory usage.
- Uses **HashMap for fast frequency updates**.
- Avoids sorting all words (which would be expensive).
- Uses a **fixed-size heap** to track only the top 10 results.

---
# 3. Log Analysis

## Problem
Given a system log file in the format:

timestamp,user_id,action

Example:

10:01,user1,login  
10:03,user2,search  
10:05,user1,purchase  
10:07,user2,search  
10:10,user3,login  

Tasks:
- Identify the **most active user**.
- Identify the **most common action**.

## Approach
- Read the log file **line by line**.
- Maintain two HashMaps:
  - `userActionCount` → counts actions per user.
  - `actionFrequency` → counts occurrences of each action.
- For each log entry:
  - Parse the line using `split(",")`.
  - Update counts in both maps.
- After processing the file:
  - Find the user with the **maximum number of actions**.
  - Find the action with the **highest frequency**.

## Data Structures Used
**HashMap**

1. `userActionCount`
2. `actionFrequency`
## Complexity

**Time Complexity**
- O(N)  

**Space Complexity**
- O(U + A)
Where:
- U = number of unique users
- A = number of unique actions.

## Handling Large Input Efficiently
- Uses **BufferedReader for efficient file streaming**.
- Processes logs in **a single pass**.
- Avoids storing the entire log dataset in memory.

---

# Summary

| Problem | Data Structures Used | Time Complexity | Space Complexity |
|-------|---------------------|----------------|----------------|
| Duplicate Emails | HashSet | O(N) | O(U) |
| Top Frequent Words | HashMap + Min Heap | O(N) | O(W) |
| Log Analysis | HashMap | O(N) | O(U + A) |
