SELECT distinct C.CAR_ID
from CAR_RENTAL_COMPANY_CAR C join CAR_RENTAL_COMPANY_RENTAL_HISTORY H
     on C.CAR_ID = H.CAR_ID
where month(H.START_DATE) = 10 and C.CAR_TYPE like "세단"
order by C.CAR_ID desc;