select count(ID) as FISH_COUNT, (select FISH_NAME from FISH_NAME_INFO where FISH_TYPE = F.FISH_TYPE) as FISH_NAME
from FISH_INFO F
group by FISH_TYPE
order by 1 desc