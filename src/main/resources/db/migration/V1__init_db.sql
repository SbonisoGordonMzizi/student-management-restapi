CREATE TABLE school_staff(
                        id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        department VARCHAR(20) NOT NULL ,
                        role VARCHAR(20) NOT NULL,
                        first_name VARCHAR(20) NOT NULL,
                        last_name VARCHAR(20) NOT NULL,
                        gender VARCHAR(1) NOT NULL,
                        age INT NOT NULL
);

CREATE TABLE electives(
                        id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        teacher_id BIGINT UNIQUE,
                        elective VARCHAR(30) NOT NULL,
                        FOREIGN KEY(teacher_id) REFERENCES school_staff(id)
);

CREATE TABLE student(
                        id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        first_name VARCHAR(20) NOT NULL,
                        last_name VARCHAR(20) NOT NULL,
                        gender VARCHAR(1) NOT NULL,
                        age INT NOT NULL,
                        elective_id BIGINT,
                        FOREIGN KEY(elective_id) REFERENCES electives(id)
);

