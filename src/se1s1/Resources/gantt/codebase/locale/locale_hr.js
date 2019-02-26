/*
@license

dhtmlxGantt v.6.1.0 Standard
This software is covered by GPL license. You also can obtain Commercial or Enterprise license to use it in non-GPL project - please contact sales@dhtmlx.com. Usage without proper license is prohibited.

(c) Dinamenta, UAB.

*/
!function(e,t){if("object"==typeof exports&&"object"==typeof module)module.exports=t();else if("function"==typeof define&&define.amd)define([],t);else{var n=t();for(var o in n)("object"==typeof exports?exports:e)[o]=n[o]}}(window,function(){return function(e){var t={};function n(o){if(t[o])return t[o].exports;var i=t[o]={i:o,l:!1,exports:{}};return e[o].call(i.exports,i,i.exports,n),i.l=!0,i.exports}return n.m=e,n.c=t,n.d=function(e,t,o){n.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:o})},n.r=function(e){"undefined"!=typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},n.t=function(e,t){if(1&t&&(e=n(e)),8&t)return e;if(4&t&&"object"==typeof e&&e&&e.__esModule)return e;var o=Object.create(null);if(n.r(o),Object.defineProperty(o,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var i in e)n.d(o,i,function(t){return e[t]}.bind(null,i));return o},n.n=function(e){var t=e&&e.__esModule?function(){return e.default}:function(){return e};return n.d(t,"a",t),t},n.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},n.p="/codebase/",n(n.s=180)}({180:function(e,t){gantt.locale={date:{month_full:["Siječanj","Veljača","Ožujak","Travanj","Svibanj","Lipanj","Srpanj","Kolovoz","Rujan","Listopad","Studeni","Prosinac"],month_short:["Sij","Velj","Ožu","Tra","Svi","Lip","Srp","Kol","Ruj","Lis","Stu","Pro"],day_full:["Nedjelja","Ponedjeljak","Utorak","Srijeda","Četvrtak","Petak","Subota"],day_short:["Ned","Pon","Uto","Sri","Čet","Pet","Sub"]},labels:{new_task:"Novi Zadatak",new_event:"Novi događaj",icon_save:"Spremi",icon_cancel:"Odustani",icon_details:"Detalji",icon_edit:"Izmjeni",icon_delete:"Obriši",confirm_closing:"",confirm_deleting:"Zadatak će biti trajno izbrisan, jeste li sigurni?",section_description:"Opis",section_time:"Vremenski Period",section_type:"Tip",column_wbs:"WBS",column_text:"Naziv Zadatka",column_start_date:"Početno Vrijeme",column_duration:"Trajanje",column_add:"",link:"Poveznica",confirm_link_deleting:"će biti izbrisan",link_start:" (početak)",link_end:" (kraj)",type_task:"Zadatak",type_project:"Projekt",type_milestone:"Milestone",minutes:"Minute",hours:"Sati",days:"Dani",weeks:"Tjedni",months:"Mjeseci",years:"Godine",message_ok:"OK",message_cancel:"Odustani",section_constraint:"Constraint",constraint_type:"Constraint type",constraint_date:"Constraint date",asap:"As Soon As Possible",alap:"As Late As Possible",snet:"Start No Earlier Than",snlt:"Start No Later Than",fnet:"Finish No Earlier Than",fnlt:"Finish No Later Than",mso:"Must Start On",mfo:"Must Finish On"}}}})});
//# sourceMappingURL=locale_hr.js.map