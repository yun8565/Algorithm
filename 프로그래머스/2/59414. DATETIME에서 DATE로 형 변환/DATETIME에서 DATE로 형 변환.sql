select ANIMAL_ID, NAME, date_format(datetime, '%Y-%m-%d') as 날짜
from animal_ins
order by 1