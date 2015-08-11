function init() {
	var btnCountdown = document.getElementById("btn-countdown");
	btnCountdown.onclick = btnCountdownClick;
}

var timerID = null;

function count() {

	var IblCount = document.getElementById("Ibl-count");
	var count = parseInt(IblCount.innerText);

	if (count > 0)
		IblCount.innerText = --count;
	else {
		clearInterval(timerID);
		timerID = null;
	}

}

function btnCountdownClick() {

	/* count(); 바로호출 */
	// 1초후에 호출 1000ms
	/* setTimeout(count, 1000); 1초후 1번실행 */

	if (timerID == null)
		timerID = setInterval(count, 1000); // 1초마다 실행

}

window.onload = init;