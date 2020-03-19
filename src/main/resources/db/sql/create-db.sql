--DROP TABLE Viruses IF EXISTS;

CREATE TABLE Viruses (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50)
);
