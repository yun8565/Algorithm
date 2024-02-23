select APNT_NO, PT_NAME, A.PT_NO, A.MCDP_CD, DR_NAME, APNT_YMD
from APPOINTMENT A left join PATIENT P on A.PT_NO = P.PT_NO
left join DOCTOR D on A.MDDR_ID = D.DR_ID
where year(APNT_YMD) = 2022 and month(APNT_YMD) = 4 and day(APNT_YMD) = 13 and A.MCDP_CD = 'CS' and APNT_CNCL_YN = 'N'
order by APNT_YMD asc;