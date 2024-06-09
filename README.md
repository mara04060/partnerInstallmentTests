<html>
<body><h1>Задание:</h1>
<h3>Позитивный кейс</h3>
<font size=4pt>
<p>
<br />1 шаг. Создать заказ, используя метод createOrder, используя данные из описания (изменить orderId)
<br /> - Проверить выходные данные успешного ответа
<br />2 шаг. Проверить статус заказа методом getOrder
<br /> - Сравнить выходные данные с данными, использованными при создании заказа
<br /> - Заказ должен иметь статус INST_ALLOWED_OK
<br />3 шаг. Отменить заказ, вызвав метод cancelOrder
<br />- Сравнить статус код и текст статуса успешного ответа (пример 4)
</p>
<h3>Негативные кейсы</h3>
<br />Написать несколько негативных сценариев, используя документацию
</font>
<h2>Задание * <h2>
<font size=4pt>
<br />Используя методы библиотеки Jackson JSON разобрать json в POJO (все переменные класса должны быть в camelCase)
<p/>
<code>"{"isCardAccount"
,"data":{"order_id":"p100","message_id":"EB4BFBBCA7167857E0539B5A8F0ACB76"},"isRevaluation"
,"userId":20069,"userLogin":"55555F3","docIds":[597405],"locale":"UA"}"
</code>
<p>Вариант 2
</p>
<br />
<code>"[{"isCard"
,"userPass":"test","userLogin":"55555F3","locale":"UA"},{"isCard"
,"userPass":"test","userLogin":"11111F3","locale":"UK"}]"</code>
<p />При выполнении задания использовать библиотеки: RestAssured, Jackson JSON</p>
<h2>Решение</h2>
  <p>

    Решение Первой задачи находиться в тестах: OrderAllTest <b>partnerInstallment\src\test\java\task2</b>
<br />В качестве негативныхсценариев были выбранны методы:
    <br /> - <b>createOrder</b> при некорректном названии партнера
    <br /> - <b>getOrder</b> Без передачи индентификатора IDS
    <br /> - <b>getOrder</b> Без передачи индентификатора MESSAGE_ID
    <br /> - <b>confirmOrder</b> Без передачи состояния заказа - Невозможно обработать REQUEST_NOT_MATCH
     </p>
   <p> Решение задачи по парсингу JSON находиться в MainParser <b>partnerInstallment\src\main\java\task2</b></p>
 
</body>
</html>
