/*document.getElementById("btn").onclick = function() {alert("hello")};*/

$('#tblItem>tr').on('click', function () {
    let code = $(this).children('td:eq(0)').text();
    let description = $(this).children('td:eq(1)').text();
    let qtyOnHand = $(this).children('td:eq(2)').text();
    let price = $(this).children('td:eq(3)').text();

    $('#code').val(code);
    $('#description').val(description);
    $('#qtyOnHand').val(qtyOnHand);
    $('#price').val(price);

});

$('#btn').on('click', function () {
   alert('hello')
});