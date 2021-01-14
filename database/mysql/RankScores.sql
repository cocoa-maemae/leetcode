SELECT s.Score, COUNT(s2.Score) AS 'Rank' 
FROM Scores s,
(SELECT DISTINCT Score FROM Scores) s2
WHERE s.Score <= s2.Score
GROUP BY s.Id 
ORDER BY s.Score DESC;


# See https://leetcode.com/problems/rank-scores/discuss/456610/MySQL-Two-Simple-Solutions-and-Explanations-for-Beginners
