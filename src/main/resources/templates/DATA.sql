SELECT 	t2.year, t1.account_name as name, t1.account_no as accNo, T2.sumAmt
	   		FROM  	account AS t1,
	   		(
	   			(
	   				SELECT 	
	   		  			SUBSTRING(transaction_date, 1, 4) as year, account_no, SUM(price-fees) as sumAmt
	   				FROM 	
	   					transaction
	   				WHERE 	
	   					cancelyn = 'N' AND transaction_date LIKE '2018%'
	   				GROUP BY 
	   					  SUBSTRING(transaction_date, 1, 4), account_no
	   		        ORDER BY sumAmt DESC LIMIT 1
	   		    )
	   		    UNION
	   			( 
	   					SELECT 	
	   		  			SUBSTRING(transaction_date, 1, 4) as year, account_no, SUM(price-fees) as sumAmt
	   				FROM 	
	   					transaction
	   				WHERE 	
	   					cancelyn = 'N' AND transaction_date LIKE '201%'
	   				GROUP BY 
	   					  SUBSTRING(transaction_date, 1, 4), account_no
	   		        ORDER BY sumAmt DESC LIMIT 1
	   		    )
	   		) as t2
	   		WHERE t1.account_no = t2.account_no



SELECT     
    b.branch_code as brCode, c.branch_name as brName, sum(price-fees) as sumAmt
FROM 
    transaction a, account b, branch c
WHERE
    a.account_no = b.account_no  
    AND b.branch_code  = c.branch_code 
    AND a.cancelyn = 'N'
    AND a.transaction_date like '2018%'
GROUP BY 
    b.branch_code 
ORDER BY 
    sum(price-fees) DESC


UPDATE 
    account 
SET
    branch_code = 'A'
WHERE
   branch_code = 'B'





	 