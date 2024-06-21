with COLONY_MAX_SIZE as (select distinct year(differentiation_date) as year, 
                         max(size_of_colony) as max_size
                         from ecoli_data 
                         group by 1)

select year(differentiation_date) as YEAR, 
        C.max_size - E.size_of_colony as YEAR_DEV,
        E.id
from ecoli_data E left join colony_max_size C 
    on year(E.differentiation_date) = C.year
order by 1, 2

