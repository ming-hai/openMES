//>>built
define("dojox/embed/Flash",["dojo/_base/lang","dojo/_base/unload","dojo/_base/array","dojo/query","dojo/has","dojo/dom","dojo/on","dojo/window"],function(_1,_2,_3,_4,_5,_6,on,_7){
var _8,_9;
var _a=9;
var _b="dojox-embed-flash-",_c=0;
var _d={expressInstall:false,width:320,height:240,swLiveConnect:"true",allowScriptAccess:"sameDomain",allowNetworking:"all",style:null,redirect:null};
function _e(_f){
_f=_1.delegate(_d,_f);
if(!("path" in _f)){
console.error("dojox.embed.Flash(ctor):: no path reference to a Flash movie was provided.");
return null;
}
if(!("id" in _f)){
_f.id=(_b+_c++);
}
return _f;
};
if(_5("ie")){
_8=function(_10){
_10=_e(_10);
if(!_10){
return null;
}
var p;
var _11=_10.path;
if(_10.vars){
var a=[];
for(p in _10.vars){
a.push(p+"="+_10.vars[p]);
}
_10.params.FlashVars=a.join("&");
delete _10.vars;
}
var s="<object id=\""+_10.id+"\" "+"classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" "+"width=\""+_10.width+"\" "+"height=\""+_10.height+"\""+((_10.style)?" style=\""+_10.style+"\"":"")+">"+"<param name=\"movie\" value=\""+_11+"\" />";
if(_10.params){
for(p in _10.params){
s+="<param name=\""+p+"\" value=\""+_10.params[p]+"\" />";
}
}
s+="</object>";
return {id:_10.id,markup:s};
};
_9=(function(){
var _12=10,_13=null;
while(!_13&&_12>7){
try{
_13=new ActiveXObject("ShockwaveFlash.ShockwaveFlash."+_12--);
}
catch(e){
}
}
if(_13){
var v=_13.GetVariable("$version").split(" ")[1].split(",");
return {major:(v[0]!=null)?parseInt(v[0]):0,minor:(v[1]!=null)?parseInt(v[1]):0,rev:(v[2]!=null)?parseInt(v[2]):0};
}
return {major:0,minor:0,rev:0};
})();
_2.addOnWindowUnload(function(){
console.warn("***************UNLOAD");
var _14=function(){
};
var _15=_4("object").reverse().style("display","none").forEach(function(i){
for(var p in i){
if((p!="FlashVars")&&typeof i[p]=="function"){
try{
i[p]=_14;
}
catch(e){
}
}
}
});
});
}else{
_8=function(_16){
_16=_e(_16);
if(!_16){
return null;
}
var p;
var _17=_16.path;
if(_16.vars){
var a=[];
for(p in _16.vars){
a.push(p+"="+_16.vars[p]);
}
_16.params.flashVars=a.join("&");
delete _16.vars;
}
var s="<embed type=\"application/x-shockwave-flash\" "+"src=\""+_17+"\" "+"id=\""+_16.id+"\" "+"width=\""+_16.width+"\" "+"height=\""+_16.height+"\""+((_16.style)?" style=\""+_16.style+"\" ":"")+"pluginspage=\""+window.location.protocol+"//www.adobe.com/go/getflashplayer\" ";
if(_16.params){
for(p in _16.params){
s+=" "+p+"=\""+_16.params[p]+"\"";
}
}
s+=" />";
return {id:_16.id,markup:s};
};
_9=(function(){
var _18=navigator.plugins["Shockwave Flash"];
if(_18&&_18.description){
var v=_18.description.replace(/([a-zA-Z]|\s)+/,"").replace(/(\s+r|\s+b[0-9]+)/,".").split(".");
return {major:(v[0]!=null)?parseInt(v[0]):0,minor:(v[1]!=null)?parseInt(v[1]):0,rev:(v[2]!=null)?parseInt(v[2]):0};
}
return {major:0,minor:0,rev:0};
})();
}
var _19=function(_1a,_1b){
if(location.href.toLowerCase().indexOf("file://")>-1){
throw new Error("dojox.embed.Flash can't be run directly from a file. To instatiate the required SWF correctly it must be run from a server, like localHost.");
}
this.available=_9.major;
this.minimumVersion=_1a.minimumVersion||_a;
this.id=null;
this.movie=null;
this.domNode=null;
if(_1b){
_1b=_6.byId(_1b);
}
setTimeout(_1.hitch(this,function(){
if(_1a.expressInstall||this.available&&this.available>=this.minimumVersion){
if(_1a&&_1b){
this.init(_1a,_1b);
}else{
this.onError("embed.Flash was not provided with the proper arguments.");
}
}else{
if(!this.available){
this.onError("Flash is not installed.");
}else{
this.onError("Flash version detected: "+this.available+" is out of date. Minimum required: "+this.minimumVersion);
}
}
}),100);
};
_1.extend(_19,{onReady:function(_1c){
},onLoad:function(_1d){
},onError:function(msg){
},_onload:function(){
clearInterval(this._poller);
delete this._poller;
delete this._pollCount;
delete this._pollMax;
this.onLoad(this.movie);
},init:function(_1e,_1f){
this.destroy();
_1f=_6.byId(_1f||this.domNode);
if(!_1f){
throw new Error("dojox.embed.Flash: no domNode reference has been passed.");
}
var p=0,_20=false;
this._poller=null;
this._pollCount=0;
this._pollMax=15;
this.pollTime=100;
if(_19.initialized){
this.id=_19.place(_1e,_1f);
this.domNode=_1f;
setTimeout(_1.hitch(this,function(){
this.movie=this.byId(this.id,_1e.doc);
this.onReady(this.movie);
this._poller=setInterval(_1.hitch(this,function(){
try{
p=this.movie.PercentLoaded();
}
catch(e){
console.warn("this.movie.PercentLoaded() failed",e,this.movie);
}
if(p==100){
this._onload();
}else{
if(p==0&&this._pollCount++>this._pollMax){
clearInterval(this._poller);
throw new Error("Building SWF failed.");
}
}
}),this.pollTime);
}),1);
}
},_destroy:function(){
try{
this.domNode.removeChild(this.movie);
}
catch(e){
}
this.id=this.movie=this.domNode=null;
},destroy:function(){
if(!this.movie){
return;
}
var _21=_1.delegate({id:true,movie:true,domNode:true,onReady:true,onLoad:true});
for(var p in this){
if(!_21[p]){
delete this[p];
}
}
if(this._poller){
on(this,"Load",this,"_destroy");
}else{
this._destroy();
}
},byId:function(_22,doc){
doc=doc||document;
if(doc.embeds[_22]){
return doc.embeds[_22];
}
if(doc[_22]){
return doc[_22];
}
if(window[_22]){
return window[_22];
}
if(document[_22]){
return document[_22];
}
return null;
}});
_1.mixin(_19,{minSupported:8,available:_9.major,supported:(_9.major>=_9.required),minimumRequired:_9.required,version:_9,initialized:false,onInitialize:function(){
_19.initialized=true;
},__ie_markup__:function(_23){
return _8(_23);
},proxy:function(obj,_24){
_3.forEach((_24 instanceof Array?_24:[_24]),function(_25){
this[_25]=_1.hitch(this,function(){
return (function(){
return eval(this.movie.CallFunction("<invoke name=\""+_25+"\" returntype=\"javascript\">"+"<arguments>"+_3.map(arguments,function(_26){
return __flash__toXML(_26);
}).join("")+"</arguments>"+"</invoke>"));
}).apply(this,arguments||[]);
});
},obj);
}});
_19.place=function(_27,_28){
var o=_8(_27);
_28=_6.byId(_28);
if(!_28){
_28=_7.doc.createElement("div");
_28.id=o.id+"-container";
_7.body().appendChild(_28);
}
if(o){
_28.innerHTML=o.markup;
return o.id;
}
return null;
};
_19.onInitialize();
_1.setObject("dojox.embed.Flash",_19);
return _19;
});
