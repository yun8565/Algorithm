SELECT BOOK_ID, date_format(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
from BOOK
where CATEGORY = '인문' and year(PUBLISHED_DATE) = 2021
order by PUBLISHED_DATE asc