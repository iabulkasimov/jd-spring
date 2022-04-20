EXPLAIN ANALYZE
select*
from towns
where name='988663e37a40734305c38e4f5f2631fc';


create index idx_towns_name on towns(name);
DROP INDEX IF EXISTS idx_towns_name;


EXPLAIN ANALYZE
select*
from towns
where id='116';

SELECT
    tablename,
    indexname,
    indexdef
FROM
    pg_indexes
WHERE
        schemaname = 'public'
ORDER BY
    tablename,
    indexname;