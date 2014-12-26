;
(function(){
	document.addEventListener("DOMContentLoaded", function(){
		
		var url = "/GetLocalList.ruw";
		var request = new XMLHttpRequest();
		 request.open("GET", url, true);
		 request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		 
		 request.onreadystatechange=function(){
				 if(request.readyState == 4 && request.status == 200){
					 var result = request.responseText;
					 var local=[];
					 var percent=[];
	                 result = JSON.parse(result);
	                 
	                 console.log(result);
	                 
	                 for(var i in result[1]){
	                	 local.push([result[1][i].local]);
	                	 percent.push([result[1][i].percent]);
	                 }
	                 
	                 local.push(["제주도"]);
	                 percent.push(["0"]);	                 
	
	                 var options = {
						   	    'legend':{
					 				names:local
					 				},
						        'dataset': {
						            title: '국회의원 공약 이행률',
						            values: percent,
						            colorset: ['#0083CA', '#CC3333', '#CC3333','#0083CA','#0083CA','#CC3333','#0083CA','#0083CA','#CC3333','#CC3333','#0083CA','#0083CA','#CC3333','#CC3333','#0083CA'],
						            // fields: ['A', 'B', 'C'],
						            fields: [],
						            opacity:[0.3, 0.5, 0.7, 0.9]
						        },
						        'core_circle_value' : [result[0]],
						        'core_circle_radius':30,
						        'maxValue' : 100,
						        'increment' : 20,
						        'chartDiv': 'Nwagon',
						        'chartType': 'polar',
						        'chartSize': {width:700, height:400}
						    };
						    Nwagon.chart(options);				 }
			 }
			request.send();
		 
		
	},false);
	
})();