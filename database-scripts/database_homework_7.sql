DELIMITER $$

CREATE PROCEDURE getInventory ()
BEGIN
	DECLARE filmName VARCHAR(20);
    DECLARE storeId INT;
    SET filmName = 'Alien Center';
    SET storeId = 2;
    
    SELECT inventory_id, title, store_id FROM sakila.film AS A
    LEFT JOIN sakila.inventory AS B
    ON B.film_id = A.film_id
	WHERE A.title = filmName
    AND B.store_id = storeId;
    
END;

call getInventory();