SELECT concat("/home/grep/src/",F.BOARD_ID,"/",F.FILE_ID,F.FILE_NAME,F.FILE_EXT) as FILE_PATH
from USED_GOODS_FILE F join USED_GOODS_BOARD B on F.BOARD_ID = B.BOARD_ID
where B.VIEWS = (select max(VIEWS) from USED_GOODS_BOARD)
order by F.FILE_ID desc;