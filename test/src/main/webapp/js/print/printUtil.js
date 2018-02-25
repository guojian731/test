	var LODOP; //声明为全局变量  
	function CheckIsInstall() {	 
			try{ 
			     var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM')); 
				if ((LODOP!=null)&&(typeof(LODOP.VERSION)!="undefined")) alert("本机已成功安装过Lodop控件!\n  版本号:"+LODOP.VERSION); 
			 }catch(err){ 
				alert("本机未安装或需要升级!"); 
	 		 } 
	}; 
	
	
	function prn1_preview(id) {	
		CreateOneFormPage(id);	
		LODOP.PREVIEW();	
	};
	function prn1_print(id) {		
		CreateOneFormPage(id);
		LODOP.PRINT();	
	};
	function prn1_printA(id) {		
		CreateOneFormPage(id);
		LODOP.PRINTA(); 	
	};	
	function CreateOneFormPage(id){
		LODOP=getLodop();  
		LODOP.SET_PRINT_STYLE("FontSize",18);
		LODOP.SET_PRINT_STYLE("Bold",1);
		LODOP.ADD_PRINT_TEXT(50,231,260,39,"");
		LODOP.ADD_PRINT_HTM(88,200,350,600,document.getElementById("outinstattable").innerHTML);
	};
	
	function PreviewMytable(id){
		
		var LODOP=getLodop();  
		if(LODOP!=null){
		var strStyle="<style> table,td,th {border-collapse: collapse; border-style: solid;border-width:1px;border-color: black;text-align:center}</style>"
		LODOP.ADD_PRINT_TABLE(100,"5%","90%",450,strStyle+document.getElementById(id).innerHTML);
		LODOP.SET_SHOW_MODE("NP_NO_RESULT",true);
		LODOP.SET_PRINT_STYLEA(0,"Vorient",3);		
		LODOP.SET_PRINT_STYLEA(0,"LinkedItem",1);	    
		LODOP.NewPageA();
		LODOP.PREVIEW();
		}
	};	