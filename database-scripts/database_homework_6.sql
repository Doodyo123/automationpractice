CREATE VIEW FilmDetails AS 
SELECT actor.actor_id, actor.first_name, actor.last_name, film.film_id,film.title, film.description
FROM actor, film_actor, film
WHERE actor.last_name = 'FAWCETT'
AND actor.first_name = 'BOB';

Select * FROM FilmDetails;