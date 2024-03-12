select O.PRODUCT_ID, P.PRODUCT_NAME, (P.PRICE * sum(O.AMOUNT)) as TOTAL_SALES
from FOOD_ORDER O left join FOOD_PRODUCT P on O.PRODUCT_ID = P.PRODUCT_ID
where year(O.PRODUCE_DATE) = 2022 and month(O.PRODUCE_DATE) = 5
group by O.PRODUCT_ID
order by 3 desc, 1