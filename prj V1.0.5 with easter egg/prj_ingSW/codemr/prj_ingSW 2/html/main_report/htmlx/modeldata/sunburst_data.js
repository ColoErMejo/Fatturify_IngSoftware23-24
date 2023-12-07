function EQ_GET_DATA(){ 
	  var ret = {
"name": " prj_ingSW", "value":270, 
"prmetrics":{"5":1,"6":1,"7":1,"8":1,"9":1,"10":1,"11":1},
"prmetricvalues":{"5":0,"6":4,"7":0,"8":270,"9":10,"10":1,"11":40},
"children": [ {
"name": "controller", "value":270, 
"pmetrics":{"4":2,"12":1,"13":1,"14":1,"3":1,"1":1,"0":1,"6":1,"8":2,"2":1,"15":1,"16":1},
"pmetricvalues":{"4":2,"12":4,"13":0,"14":4,"3":1,"1":1,"0":1,"17":0.0,"6":4,"18":0.0,"8":270,"19":1.0,"2":1,"15":0,"16":88},
"children":[
{
"name": "Controller_Principale","key": "m","value":69, 
"metrics":{"20":2,"21":1,"22":1,"23":1,"24":2,"25":1,"26":1,"0":2,"27":1,"28":1,"29":1,"30":3,"31":1,"32":2,"33":1,"34":1,"35":1,"36":2,"16":2,"37":1,"4":2,"8":2,"2":2,"3":2,"1":2},
"metricvalues":{"20":9,"21":0,"22":5,"23":0.0,"24":63,"25":0,"26":1,"0":2,"27":12,"28":42,"29":0.0,"30":0.775,"31":0,"32":0.667,"33":1,"34":40,"35":0,"36":8,"16":24,"37":0,"4":2,"8":69,"2":2,"3":2,"1":2}
},
{
"name": "Controller_Fattura","key": "n","value":6, 
"metrics":{"20":1,"21":1,"22":1,"23":1,"24":1,"25":1,"26":1,"0":1,"27":1,"28":1,"29":5,"30":1,"31":1,"32":1,"33":1,"34":1,"35":1,"36":1,"16":1,"37":1,"4":1,"8":1,"2":1,"3":1,"1":1},
"metricvalues":{"20":1,"21":0,"22":1,"23":0.0,"24":4,"25":0,"26":1,"0":1,"27":2,"28":2,"29":1.0,"30":0.0,"31":0,"32":0.333,"33":0,"34":0,"35":0,"36":1,"16":2,"37":0,"4":1,"8":6,"2":1,"3":1,"1":1}
},
{
"name": "Controller_Cantiere","key": "k","value":129, 
"metrics":{"20":2,"21":1,"22":1,"23":1,"24":2,"25":1,"26":1,"0":2,"27":1,"28":2,"29":1,"30":1,"31":1,"32":2,"33":1,"34":2,"35":1,"36":1,"16":2,"37":1,"4":2,"8":2,"2":2,"3":2,"1":2},
"metricvalues":{"20":7,"21":0,"22":2,"23":0.0,"24":126,"25":0,"26":1,"0":2,"27":19,"28":59,"29":0.0,"30":0.409,"31":0,"32":0.684,"33":2,"34":57,"35":0,"36":5,"16":42,"37":0,"4":2,"8":129,"2":2,"3":2,"1":2}
},
{
"name": "Controller_Login","key": "l","value":66, 
"metrics":{"20":2,"21":1,"22":1,"23":1,"24":2,"25":1,"26":1,"0":2,"27":1,"28":1,"29":1,"30":1,"31":1,"32":2,"33":1,"34":1,"35":1,"36":2,"16":1,"37":1,"4":2,"8":2,"2":2,"3":2,"1":1},
"metricvalues":{"20":7,"21":0,"22":2,"23":0.0,"24":63,"25":0,"26":1,"0":2,"27":7,"28":36,"29":0.0,"30":0.5,"31":0,"32":0.657,"33":1,"34":34,"35":0,"36":6,"16":20,"37":0,"4":2,"8":66,"2":2,"3":2,"1":1}
}
]
}]
 }
;
return ret;
}
var EQ_METRIC_MAP = {};
EQ_METRIC_MAP["C3"] =0;
EQ_METRIC_MAP["Complexity"] =1;
EQ_METRIC_MAP["Coupling"] =2;
EQ_METRIC_MAP["Lack of Cohesion"] =3;
EQ_METRIC_MAP["Size"] =4;
EQ_METRIC_MAP["Number of Highly Problematic Classes"] =5;
EQ_METRIC_MAP["Number of Entities"] =6;
EQ_METRIC_MAP["Number of Problematic Classes"] =7;
EQ_METRIC_MAP["Class Lines of Code"] =8;
EQ_METRIC_MAP["Number of External Packages"] =9;
EQ_METRIC_MAP["Number of Packages"] =10;
EQ_METRIC_MAP["Number of External Entities"] =11;
EQ_METRIC_MAP["Efferent Coupling"] =12;
EQ_METRIC_MAP["Number of Interfaces"] =13;
EQ_METRIC_MAP["Number of Classes"] =14;
EQ_METRIC_MAP["Afferent Coupling"] =15;
EQ_METRIC_MAP["Weighted Method Count"] =16;
EQ_METRIC_MAP["Normalized Distance"] =17;
EQ_METRIC_MAP["Abstractness"] =18;
EQ_METRIC_MAP["Instability"] =19;
EQ_METRIC_MAP["Coupling Between Object Classes"] =20;
EQ_METRIC_MAP["Access to Foreign Data"] =21;
EQ_METRIC_MAP["Number of Fields"] =22;
EQ_METRIC_MAP["Specialization Index"] =23;
EQ_METRIC_MAP["Class-Methods Lines of Code"] =24;
EQ_METRIC_MAP["Number of Children"] =25;
EQ_METRIC_MAP["Depth of Inheritance Tree"] =26;
EQ_METRIC_MAP["Number of Methods"] =27;
EQ_METRIC_MAP["Response For a Class"] =28;
EQ_METRIC_MAP["Lack of Tight Class Cohesion"] =29;
EQ_METRIC_MAP["Lack of Cohesion of Methods"] =30;
EQ_METRIC_MAP["Number of Static Fields"] =31;
EQ_METRIC_MAP["Lack of Cohesion Among Methods(1-CAM)"] =32;
EQ_METRIC_MAP["CBO App"] =33;
EQ_METRIC_MAP["Simple Response For a Class"] =34;
EQ_METRIC_MAP["Number of Static Methods"] =35;
EQ_METRIC_MAP["CBO Lib"] =36;
EQ_METRIC_MAP["Number of Overridden Methods"] =37;
var EQ_SELECTED_CLASS_METRIC 		= "C3";
var EQ_SELECTED_PACKAGE_METRIC 	= "C3";
var EQ_SELECTED_PROJECT_METRIC 	= "Class Lines of Code";
var EQ_CLASS_METRIC_INDEX 	= EQ_METRIC_MAP[EQ_SELECTED_CLASS_METRIC];
var EQ_PACKAGE_METRIC_INDEX	= EQ_METRIC_MAP[EQ_SELECTED_PACKAGE_METRIC];
var EQ_PROJECT_METRIC_INDEX 	= EQ_METRIC_MAP[EQ_SELECTED_PROJECT_METRIC];
var EQ_COLOR_OF_LEVELS = ["#1F77B4","#007F24","#62BF18","#FFC800","#FF5B13","#E50000"];
var EQ_CLASS_METRICS = ["C3","Complexity","Coupling","Lack of Cohesion","Size","Class Lines of Code","Weighted Method Count","Coupling Between Object Classes","Access to Foreign Data","Number of Fields","Specialization Index","Class-Methods Lines of Code","Number of Children","Depth of Inheritance Tree","Number of Methods","Response For a Class","Lack of Tight Class Cohesion","Lack of Cohesion of Methods","Number of Static Fields","Lack of Cohesion Among Methods(1-CAM)","CBO App","Simple Response For a Class","Number of Static Methods","CBO Lib","Number of Overridden Methods"];
var EQ_PACKAGE_METRICS = ["C3","Complexity","Coupling","Lack of Cohesion","Size","Number of Entities","Class Lines of Code","Efferent Coupling","Number of Interfaces","Number of Classes","Afferent Coupling","Weighted Method Count","Normalized Distance","Abstractness","Instability"];
var EQ_PROJECT_METRICS = ["Number of Highly Problematic Classes","Number of Entities","Number of Problematic Classes","Class Lines of Code","Number of External Packages","Number of Packages","Number of External Entities"];
function EQ_GET_COLOR(d) {
if(d.metrics)
return EQ_COLOR_OF_LEVELS[d.metrics[EQ_CLASS_METRIC_INDEX]];
if(d.pmetrics)
return EQ_COLOR_OF_LEVELS[d.pmetrics[EQ_PACKAGE_METRIC_INDEX]];
if(d.prmetrics)
return EQ_COLOR_OF_LEVELS[d.prmetrics[EQ_PROJECT_METRIC_INDEX]];
return EQ_COLOR_OF_LEVELS[0];
}
