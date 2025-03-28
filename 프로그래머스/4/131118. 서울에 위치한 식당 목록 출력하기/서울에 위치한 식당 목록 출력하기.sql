-- 코드를 입력하세요
# SELECT * FROM REST_INFO;
# SELECT * FROM REST_REVIEW;
# SELECT * FROM REST_INFO a JOIN REST_REVIEW b ON a.REST_ID = b.REST_ID;
# SELECT * FROM REST_INFO a JOIN REST_REVIEW b ON a.REST_ID = b.REST_ID WHERE SUBSTRING(ADDRESS, 1, 2) = "서울" GROUP BY A.REST_ID;
SELECT a.REST_ID, a.REST_NAME, a.FOOD_TYPE, a.FAVORITES, a.ADDRESS, ROUND(AVG(b.REVIEW_SCORE), 2) as SCORE FROM REST_INFO a JOIN REST_REVIEW b ON a.REST_ID = b.REST_ID WHERE SUBSTRING(ADDRESS, 1, 2) = "서울" GROUP BY a.REST_ID ORDER BY SCORE DESC, FAVORITES DESC;

# SELECT A.REST_ID, A.REST_NAME, A.FOOD_TYPE, A.FAVORITES, A.ADDRESS, B.SCORE 
# FROM REST_INFO A 
# JOIN 
# (SELECT REST_ID, ROUND(AVG(REVIEW_SCORE),2) AS SCORE FROM REST_REVIEW GROUP BY REST_ID) B
# ON A.REST_ID = B.REST_ID
# WHERE A.ADDRESS LIKE '서울%'
# ORDER BY B.SCORE DESC, A.FAVORITES DESC;