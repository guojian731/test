/*表格鼠标附上高亮颜色*/
 $(function(){
	$('.List_table tr').mouseover(function(){
		$(this).addClass('tr_hover' );
	});
	$('.List_table tr').mouseout(function(){
		$(this).removeClass("tr_hover");								  								
	});
	
	$('.List_tbl tr').mouseover(function(){
		$(this).addClass('tr_hover' );
	});
	$('.List_tbl tr').mouseout(function(){
		$(this).removeClass("tr_hover");								  								
	});
});
 /*input type="checkbox" 样式*/
 $(function(){
	$(' input[type="checkbox"]').css({"vertical-align":"-2px","margin-right":"3px"});

	$("*[_price]").each(function(){
		var v = $.trim($(this).text());
		var r = CurrencyFormatted(v);
		r = CommaFormatted(r);
		$(this).text(r);
	});
 });

 
 /** 下面两个函数都能对浮点数进行四舍五入，保留小数点后两位 **/
 
 function CurrencyFormatted(amount) {
     var i = parseFloat(amount);
     if(isNaN(i)) { i = 0.00; }
     var minus = '';
     if(i < 0) { minus = '-'; }
     i = Math.abs(i);
     i = parseInt((i + .005) * 100);
     i = i / 100;
     s = new String(i);
     if(s.indexOf('.') < 0) { s += '.00'; }
     if(s.indexOf('.') == (s.length - 2)) { s += '0'; }
     s = minus + s;
     return s;
 }

 /** 每三位数字添加一个逗号，方便阅读 **/
 
 function CommaFormatted(amount) { 
     var delimiter = ","; // replace comma if desired
     amount = new String(amount);
     var a = amount.split('.',2);
     var d = a[1];
     var i = parseInt(a[0]);
     if(isNaN(i)) { return ''; }
     var minus = '';
     if(i < 0) { minus = '-'; }
     i = Math.abs(i);
     var n = new String(i);
     var a = [];
     while(n.length > 3)
     {
         var nn = n.substr(n.length-3);
         a.unshift(nn);
         n = n.substr(0,n.length-3);
     }
     if(n.length > 0) { a.unshift(n); }
     n = a.join(delimiter);
     if(d.length < 1) { amount = n; }
     else { amount = n + '.' + d; }
     amount = minus + amount;
     return amount;
 }
