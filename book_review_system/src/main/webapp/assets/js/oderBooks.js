$(document).ready(function() {
var x = document.getElementById('type').value;
$("div.slect option:selected").prop("selected",false);
$("div.slect option[value=" + x + "]")
        .prop("selected",true);
});