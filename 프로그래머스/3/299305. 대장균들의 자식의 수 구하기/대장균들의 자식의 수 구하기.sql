select E1.id, count(E2.id) as CHILD_COUNT
from ecoli_data E1 left join ecoli_data as E2 on E1.id = E2.parent_id
group by 1
order by 1