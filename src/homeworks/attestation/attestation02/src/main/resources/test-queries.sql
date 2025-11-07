-- Все покупатели
SELECT * FROM buyers;

-- Все продукты
SELECT * FROM products;

-- Все заказы
SELECT * FROM orders;

-- Инфо о заказах с именем покупателя и описанием продукта
SELECT o.id AS order_id,
       b.first_name || ' ' || b.last_name AS buyer_name,
       p.description AS product,
       o.count,
       o.cr_date
FROM orders o
JOIN buyers b ON o.buyer_id = b.id
JOIN products p ON o.product_id = p.id;

-- Продукты с количеством больше 10
SELECT * FROM products
WHERE count > 10;

-- Изменение цены продукта с id = 1
UPDATE products
SET price = 1300.00
WHERE id = 1;

-- Увеличение колисчетва товаров в заказе с id = 3
UPDATE orders
SET count = count + 2
WHERE id = 3;

-- Смена фамилии покупателя с id = 5
UPDATE buyers
SET last_name = 'Petrov'
WHERE id = 5;

-- Удаление покупателя с id = 10
DELETE FROM buyers
WHERE id = 10;

-- Удаление продукта с id = 7
DELETE FROM products
WHERE id = 7;

-- Удаление заказа с id = 4
DELETE FROM orders
WHERE id = 4;

-- Список заказов за последние 7 дней
SELECT * FROM orders
WHERE cr_date >= NOW() - INTERVAL '7 days'
ORDER BY cr_date DESC;

-- Сумма продуктов в заказах
SELECT p.description, SUM(o.count) AS total_ordered
FROM orders o
JOIN products p ON o.product_id = p.id
GROUP BY p.description
ORDER BY total_ordered DESC;