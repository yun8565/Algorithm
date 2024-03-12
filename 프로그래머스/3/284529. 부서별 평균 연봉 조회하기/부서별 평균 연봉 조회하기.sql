select E.DEPT_ID, D.DEPT_NAME_EN, round(avg(E.SAL)) as AVG_SAL
from HR_EMPLOYEES E left join HR_DEPARTMENT D on E.DEPT_ID = D.DEPT_ID
group by DEPT_ID
order by 3 desc
