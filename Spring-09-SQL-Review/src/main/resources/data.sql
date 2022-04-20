select *
from departments;

select *
from employees;

select *
from regions;

select employee_id,first_name,department
from
    employees;

select *
from employees
where department = 'Sports';

select *
from employees
where department like '%nit%';

select *
from employees
where department like 'F%nit%';

select *
from employees
where salary>100000;

select *
from employees
where salary<100000;

select *
from employees
where salary>=100000;

select *
from employees
where department='Clothing'
  AND salary>90000
  AND region_id=2;

select *
from employees
where department='Closing'
   OR salary>90000;

select *
from employees
where salary<40000
  AND (department='Closing'
    OR department='Pharmacy');

select *
from employees
where department !='Sports';

select *
from employees
where department <> 'Sports';

select *
from employees
where not department<> 'Sports';

select *
from employees
where email IS Null;

select *
from employees
where email IS NOT Null;

select *
from employees
where department='Sports'
   OR department = 'First Aid'
   OR department = 'Toys'
   OR department = 'Garden';

select *
from employees
where department IN('Sports','FirstAid','Toys');

select *
from employees
where salary between 80000 and 100000;

select first_name, email
from employees
where gender='F'
  AND department='Tools'
  AND salary>110000;

select first_name,hire_date
from employees
where salary>165000
   OR(department='Sports' AND gender='M');

select *
from employees
ORDER BY employee_id DESC ;

select Distinct department
from employees;

select Distinct department
from employees
    fetch first 4 rows only;

select salary as yearly_salary
from employees;

select *
from students
ORDER BY age desc
    fetch first 4 rows only;

select *
from students
where age<=20
    AND (student_no BETWEEN 3 and 5 OR student_no=7)
   OR (age>20 AND student_no>=4);

select upper(first_name),lower(department)
from employees;

select length(first_name)
from employees;

select 'Hello There';

select trim('    Hello There    ');

select length('   Hello    ');

select length(trim('   Hello    '));

select first_name ||  ' '  ||last_name AS full_name
from employees;

select (salary>140000)
from employees;

select (salary>140000)AS hight_paid
from employees
ORDER BY salary DESC;

select department,(department LIKE'%th%')
from employees;

select 'This is test data'test_data;

select substring('this is test data' from 1 for 4)as test_data;

select department,replace(department,'Clothing','Clothes')
from departments;

select MAX(salary)
from employees;


select MIN(salary)
from employees;


select AVG(salary)
from employees;

select round(AVG(salary))
from employees;


select count(employee_id)
from employees;


select count(email)
from employees;


select sum(salary)
from employees
where department='Clothing';


select last_name,upper(substring(department,1,3)) as department,salary,hire_date
from professors;


select max(salary),min(salary)
from professors
where last_name!='Wilson';


select count(*)
from employees;


select count(*),department
from employees
group by department;


select sum(salary)as total_salary,department
from employees
group by department;


select min(salary),max(salary),avg(salary)as total_salary,department
from employees
group by department;


select min(salary),max(salary),avg(salary),count(*)total_number_employees,department
from employees
group by department;


select sum(salary)as total_salary,department
from employees
where region_id IN(4,5,6,7)
GROUP BY department;


select department,count(*)
from employees
group by department
order by department;


select department,count(*)
from employees
group by department
having count(*)<36
order by department;


select count(*),substring(email,position('@' IN email)+1)email_domain
from employees
where email is not null
group by email_domain;


select d.department
from employees e,departments d;


select *
from employees
where department not in(select department from departments);


select *
from(select *from employees where salary>150000)a;


select first_name,last_name,salary,(select first_name)
from employees;


select *
from employees
where department IN(select department from departments where division='Electronics');


select *
from employees
where region_id IN(select region_id from regions where country='Asia' OR country='Canada')
  and salary>130000;


select first_name,(select max(salary)from employees)-salary
from employees
where region_id IN(select region_id from regions where country='Asia' OR country='Canada');


select *
from employees
where department= ANY (Select department from departments where division='Kids')
  AND hire_date >ALL (select hire_date from employees where department='Maintenance');


select *
from students;


select student_name
from students
where student_no IN
      (select student_no from student_enrollment where course_no IN(select course_no
                                                                    from courses
                                                                    where course_title IN('Physics','US History')));


select first_name,salary,
       case
           WHEN salary<100000 then 'UNDER PAID'
           WHEN salary>100000 then 'PAID WELL'
           ELSE 'UNPAID'
           END AS category
from employees;

SELECT category,count(*)
from(select first_name,
            CASE
                when salary<100000 then 'UNDER PAID'
                WHEN salary>100000 and salary<160000 then 'PAID WELL'
                else 'EXECUTIVE'
                END as category
     from employees)a
group by category;


select first_name,country
from employees e,regions r
where r.region_id=e.region_id;


select first_name,email,division,d.department
from employees e,departments d,regions r
where e.department=d.department
  AND e.region_id=r.region_id;


select first_name,country
from employees INNER JOIN regions
                          ON employees.region_id=regions.region_id;


select first_name,email,division
from employees INNER JOIN departments
                          on employees.department=departments.department
where email is not null;


SELECT first_name,email,division,country
from employees e INNER JOIN departments d
                            ON e.department=d.department INNER JOIN regions r
                                                                    ON e.region_id=r.region_id
where email is not NULL;


select distinct e.department,d.department
from employees e LEFT JOIN departments d
                           ON e.department=d.department;


select distinct e.department,d.department
from employees e Right JOIN departments d
                            ON e.department=d.department;


select distinct e.department,d.department
from employees e Full JOIN departments d
                           ON e.department=d.department;


select department
from employees
union
select department
from departments;


select department
from employees
union all
select department
from departments;



select department
from employees
except
select department
from departments;