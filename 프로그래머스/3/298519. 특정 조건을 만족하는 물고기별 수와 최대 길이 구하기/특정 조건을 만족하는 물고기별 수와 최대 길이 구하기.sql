select count(ID) as FISH_COUNT, max(case when LENGTH is null then 10 else LENGTH end) as MAX_LENGTH, FISH_TYPE
from FISH_INFO
group by FISH_TYPE
having avg(LENGTH) >= 33
order by 3 asc