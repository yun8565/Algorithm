SELECT CATEGORY, sum(SALES) as TOTAL_SALES
from BOOK as B left join BOOK_SALES as S on B.BOOK_ID = S.BOOK_ID
where year(S.SALES_DATE) = 2022 and month(S.SALES_DATE) = 1
group by CATEGORY
order by CATEGORY asc;