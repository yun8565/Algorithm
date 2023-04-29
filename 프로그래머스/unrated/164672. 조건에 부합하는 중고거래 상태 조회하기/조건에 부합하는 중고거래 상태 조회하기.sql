SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, 
    CASE 
        when STATUS = "DONE" then "거래완료"
        when STATUS = "RESERVED" then "예약중"
        else "판매중"
    END as STATUS
from USED_GOODS_BOARD
where CREATED_DATE = "2022-10-05"
order by BOARD_ID DESC;