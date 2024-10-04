select hour(datetime) as HOUR, count(animal_id) as COUNT
from animal_outs
group by hour(datetime)
having hour between 9 and 19
order by 1