INSERT INTO AUTHOR (name, thumbnail) VALUES ('Reed Odeneal', 'https://miro.medium.com/fit/c/262/262/0*w8_w2l7UtxIYUPBd.');
INSERT INTO AUTHOR (name, thumbnail) VALUES ('Derek Daley', NULL);

INSERT INTO POST (title, text, authorId) VALUES ('First blog post', 'Hello World!', 1);
INSERT INTO POST (title, text, authorId) VALUES ('Derek''s great blog post', 'Here it is. Thanks!', 2);
INSERT INTO POST (title, text, authorId) VALUES ('Yet another superb blog post', 'This is great. Have a nice day!', 1);
INSERT INTO POST (title, text, authorId) VALUES ('Derek''s post about sky color', 'The sky is blue.', 2);
INSERT INTO POST (title, text, authorId) VALUES ('Thought''s on GraphQL', 'GraphQL is awesome!', 1);
INSERT INTO POST (title, text, authorId) VALUES ('I love JavaScript', 'Just kidding. No one does.', 1);