
	/* var record={kor:30, eng:70, math:80}; */
	/* alert(record.kor+record.eng); */
	/* var lottos=[5,[2,3],"hello",10,21];
	 alert(lottos[1][0]); */
	/* window.alert("32">"4"); */
	/* var x,y;
	 x=prompt("x의 값을 입력하세요", 0);
	 y=prompt("y의 값을 입력하세요", 0);
	 alert(typeof x);
	 x=parseInt(x);
	 y=parseInt(y);
	 alert(x+y); */

	/*  var ar=["철수","영희","선희","소윤"]

	 for(var i in ar)
	 alert(ar[i]);  */

	/* var m = {name:"선희", age:13};
	 for(var f in m)
	 alert(m[f]); */

	/* (var x = (function(a,b){
	 return a+b;
	 })(3,4,5);
	
	 alert(x); */

	/* function add(a,b){
	
	 arguments lengths;
	 return arguments[0]+arguments[1];
	 }
	 var sum=add(2,3,5);
	 alert(sum); */

	/* alert(a);

	 a=1; */

	/* var a=1;
	 var a=2;

	 alert(a); */

	/* alert(a);

	 {var a=1;} */

/* 	function f1() {
		 a = 1;
		f2();

		function f2() {
			 a = 2;
			f3();

			function f3() {
				 a = 3;
			}
		}

	}

	f1();
	alert(a); */
	
/*	function printResult(){
		 var x,y;
		 x=prompt("x의 값을 입력하세요", 0);
		 y=prompt("y의 값을 입력하세요", 0);
		 alert(typeof x);
		 x=parseInt(x);
		 y=parseInt(y);
		 alert(x+y);
		
	}
	
	function init(){var btn1 = document.getElementById("a"); 		
	btn1.onclick=printResult;}
	
	
	window.onload = init;*/

/*
function init(){}
function printResult(){}

window.addEventListener("load", function(){alert("test1");});
window.addEventListener("load", function(){alert("test2");});
window.addEventListener("load", function(){alert("test3");});*/
/*window.addEventListener("load", init);
window.addEventListener("load", init);*/
/*window.addEventListener("load", init);*/



	function f1() {
		 a = 1;
		f2();

		function f2() {
			 g = 2;
			f3();

			function f3() {
				 d = 3;
				 b = 2;
			}
		}

	}

	f1();
	alert(a);
	alert(g);
	alert(d);
	alert(b);
	
	
