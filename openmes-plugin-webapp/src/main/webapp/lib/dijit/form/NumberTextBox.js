//>>built
define("dijit/form/NumberTextBox",["dojo/_base/declare","dojo/_base/lang","dojo/i18n","dojo/string","dojo/number","./RangeBoundTextBox"],function(_1,_2,_3,_4,_5,_6){
var _7=function(_8){
var _8=_8||{},_9=_3.getLocalization("dojo.cldr","number",_3.normalizeLocale(_8.locale)),_a=_8.pattern?_8.pattern:_9[(_8.type||"decimal")+"Format"],_b=typeof _8.places=="number",_c=_b?_8.places:(_a.indexOf(".")!=-1?_a.split(".")[1].replace(/[^#0]/g,"").length:0);
return {sep:_9.decimal,places:_c};
};
var _d=_1("dijit.form.NumberTextBoxMixin",null,{pattern:function(_e){
return "("+(this.focused&&this.editOptions?this._regExpGenerator(_2.delegate(_e,this.editOptions))+"|":"")+this._regExpGenerator(_e)+")";
},value:NaN,editOptions:{pattern:"#.######"},_formatter:_5.format,_regExpGenerator:_5.regexp,_decimalInfo:_7(),postMixInProperties:function(){
this.inherited(arguments);
this._set("type","text");
},_setConstraintsAttr:function(_f){
var _10=typeof _f.places=="number"?_f.places:0;
if(_10){
_10++;
}
if(typeof _f.max!="number"){
_f.max=9*Math.pow(10,15-_10);
}
if(typeof _f.min!="number"){
_f.min=-9*Math.pow(10,15-_10);
}
this.inherited(arguments,[_f]);
if(this.focusNode&&this.focusNode.value&&!isNaN(this.value)){
this.set("value",this.value);
}
this._decimalInfo=_7(_f);
},_onFocus:function(){
if(this.disabled||this.readOnly){
return;
}
var val=this.get("value");
if(typeof val=="number"&&!isNaN(val)){
var _11=this.format(val,this.constraints);
if(_11!==undefined){
this.textbox.value=_11;
}
}
this.inherited(arguments);
},format:function(_12,_13){
var _14=String(_12);
if(typeof _12!="number"){
return _14;
}
if(isNaN(_12)){
return "";
}
if(!("rangeCheck" in this&&this.rangeCheck(_12,_13))&&_13.exponent!==false&&/\de[-+]?\d/i.test(_14)){
return _14;
}
if(this.editOptions&&this.focused){
_13=_2.mixin({},_13,this.editOptions);
}
return this._formatter(_12,_13);
},_parser:_5.parse,parse:function(_15,_16){
var v=this._parser(_15,_2.mixin({},_16,(this.editOptions&&this.focused)?this.editOptions:{}));
if(this.editOptions&&this.focused&&isNaN(v)){
v=this._parser(_15,_16);
}
return v;
},_getDisplayedValueAttr:function(){
var v=this.inherited(arguments);
return isNaN(v)?this.textbox.value:v;
},filter:function(_17){
if(_17==null||typeof _17=="string"&&_17==""){
return NaN;
}else{
if(typeof _17=="number"&&!isNaN(_17)&&_17!=0){
_17=_5.round(_17,this._decimalInfo.places);
}
}
return this.inherited(arguments,[_17]);
},serialize:function(_18,_19){
return (typeof _18!="number"||isNaN(_18))?"":this.inherited(arguments);
},_setBlurValue:function(){
var val=_2.hitch(_2.delegate(this,{focused:true}),"get")("value");
this._setValueAttr(val,true);
},_setValueAttr:function(_1a,_1b,_1c){
if(_1a!==undefined&&_1c===undefined){
_1c=String(_1a);
if(typeof _1a=="number"){
if(isNaN(_1a)){
_1c="";
}else{
if(("rangeCheck" in this&&this.rangeCheck(_1a,this.constraints))||this.constraints.exponent===false||!/\de[-+]?\d/i.test(_1c)){
_1c=undefined;
}
}
}else{
if(!_1a){
_1c="";
_1a=NaN;
}else{
_1a=undefined;
}
}
}
this.inherited(arguments,[_1a,_1b,_1c]);
},_getValueAttr:function(){
var v=this.inherited(arguments);
if(isNaN(v)&&this.textbox.value!==""){
if(this.constraints.exponent!==false&&/\de[-+]?\d/i.test(this.textbox.value)&&(new RegExp("^"+_5._realNumberRegexp(_2.delegate(this.constraints))+"$").test(this.textbox.value))){
var n=Number(this.textbox.value);
return isNaN(n)?undefined:n;
}else{
return undefined;
}
}else{
return v;
}
},isValid:function(_1d){
if(!this.focused||this._isEmpty(this.textbox.value)){
return this.inherited(arguments);
}else{
var v=this.get("value");
if(!isNaN(v)&&this.rangeCheck(v,this.constraints)){
if(this.constraints.exponent!==false&&/\de[-+]?\d/i.test(this.textbox.value)){
return true;
}else{
return this.inherited(arguments);
}
}else{
return false;
}
}
},_isValidSubset:function(){
var _1e=(typeof this.constraints.min=="number"),_1f=(typeof this.constraints.max=="number"),_20=this.get("value");
if(isNaN(_20)||(!_1e&&!_1f)){
return this.inherited(arguments);
}
var _21=_20|0,_22=_20<0,_23=this.textbox.value.indexOf(this._decimalInfo.sep)!=-1,_24=this.maxLength||20,_25=_24-this.textbox.value.length,_26=_23?this.textbox.value.split(this._decimalInfo.sep)[1].replace(/[^0-9]/g,""):"";
var _27=_23?_21+"."+_26:_21+"";
var _28=_4.rep("9",_25),_29=_20,_2a=_20;
if(_22){
_29=Number(_27+_28);
}else{
_2a=Number(_27+_28);
}
return !((_1e&&_2a<this.constraints.min)||(_1f&&_29>this.constraints.max));
}});
var _2b=_1("dijit.form.NumberTextBox",[_6,_d],{baseClass:"dijitTextBox dijitNumberTextBox"});
_2b.Mixin=_d;
return _2b;
});
