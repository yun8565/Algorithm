select CART_ID
from CART_PRODUCTS
group by CART_ID
having group_concat(NAME) like '%Milk%' and group_concat(NAME) like '%Yogurt%'