function EQ_GET_DATA(){ 
	  var ret = {
"name": " prj_ingSW working set: {prj_ingSW}", "value":302, 
"prmetrics":{"5":1,"6":1,"7":1,"8":1,"9":1,"10":1,"11":1},
"prmetricvalues":{"5":0,"6":5,"7":0,"8":302,"9":8,"10":4,"11":42},
"children": [ {
"name": "controller", "value":17, 
"pmetrics":{"4":1,"12":1,"13":1,"14":1,"3":1,"1":1,"0":1,"6":1,"8":1,"2":1,"15":1,"16":1},
"pmetricvalues":{"4":1,"12":1,"13":0,"14":1,"3":1,"1":1,"0":1,"17":0.5,"6":1,"18":0.0,"8":17,"19":0.5,"2":1,"15":1,"16":8},
"children":[
{
"name": "Controller_Login","key": "k","value":17, 
"metrics":{"20":1,"21":1,"22":1,"23":1,"24":1,"25":1,"26":1,"0":1,"27":1,"28":1,"29":1,"30":1,"31":1,"32":1,"33":1,"34":1,"35":1,"36":1,"16":1,"37":1,"4":1,"8":1,"2":1,"3":1,"1":1},
"metricvalues":{"20":2,"21":1,"22":1,"23":0.0,"24":15,"25":0,"26":1,"0":1,"27":6,"28":11,"29":0.0,"30":0.0,"31":0,"32":0.556,"33":2,"34":7,"35":0,"36":0,"16":8,"37":0,"4":1,"8":17,"2":1,"3":1,"1":1}
}
]
},{
"name": "GUI", "value":277, 
"pmetrics":{"4":2,"12":1,"13":1,"14":1,"3":1,"1":1,"0":1,"6":1,"8":2,"2":1,"15":1,"16":1},
"pmetricvalues":{"4":2,"12":2,"13":0,"14":2,"3":1,"1":1,"0":1,"17":0.5,"6":2,"18":0.0,"8":277,"19":0.5,"2":1,"15":2,"16":39},
"children":[
{
"name": "jFrame_Login","key": "m","value":108, 
"metrics":{"20":1,"21":1,"22":1,"23":1,"24":2,"25":1,"26":3,"0":3,"27":1,"28":1,"29":5,"30":4,"31":1,"32":3,"33":1,"34":1,"35":1,"36":1,"16":1,"37":1,"4":2,"8":2,"2":1,"3":3,"1":3},
"metricvalues":{"20":2,"21":0,"22":10,"23":0.0,"24":97,"25":0,"26":6,"0":3,"27":19,"28":50,"29":0.948,"30":0.9,"31":0,"32":0.716,"33":0,"34":32,"35":0,"36":2,"16":19,"37":0,"4":2,"8":108,"2":1,"3":3,"1":3}
},
{
"name": "jFrame_Cantiere","key": "n","value":169, 
"metrics":{"20":1,"21":1,"22":1,"23":1,"24":2,"25":1,"26":3,"0":3,"27":1,"28":1,"29":5,"30":1,"31":1,"32":1,"33":1,"34":1,"35":1,"36":1,"16":1,"37":1,"4":2,"8":2,"2":1,"3":1,"1":3},
"metricvalues":{"20":2,"21":0,"22":19,"23":0.0,"24":149,"25":0,"26":6,"0":3,"27":7,"28":49,"29":1.0,"30":0.0,"31":0,"32":0.417,"33":0,"34":42,"35":1,"36":2,"16":14,"37":0,"4":2,"8":169,"2":1,"3":1,"1":3}
}
]
},{
"name": "main", "value":5, 
"pmetrics":{"4":1,"12":1,"13":1,"14":1,"3":1,"1":1,"0":1,"6":1,"8":1,"2":1,"15":1,"16":1},
"pmetricvalues":{"4":1,"12":1,"13":0,"14":1,"3":1,"1":1,"0":1,"17":0.0,"6":1,"18":0.0,"8":5,"19":1.0,"2":1,"15":0,"16":1},
"children":[
{
"name": "Main","key": "r","value":5, 
"metrics":{"20":1,"21":1,"22":1,"23":1,"24":1,"25":1,"26":1,"0":1,"27":1,"28":1,"29":1,"30":1,"31":1,"32":1,"33":1,"34":1,"35":1,"36":1,"16":1,"37":1,"4":1,"8":1,"2":1,"3":1,"1":1},
"metricvalues":{"20":2,"21":0,"22":0,"23":0.0,"24":4,"25":0,"26":1,"0":1,"27":0,"28":2,"29":0.0,"30":0.0,"31":0,"32":0.0,"33":2,"34":1,"35":1,"36":0,"16":1,"37":0,"4":1,"8":5,"2":1,"3":1,"1":1}
}
]
},{
"name": "group.prj_ingsw", "value":3, 
"pmetrics":{"4":1,"12":1,"13":1,"14":1,"3":1,"1":1,"0":1,"6":1,"8":1,"2":1,"15":1,"16":1},
"pmetricvalues":{"4":1,"12":0,"13":0,"14":1,"3":1,"1":1,"0":1,"17":0.0,"6":1,"18":0.0,"8":3,"19":1.0,"2":1,"15":0,"16":1},
"children":[
{
"name": "Prj_ingSW","key": "p","value":3, 
"metrics":{"20":1,"21":1,"22":1,"23":1,"24":1,"25":1,"26":1,"0":1,"27":1,"28":1,"29":1,"30":1,"31":1,"32":1,"33":1,"34":1,"35":1,"36":1,"16":1,"37":1,"4":1,"8":1,"2":1,"3":1,"1":1},
"metricvalues":{"20":0,"21":0,"22":0,"23":0.0,"24":2,"25":0,"26":1,"0":1,"27":0,"28":2,"29":0.0,"30":0.0,"31":0,"32":0.0,"33":0,"34":1,"35":1,"36":0,"16":1,"37":0,"4":1,"8":3,"2":1,"3":1,"1":1}
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
