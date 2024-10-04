select substr(product_code, 1,2) as CATEGORY, count(PRODUCT_ID) as PRODUCTS
from product
group by substr(product_code, 1,2)
order by 1