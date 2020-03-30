SELECT * FROM sakila.payment as A
LEFT JOIN sakila.customer as B
ON B.customer_id = A.customer_id
WHERE B.email = 'NANCY.THOMAS@sakilacustomer.org';