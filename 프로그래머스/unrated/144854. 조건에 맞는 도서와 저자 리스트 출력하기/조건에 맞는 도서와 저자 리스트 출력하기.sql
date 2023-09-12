SELECT BOOK_ID, AUTHOR_NAME, date_format(PUBLISHED_DATE, "%Y-%m-%d") as PUBLISHED_DATE
from BOOK B left join AUTHOR A on B.AUTHOR_ID = A.AUTHOR_ID
where B.CATEGORY like "경제"
order by B.PUBLISHED_DATE asc;