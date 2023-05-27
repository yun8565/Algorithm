SELECT MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE, "%Y-%m-%d") as REVIEW_DATE
from MEMBER_PROFILE as P left join REST_REVIEW as R on P.MEMBER_ID = R.MEMBER_ID
where R.MEMBER_ID = (select MEMBER_ID from REST_REVIEW group by MEMBER_ID order by count(REVIEW_SCORE) desc limit 1)
order by REVIEW_DATE asc, REVIEW_TEXT asc;