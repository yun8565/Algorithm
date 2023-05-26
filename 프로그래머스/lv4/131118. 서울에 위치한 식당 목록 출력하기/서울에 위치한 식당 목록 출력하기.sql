SELECT A.REST_ID, A.REST_NAME, A.FOOD_TYPE, A.FAVORITES, A.ADDRESS, round(avg(B.REVIEW_SCORE),2) as SCORE
from REST_INFO as A join REST_REVIEW as B
on A.REST_ID = B.REST_ID
group by REST_ID
having A.ADDRESS like "서울%"
order by round(avg(B.REVIEW_SCORE),2) desc, A.FAVORITES desc;