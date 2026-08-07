# Write your MySQL query statement below
select distinct author_id as id from Views
where author_id = viewer_id 
ORDER by author_id;