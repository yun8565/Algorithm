SELECT USER_ID, NICKNAME, sum(PRICE) as TOTAL_SALES
from USED_GOODS_BOARD as B left join USED_GOODS_USER as U on B.WRITER_ID = U.USER_ID
where STATUS = "DONE"
group by WRITER_ID
having sum(PRICE) >= 700000
order by sum(PRICE) asc;
