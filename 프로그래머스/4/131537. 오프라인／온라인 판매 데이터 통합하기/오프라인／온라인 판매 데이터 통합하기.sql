with OS as (
    select date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT 
    from ONLINE_SALE 
    where month(SALES_DATE) = 3),
OFS as (
    select date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, null, SALES_AMOUNT 
    from OFFLINE_SALE 
    where month(SALES_DATE) = 3)

select * from OS union all 
select * from OFS
order by SALES_DATE, PRODUCT_ID, USER_ID