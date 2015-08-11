
var win=null;

function btnNewtabClick(){
	win = open("open2.html");
	
}
function btnNewWinClick(){
	win = open("open2.html", "_blank", "width=400px,height=300px")
}
function btnCloseWinClick(){
	/*close(); 현재창이 닫힘*/
	win.close(); //활성화된 창이 닫힘.
}

window.addEventListener("load", function(){
	var btnNewtab = document.getElementById("btn-new-tab");
	btnNewtab.onclick = btnNewtabClick;
	var btnNewWin = document.getElementById("btn-new-win");
	btnNewWin.onclick = btnNewWinClick;
	var btnCloseWin = document.getElementById("btn-close-win");
	btnCloseWin.onclick = btnCloseWinClick;	
});



