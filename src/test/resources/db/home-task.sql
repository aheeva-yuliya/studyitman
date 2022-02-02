DROP TABLE IF EXISTS salary;
DROP TABLE IF EXISTS worker;
DROP TABLE IF EXISTS candidate;
DROP TABLE IF EXISTS position;

CREATE TABLE `position` (
    `id`   INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `candidate` (
    `id`            BIGINT        NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name`          VARCHAR(50)   NOT NULL UNIQUE,
    `phone`         BIGINT        NULL,
    INDEX ix_candidate_name (name),
    INDEX ix_candidate_name (phone)
);

CREATE TABLE `worker` (
    `id`            BIGINT        NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `candidate_id`  BIGINT        NOT NUll,
    `start_date`    DATE          NOT NUll,
    `end_date`      DATE          NULL,
    `position_id`   INT           NOT NULL,
    CONSTRAINT fk_worker_man_id FOREIGN KEY (`candidate_id`) REFERENCES `candidate` (`id`),
    CONSTRAINT fk_worker_position_id FOREIGN KEY (`position_id`) REFERENCES `position` (`id`),
    INDEX ix_worker_candidate_id (candidate_id),
    INDEX ix_worker_position_id (position_id),
    INDEX ix_worker_end_date (end_date)
);

CREATE TABLE `salary` (
    `id`            BIGINT        NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `worker_id`     BIGINT        NOT NULL,
    `payment`       INT           NOT NULL,
    `date`          DATE          NOT NULL,
    CONSTRAINT fk_salary_worker_id FOREIGN KEY (`worker_id`) REFERENCES `worker` (`id`),
    INDEX ix_salary_worker_id (worker_id),
    INDEX ix_salary_date (date)
);

INSERT INTO `position` (NAME)
VALUES ('Marketing Manager'),
       ('Sales Manager'),
       ('Office Assistant'),
       ('Customer Service Representative'),
       ('Executive Assistant'),
       ('Software Engineer'),
       ('Client Service Agent');


INSERT INTO `candidate` (name, phone)
VALUES ('Ivanov', 375294567689),
       ('Petrov', 375295557689),
       ('Fedorov', 375295687689),
       ('Sidorov', null),
       ('Bondarev', 375294567899),
       ('Begunov', 375294567889),
       ('Guberniev', 375298667689),
       ('Nikitov', null),
       ('Filipov', null);

INSERT INTO `worker` (candidate_id, start_date, end_date, position_id)
VALUES (1, '2021-12-15', null, 2),
       (2, '2020-12-15', '2021-12-15', 3),
       (2, '2021-12-15', null, 6),
       (2, '2021-12-15', '2021-12-19', 6),
       (3, '2021-12-15', null, 3),
       (4, '2020-12-16', '2021-12-16', 1),
       (5, '2021-12-13', null, 4),
       (6, '2020-12-16', null, 6),
       (7, '2020-12-18', null, 5),
       (8, '2021-12-16', null, 1),
       (9, '2021-12-18', null, 5);

INSERT INTO `salary` (worker_id, payment, date)
VALUES (1, 900, '2020-12-18'),
       (2, 800, '2020-12-18'),
       (3, 950, '2020-12-18'),
       (4, 900, '2020-12-18'),
       (5, 980, '2020-12-18'),
       (6, 900, '2020-12-18'),
       (1, 900, '2021-1-18'),
       (2, 800, '2021-1-18'),
       (3, 950, '2021-1-18'),
       (4, 900, '2021-1-18'),
       (5, 980, '2021-1-18'),
       (6, 900, '2021-1-18'),
       (1, 900, '2021-2-18'),
       (8, 875, '2021-1-19'),
       (2, 500, '2021-2-18'),
       (3, 350, '2021-2-18'),
       (7, 100, '2021-1-19'),
       (7, 900, '2021-2-19'),
       (8, 750, '2021-2-19'),
       (5, 980, '2021-2-18'),
       (6, 900, '2021-2-20');

select name
from(
    select distinct candidate_id
    from worker
    ) as workers
        inner join candidate on candidate_id = candidate.id
ORDER BY  name;


SELECT name
FROM worker
    inner join candidate m on worker.candidate_id = m.id
WHERE phone IS NULL;


SELECT name
FROM worker
    inner join candidate m on worker.candidate_id = m.id
WHERE name like 'B%'
order by name desc;


SELECT DISTINCT date
from salary;




SELECT m.name, p.name
from worker
         inner join candidate m on worker.candidate_id = m.id
         inner join position p on worker.position_id = p.id
where worker.end_date is null;


SELECT name
from worker
         inner join candidate m on worker.candidate_id = m.id
where worker.end_date is not null;


--
/*
 3.3
 */
select title, count(identifier), avg_payment
from (
         select worker.id as identifier, worker.position_id as pos_id, p.name as title
         from worker
            right join position p on p.id = worker.position_id
         where worker.end_date is null
    ) as joined
         left join (
                        select avg(payment) as avg_payment, w.position_id as worker_pos_id
                        from salary
                             inner join worker w on salary.worker_id = w.id
                        where w.end_date is null
                        group by w.position_id
                    ) as final on pos_id = worker_pos_id
group by pos_id;


select p.name, avg(payment), count(distinct w.position_id)
from salary
         inner join worker w on salary.worker_id = w.id
         right join position p on p.id = w.position_id
where w.end_date is null
group by w.position_id;
--


select c.name
from salary
    inner join worker w on salary.worker_id = w.id
    inner join candidate c on w.candidate_id = c.id
where end_date is null
group by worker_id
having avg(payment) > (
    select avg(payment)
    from salary);


select name
from(
select c.name as name, max(date) as last_date, worker_id as working_id, w.position_id as pos_id
from salary
         inner join worker w on salary.worker_id = w.id
         inner join candidate c on w.candidate_id = c.id
where end_date is null
group by worker_id) as first_table
    inner join salary s on s.date = last_date and working_id = s.worker_id
    inner join (select avg(payment) as average_paiment, position_id
                from salary
                     left join worker w2 on salary.worker_id = w2.id
                group by position_id) as average on position_id = pos_id
where s.payment > average_paiment;