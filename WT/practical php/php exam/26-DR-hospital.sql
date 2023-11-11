

-- Create the Doctor table
CREATE TABLE Doctor (
    doc_no SERIAL PRIMARY KEY,
    dname VARCHAR(255),
    address VARCHAR(255),
    city VARCHAR(255),
    area VARCHAR(255)
);

-- Create the Hospital table
CREATE TABLE Hospital (
    hosp_no SERIAL PRIMARY KEY,
    hname VARCHAR(255),
    hcity VARCHAR(255)
);

-- Create the Visits table to establish the many-to-one relationship
CREATE TABLE Visits (
    visit_id SERIAL PRIMARY KEY,
    doc_no INT REFERENCES Doctor (doc_no),
    hosp_no INT REFERENCES Hospital (hosp_no)
);

INSERT INTO Doctor (dname, address, city, area)
VALUES ('Dr. John Smith', '123 Main Street', 'New York', 'Downtown'),
       ('Dr. Jane Doe', '456 Elm Street', 'Los Angeles', 'Westside'),
       ('Dr. David Johnson', '789 Oak Street', 'Chicago', 'Northside');

INSERT INTO Hospital (hname, hcity)
VALUES ('General Hospital', 'New York'),
       ('City Medical Center', 'Los Angeles'),
       ('Community Hospital', 'Chicago');


-- Dr. John Smith visits General Hospital
INSERT INTO Visits (doc_no, hosp_no)
VALUES (1, 1);

-- Dr. Jane Doe visits General Hospital
INSERT INTO Visits (doc_no, hosp_no)
VALUES (2, 1);

-- Dr. Jane Doe also visits City Medical Center
INSERT INTO Visits (doc_no, hosp_no)
VALUES (2, 2);

-- Dr. David Johnson visits Community Hospital
INSERT INTO Visits (doc_no, hosp_no)
VALUES (3, 3);
