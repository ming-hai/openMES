//>>built
define("dojox/layout/ResizeHandle",["dojo/_base/kernel","dojo/_base/lang","dojo/_base/connect","dojo/_base/array","dojo/_base/event","dojo/_base/fx","dojo/_base/window","dojo/fx","dojo/dom","dojo/dom-class","dojo/dom-geometry","dojo/dom-style","dijit/_base/manager","dijit/_Widget","dijit/_TemplatedMixin","dojo/_base/declare"],function(_1,_2,_3,_4,_5,_6,_7,_8,_9,_a,_b,_c,_d,_e,_f,_10){
_1.experimental("dojox.layout.ResizeHandle");
var _11=_10("dojox.layout._ResizeHelper",_e,{show:function(){
_c.set(this.domNode,"display","");
},hide:function(){
_c.set(this.domNode,"display","none");
},resize:function(dim){
_b.setMarginBox(this.domNode,dim);
}});
var _12=_10("dojox.layout.ResizeHandle",[_e,_f],{targetId:"",targetContainer:null,resizeAxis:"xy",activeResize:false,activeResizeClass:"dojoxResizeHandleClone",animateSizing:true,animateMethod:"chain",animateDuration:225,minHeight:100,minWidth:100,constrainMax:false,maxHeight:0,maxWidth:0,fixedAspect:false,intermediateChanges:false,startTopic:"/dojo/resize/start",endTopic:"/dojo/resize/stop",templateString:"<div dojoAttachPoint=\"resizeHandle\" class=\"dojoxResizeHandle\"><div></div></div>",postCreate:function(){
this.connect(this.resizeHandle,"onmousedown","_beginSizing");
if(!this.activeResize){
this._resizeHelper=_d.byId("dojoxGlobalResizeHelper");
if(!this._resizeHelper){
this._resizeHelper=new _11({id:"dojoxGlobalResizeHelper"}).placeAt(_7.body());
_a.add(this._resizeHelper.domNode,this.activeResizeClass);
}
}else{
this.animateSizing=false;
}
if(!this.minSize){
this.minSize={w:this.minWidth,h:this.minHeight};
}
if(this.constrainMax){
this.maxSize={w:this.maxWidth,h:this.maxHeight};
}
this._resizeX=this._resizeY=false;
var _13=_2.partial(_a.add,this.resizeHandle);
switch(this.resizeAxis.toLowerCase()){
case "xy":
this._resizeX=this._resizeY=true;
_13("dojoxResizeNW");
break;
case "x":
this._resizeX=true;
_13("dojoxResizeW");
break;
case "y":
this._resizeY=true;
_13("dojoxResizeN");
break;
}
},_beginSizing:function(e){
if(this._isSizing){
return;
}
_3.publish(this.startTopic,[this]);
this.targetWidget=_d.byId(this.targetId);
this.targetDomNode=this.targetWidget?this.targetWidget.domNode:_9.byId(this.targetId);
if(this.targetContainer){
this.targetDomNode=this.targetContainer;
}
if(!this.targetDomNode){
return;
}
if(!this.activeResize){
var c=_b.position(this.targetDomNode,true);
this._resizeHelper.resize({l:c.x,t:c.y,w:c.w,h:c.h});
this._resizeHelper.show();
if(!this.isLeftToRight()){
this._resizeHelper.startPosition={l:c.x,t:c.y};
}
}
this._isSizing=true;
this.startPoint={x:e.clientX,y:e.clientY};
var _14=_c.getComputedStyle(this.targetDomNode),_15=_b.boxModel==="border-model",_16=_15?{w:0,h:0}:_b.getPadBorderExtents(this.targetDomNode,_14),_17=_b.getMarginExtents(this.targetDomNode,_14);
this.startSize={w:_c.get(this.targetDomNode,"width",_14),h:_c.get(this.targetDomNode,"height",_14),pbw:_16.w,pbh:_16.h,mw:_17.w,mh:_17.h};
if(!this.isLeftToRight()&&_c.get(this.targetDomNode,"position")=="absolute"){
var p=_b.position(this.targetDomNode,true);
this.startPosition={l:p.x,t:p.y};
}
this._pconnects=[_3.connect(_7.doc,"onmousemove",this,"_updateSizing"),_3.connect(_7.doc,"onmouseup",this,"_endSizing")];
_5.stop(e);
},_updateSizing:function(e){
if(this.activeResize){
this._changeSizing(e);
}else{
var tmp=this._getNewCoords(e,"border",this._resizeHelper.startPosition);
if(tmp===false){
return;
}
this._resizeHelper.resize(tmp);
}
e.preventDefault();
},_getNewCoords:function(e,box,_18){
try{
if(!e.clientX||!e.clientY){
return false;
}
}
catch(err){
return false;
}
this._activeResizeLastEvent=e;
var dx=(this.isLeftToRight()?1:-1)*(this.startPoint.x-e.clientX),dy=this.startPoint.y-e.clientY,_19=this.startSize.w-(this._resizeX?dx:0),_1a=this.startSize.h-(this._resizeY?dy:0),r=this._checkConstraints(_19,_1a);
_18=(_18||this.startPosition);
if(_18&&this._resizeX){
r.l=_18.l+dx;
if(r.w!=_19){
r.l+=(_19-r.w);
}
r.t=_18.t;
}
switch(box){
case "margin":
r.w+=this.startSize.mw;
r.h+=this.startSize.mh;
case "border":
r.w+=this.startSize.pbw;
r.h+=this.startSize.pbh;
break;
}
return r;
},_checkConstraints:function(_1b,_1c){
if(this.minSize){
var tm=this.minSize;
if(_1b<tm.w){
_1b=tm.w;
}
if(_1c<tm.h){
_1c=tm.h;
}
}
if(this.constrainMax&&this.maxSize){
var ms=this.maxSize;
if(_1b>ms.w){
_1b=ms.w;
}
if(_1c>ms.h){
_1c=ms.h;
}
}
if(this.fixedAspect){
var w=this.startSize.w,h=this.startSize.h,_1d=w*_1c-h*_1b;
if(_1d<0){
_1b=_1c*w/h;
}else{
if(_1d>0){
_1c=_1b*h/w;
}
}
}
return {w:_1b,h:_1c};
},_changeSizing:function(e){
var _1e=this.targetWidget&&_2.isFunction(this.targetWidget.resize),tmp=this._getNewCoords(e,_1e&&"margin");
if(tmp===false){
return;
}
if(_1e){
this.targetWidget.resize(tmp);
}else{
if(this.animateSizing){
var _1f=_8[this.animateMethod]([_6.animateProperty({node:this.targetDomNode,properties:{width:{start:this.startSize.w,end:tmp.w}},duration:this.animateDuration}),_6.animateProperty({node:this.targetDomNode,properties:{height:{start:this.startSize.h,end:tmp.h}},duration:this.animateDuration})]);
_1f.play();
}else{
_c.set(this.targetDomNode,{width:tmp.w+"px",height:tmp.h+"px"});
}
}
if(this.intermediateChanges){
this.onResize(e);
}
},_endSizing:function(e){
_4.forEach(this._pconnects,_3.disconnect);
var pub=_2.partial(_3.publish,this.endTopic,[this]);
if(!this.activeResize){
this._resizeHelper.hide();
this._changeSizing(e);
setTimeout(pub,this.animateDuration+15);
}else{
pub();
}
this._isSizing=false;
this.onResize(e);
},onResize:function(e){
}});
return _12;
});
