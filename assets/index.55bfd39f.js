import{g as E,d as T,u as I,c as N}from"./ingredients.76045c10.js";import{_ as R}from"./index.6d8fab14.js";import{l as j,r as i,n as F,o as C,c as B,p as M,e as u,a as e,w as s,F as U,f as p,E as $,x as A,m as _,b as G,g as w}from"./vendor.c1fe1bd0.js";const H=p("\u7F16\u8F91"),J=p("\u5220\u9664"),K={emits:["update"],setup(D,{expose:g,emit:d}){const t=j({lists:[],currentPage:1,pageSize:10,total:0,loading:!0}),m=()=>{t.currentPage=1,f()},f=()=>{E({name:"",currentPage:t.currentPage,pageSize:t.pageSize}).then(a=>{const{list:r,pagination:{total:c}}=a;t.lists=r,t.total=c,t.loading=!1})};m();const v=({id:a,name:r})=>{$.confirm(`\u60A8\u786E\u5B9A\u8981\u5220\u9664${r}\u5417\uFF1F`,"\u8B66\u544A",{confirmButtonText:"\u786E\u8BA4",cancelButtonText:"\u53D6\u6D88",type:"\u8B66\u544A"}).then(()=>{T(a).then(()=>{A({message:"\u5220\u9664\u6210\u529F\uFF01",type:"success"}),m()})})};return g({initData:m}),(a,r)=>{const c=i("el-table-column"),b=i("el-button"),V=i("el-table"),x=F("loading");return C(),B(U,null,[M(e(V,{data:u(t).lists,stripe:"",style:{width:"100%"}},{default:s(()=>[e(c,{prop:"name",label:"\u98DF\u6750\u540D\u79F0",width:"180",align:"center"}),e(c,{prop:"price",label:"\u98DF\u6750\u4EF7\u683C",width:"180",align:"center"}),e(c,{prop:"remark",label:"\u5907\u6CE8",align:"center"}),e(c,{label:"\u64CD\u4F5C",align:"center"},{default:s(({row:n})=>[e(b,{type:"primary",size:"mini",onClick:o=>d("update",n)},{default:s(()=>[H]),_:2},1032,["onClick"]),e(b,{type:"danger",size:"mini",onClick:o=>v(n)},{default:s(()=>[J]),_:2},1032,["onClick"])]),_:1})]),_:1},8,["data"]),[[x,u(t).loading]]),e(R,{page:u(t).currentPage,"onUpdate:page":r[0]||(r[0]=n=>u(t).currentPage=n),size:u(t).pageSize,"onUpdate:size":r[1]||(r[1]=n=>u(t).pageSize=n),total:u(t).total,onPagination:f},null,8,["page","size","total"])],64)}}},L={class:"control"},O=p("\u65B0\u589E\u98DF\u6750"),Q={class:"dialog-footer"},W=p("\u53D6\u6D88"),X=p("\u786E\u5B9A"),te={setup(D){const g=_(null),d=_(!1),t=_(!1),m=G(()=>t.value?"\u7F16\u8F91\u98DF\u6750":"\u65B0\u589E\u98DF\u6750"),f=n=>{$.confirm("\u60A8\u786E\u5B9A\u8981\u53D6\u6D88\u6DFB\u52A0\u98DF\u6750\u5417\uFF1F",{confirmButtonText:"\u786E\u5B9A",cancelButtonText:"\u53D6\u6D88"}).then(()=>{n()}).catch(()=>{})},v=_(null),a=_({name:"",price:0,remark:""}),r={name:[{required:!0,message:"\u8BF7\u8F93\u5165\u98DF\u6750\u540D\u79F0",trigger:"blur"}],price:[{required:!0,message:"\u8BF7\u8F93\u5165\u98DF\u6750\u4EF7\u683C",trigger:"blur"}],remark:[{required:!0,message:"\u8BF7\u8F93\u5165\u5907\u6CE8",trigger:"blur"}]},c=()=>{a.value={name:"",price:0,remark:""}},b=()=>{c(),t.value=!1,d.value=!0},V=n=>{t.value=!0,a.value=n,d.value=!0},x=()=>{g.value.validate(n=>{n&&(t.value?I:N)(u(a)).then(k=>{d.value=!1,v.value.initData()})})};return(n,o)=>{const k=i("el-button"),z=i("el-input"),h=i("el-form-item"),P=i("el-input-number"),S=i("el-form"),q=i("el-dialog");return C(),B(U,null,[w("div",L,[e(k,{type:"primary",onClick:b},{default:s(()=>[O]),_:1})]),e(K,{ref:(l,y)=>{y.tableRef=l,v.value=l},onUpdate:V},null,512),e(q,{modelValue:d.value,"onUpdate:modelValue":o[4]||(o[4]=l=>d.value=l),title:u(m),width:"500px","before-close":f},{footer:s(()=>[w("span",Q,[e(k,{onClick:o[3]||(o[3]=l=>d.value=!1)},{default:s(()=>[W]),_:1}),e(k,{type:"primary",onClick:x},{default:s(()=>[X]),_:1})])]),default:s(()=>[e(S,{ref:(l,y)=>{y.formRef=l,g.value=l},model:a.value,rules:r,"label-width":"120px"},{default:s(()=>[e(h,{label:"\u98DF\u6750\u540D\u79F0",prop:"name"},{default:s(()=>[e(z,{modelValue:a.value.name,"onUpdate:modelValue":o[0]||(o[0]=l=>a.value.name=l)},null,8,["modelValue"])]),_:1}),e(h,{label:"\u98DF\u6750\u4EF7\u683C",prop:"price"},{default:s(()=>[e(P,{modelValue:a.value.price,"onUpdate:modelValue":o[1]||(o[1]=l=>a.value.price=l),precision:2,step:.1},null,8,["modelValue","step"])]),_:1}),e(h,{label:"\u5907\u6CE8",prop:"remark"},{default:s(()=>[e(z,{modelValue:a.value.remark,"onUpdate:modelValue":o[2]||(o[2]=l=>a.value.remark=l),type:"textarea"},null,8,["modelValue"])]),_:1})]),_:1},8,["model"])]),_:1},8,["modelValue","title"])],64)}}};export{te as default};