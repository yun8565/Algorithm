SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
from ANIMAL_INS I left join ANIMAL_OUTS O on I.ANIMAL_ID = O.ANIMAL_ID
where I.SEX_UPON_INTAKE != O.SEX_UPON_OUTCOME
order by 1