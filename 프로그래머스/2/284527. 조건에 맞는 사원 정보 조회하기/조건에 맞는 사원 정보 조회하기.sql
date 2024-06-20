with SCORE_YEAR as (select emp_no, sum(score) as score from HR_GRADE group by emp_no)

select score, E.emp_no, emp_name, position, email
from HR_EMPLOYEES E left join SCORE_YEAR S on E.emp_no = S.emp_no
order by 1 desc
limit 1