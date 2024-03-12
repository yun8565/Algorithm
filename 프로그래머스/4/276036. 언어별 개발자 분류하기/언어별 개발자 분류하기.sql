with 
p as (
    select CODE
    from SKILLCODES 
    where NAME = "Python"
),
c as (
    select CODE
    from SKILLCODES 
    where NAME = "C#"
),
f as (
    select sum(CODE) as CODE
    from SKILLCODES 
    where CATEGORY="Front End"
)

select 
    case
        when SKILL_CODE & p.CODE && SKILL_CODE & f.CODE then 'A'
        when SKILL_CODE & c.CODE then 'B'
        when SKILL_CODE & f.CODE then 'C'
    end as GRADE, ID, EMAIL
from DEVELOPERS, p, c, f
having GRADE is not null
order by 1,2