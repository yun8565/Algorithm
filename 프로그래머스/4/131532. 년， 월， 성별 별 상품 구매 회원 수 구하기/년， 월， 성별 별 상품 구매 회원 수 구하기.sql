SELECT year(SALES_DATE) as YEAR, month(SALES_DATE) as MONTH, GENDER, count(distinct(O.USER_ID)) as USERS
from ONLINE_SALE O left join USER_INFO U on O.USER_ID = U.USER_ID
where GENDER is not null
group by year(SALES_DATE), month(SALES_DATE), GENDER
order by YEAR, MONTH, GENDER