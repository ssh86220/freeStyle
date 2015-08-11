
var win=null;

function btnResizeClick(){	
	//opener - open()함수를 통해서 뜬 녀석을말함.
/*	opener.resizeTo(100, 100);*/
	opener.resizeBy(100, 100);
	
}
function btnMoveClick(){
	/*opener.moveTo(300, 300);*/
	opener.moveBy(300, 300);

}
function btnOpenerCloseClick(){
	opener.close();
}

window.addEventListener("load", function(){
	var btnResize = document.getElementById("btn-resize");
	btnResize.onclick = btnResizeClick;
	var btnMove = document.getElementById("btn-move");
	btnMove.onclick = btnMoveClick;
	var btnOpenerClose = document.getElementById("btn-opener-close");
	btnOpenerClose.onclick = btnOpenerCloseClick;	
});


