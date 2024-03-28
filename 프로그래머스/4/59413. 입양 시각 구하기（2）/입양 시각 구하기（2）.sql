with recursive TIME as (
    select 0 as hour
    union all
    select hour+1 from time where hour<23
)

select T.hour as HOUR, count(ANIMAL_ID) as COUNT
from TIME T left join ANIMAL_OUTS A on hour(A.DATETIME) = T.hour
group by 1
order by 1