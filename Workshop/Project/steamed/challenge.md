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