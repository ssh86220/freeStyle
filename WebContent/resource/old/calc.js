function init()
{
var btnSum = document.getElementById("btn-sum");
btnSum.onclick = btnSumClick;
}

function btnSumClick(){
	
	var x = document.getElementById("txt-x");
	var y = document.getElementById("txt-y");
	
/*	var sum = parseInt(x.value)+parseInt(y.value);
	
	document.getElementById("txt-sum").value = sum;*/
	

	var sum = document.getElementById("txt-sum");
	
	sum.value = x+y;
	
	
	alert(x.value);
	alert(y.value);
	alert(sum.value);
}

window.onload = init;