select count(*) as COUNT
from ecoli_data
where !(genotype & 2) and genotype & 5