select ID, case when size_of_colony <= 100 then 'LOW'
                when size_of_colony <= 1000 then 'MEDIUM'
                else 'HIGH'
            end as SIZE
from ecoli_data
order by 1