select distinct id, email, first_name, last_name
from developers d left join skillcodes s on d.skill_code & s.code
where s.name in ('Python', 'C#')
order by 1