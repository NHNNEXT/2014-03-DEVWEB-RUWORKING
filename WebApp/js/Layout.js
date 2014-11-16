document.addEventListener("DOMContentLoaded", function(){

    drawDonutGraphColorInfo();
}, false);

function drawDonutGraphColorInfo() {
    var donut = document.getElementById("chart_d");
    var field = document.querySelectorAll('.field_underbar');
    var length = field.length;
    for(var i = 0; i < length; i++)
    {
        [].forEach.call(field, function(field){
            var field_element = field.querySelectorAll('span');
            var length = field_element.length;
            for(var j = 0; j < length; j++)
            {
                field_element[j].innerHTML = document.getElementById("chart_d").querySelectorAll('.fields text')[j].innerHTML;
                field_element[j].style.backgroundColor = document.getElementById("chart_d").querySelectorAll('.fields rect')[j].getAttribute('fill');
            }
        }, false);
    }
}