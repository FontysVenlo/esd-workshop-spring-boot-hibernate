# Challenge

The Database Schema:

![database.png](diagrams%2Fdatabase.png)()[]


## Review
fields:
- private Long id;
- private String title;
- private Long rating;
- private String comment;
- private LocalTime created_at;

Constraints:
The title can only be 100 Characters long.
The rating has to be from 1-3 (1 = Bad, 2 = Okay, 3 = Good) (Could have also been solved with an enum but is nice for the challenge)


- 0-10 min: Introduction, project setup explanation (entities, repos, 1 basic controller), explain how tests work.

- 10-35 min: Challenge 1: Build Publisher CRUD (with tests). Students work to make PublisherChallengeTest.java pass.

- 35-45 min: Quick walkthrough of the Publisher solution, demo how to run API calls (e.g., with Postman/Insomnia or curl).

- 45-55 min: Challenge 2: Quiz on existing data using the API. Give them 2-3 questions about the pre-populated data (including the new publishers and games linked to them) that require them to make API calls to find answers.

- 55-60+ min: Solution walkthrough for the quiz, general Q&A, next steps/resources.