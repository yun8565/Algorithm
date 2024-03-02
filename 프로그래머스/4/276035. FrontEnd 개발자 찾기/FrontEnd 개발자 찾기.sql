with FE as (select * from SKILLCODES where CATEGORY = 'Front End')

select distinct ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS D inner join FE F on D.SKILL_CODE & F.CODE
order by ID;