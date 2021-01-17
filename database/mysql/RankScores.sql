SELECT s1.Score, COUNT(s2.Score) AS 'Rank' 
FROM Scores AS s1,
(SELECT DISTINCT Score FROM Scores) AS s2
WHERE s1.Score <= s2.Score
GROUP BY s1.Id 
ORDER BY s1.Score DESC;


# See https://leetcode.com/problems/rank-scores/discuss/456610/MySQL-Two-Simple-Solutions-and-Explanations-for-Beginners
