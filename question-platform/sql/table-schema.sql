CREATE TABLE question (
                          id SERIAL PRIMARY KEY,
                          text VARCHAR(255) NOT NULL,
                          type VARCHAR(50) NOT NULL CHECK (type IN ('POLL', 'TRIVIA'))
);

CREATE TABLE answer (
                        id SERIAL PRIMARY KEY,
                        question_id INT REFERENCES question(id) ON DELETE CASCADE,
                        text VARCHAR(255) NOT NULL,
                        votes INT DEFAULT 0
);

CREATE TABLE trivia_question (
                                 id INT PRIMARY KEY REFERENCES question(id),
                                 correct_answer_id INT REFERENCES answer(id)
);
