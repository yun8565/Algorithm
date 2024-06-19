with USER_2021 as (select user_id from user_info where year(joined) = 2021)

select year(sales_date) as YEAR, month(sales_date) as MONTH,
    count(distinct os.user_id) as PURCHASED_USERS,
    round(count(distinct os.user_id) / (select count(*) from USER_2021),1) as PURCHASED_RATIO
from online_sale os inner join USER_2021 on os.user_id = USER_2021.user_id
group by year(sales_date), month(sales_date)
order by 1,2