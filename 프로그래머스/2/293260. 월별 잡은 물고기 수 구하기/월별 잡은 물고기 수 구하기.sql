select count(ID) as FISH_COUNT, month(TIME) as MONTH
from FISH_INFO
group by month(TIME)
order by 2 asc