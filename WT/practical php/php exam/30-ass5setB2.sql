-- Create the Student table
CREATE TABLE Student (
    Stud_id INT PRIMARY KEY,
    Name VARCHAR(50),
    Class VARCHAR(20)
);

-- Create the Competition table
CREATE TABLE Competition (
    C_no INT PRIMARY KEY,
    C_name VARCHAR(50),
    Type VARCHAR(20)
);

-- Create the Student_Competition table with foreign keys
CREATE TABLE Student_Competition (
    Stud_id INT,
    C_no INT,
    Rank INT,
    Year INT,
    PRIMARY KEY (Stud_id, C_no),
    FOREIGN KEY (Stud_id) REFERENCES Student(Stud_id),
    FOREIGN KEY (C_no) REFERENCES Competition(C_no)
);

-- Insert data into the Student table
    INSERT INTO Student (Stud_id, Name, Class) VALUES(1, 'John Doe', 'Class A');
    INSERT INTO Student (Stud_id, Name, Class) VALUES(2, 'Jane Smith', 'Class B');
    INSERT INTO Student (Stud_id, Name, Class) VALUES(3, 'Bob Johnson', 'Class A');
    INSERT INTO Student (Stud_id, Name, Class) VALUES(4, 'Alice Brown', 'Class C');

-- Insert data into the Competition table
    INSERT INTO Competition (C_no, C_name, Type) VALUES(11, 'Math Competition', 'Academic');
    INSERT INTO Competition (C_no, C_name, Type) VALUES(12, 'Sports Day', 'Sports');
    INSERT INTO Competition (C_no, C_name, Type) VALUES(13, 'Art Exhibition', 'Cultural');

-- Insert data into the Student_Competition table

    INSERT INTO Student_Competition (Stud_id, C_no, Rank, Year) VALUES(1, 11, 1, 2022);
    INSERT INTO Student_Competition (Stud_id, C_no, Rank, Year) VALUES(2, 11, 2, 2022);
    INSERT INTO Student_Competition (Stud_id, C_no, Rank, Year) VALUES(3, 13, 3, 2022);
    INSERT INTO Student_Competition (Stud_id, C_no, Rank, Year) VALUES(4, 13, 4, 2022);
    INSERT INTO Student_Competition (Stud_id, C_no, Rank, Year) VALUES(1, 12, 2, 2022);
    INSERT INTO Student_Competition (Stud_id, C_no, Rank, Year) VALUES(2, 12, 1, 2022);
    INSERT INTO Student_Competition (Stud_id, C_no, Rank, Year) VALUES(3, 12, 3, 2022);
