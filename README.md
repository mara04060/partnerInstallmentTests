<h1>Задание:</h1>
<strong>Позитивный кейс</strong>
1 шаг. Создать заказ, используя метод createOrder, используя данные из описания (изменить orderId)
- Проверить выходные данные успешного ответа
2 шаг. Проверить статус заказа методом getOrder
- Сравнить выходные данные с данными, использованными при создании заказа
- Заказ должен иметь статус INST_ALLOWED_OK
3 шаг. Отменить заказ, вызвав метод cancelOrder
- Сравнить статус код и текст статуса успешного ответа (пример 4)

<strong>Негативные кейсы</strong>
Написать несколько негативных сценариев, используя документацию

<strong>Задание *<strong>
<br />
<br />Используя методы библиотеки Jackson JSON разобрать json в POJO (все переменные класса должны быть в camelCase)
<br />
<br />"{"isCardAccount"
,"data":{"order_id":"p100","message_id":"EB4BFBBCA7167857E0539B5A8F0ACB76"},"isRevaluation"
,"userId":20069,"userLogin":"55555F3","docIds":[597405],"locale":"UA"}"
<br />
<br />
"[{"isCard"
,"userPass":"test","userLogin":"55555F3","locale":"UA"},{"isCard"
,"userPass":"test","userLogin":"11111F3","locale":"UK"}]"
<p />При выполнении задания использовать библиотеки: RestAssured, Jackson JSON
