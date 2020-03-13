USE borrowthings;

INSERT INTO roles(id, name) VALUES(1, 'ADMIN'), (2, 'TEACHER'), (3, 'STUDENT');

INSERT INTO users(id, username, password, enabled, role_id) VALUES(1, 'admin', '$2a$10$kguZGVKgrTJveib9hAY1eejHO7WKFBAOZ8PswucKRHnR87OYUmoGK', true, 1);
