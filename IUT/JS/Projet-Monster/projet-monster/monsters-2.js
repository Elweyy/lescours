'use strict'

var monster = {
    modules: {}
};

monster.modules.actions = ( function() {
    var name;
    var life ;
    var money;
    var awake ;
    var _showme = function () {
            alert('Nom: ' + name +', vie : '+ life + ' , argent : ' + money +' , éveillé :' + awake);
        };

    var _init = function( n,l,m){
        name = n;
        life = l;
        money = m;
        awake = true;
    };

    return {
        showme : _showme,
        init : _init
    };
}) ();




monster.modules.app = (function () {

    let newy = document.getElementById("b1");
    let runny = document.getElementById("b2");
    let fighting = document.getElementById("b3");
    let dodo = document.getElementById("b4");
    let nomnom = document.getElementById("b5");
    let showb = document.getElementById("b6");
    let dead = document.getElementById("k");



    var _run = function () {
        let actions = monster.modules.actions;
        actions.init('Lolo',12,10);
        showb.onclick = actions.showme;
    }

    var _log = function(message) {
        let elm = document.getElementById("actionbox");
        let item = document.createElement('p');
        let t =document.createTextNode(message);

        item.insertBefore(t, elm.firstChild );
        elm.appendChild(item);
    }
        return {
            run : _run,
            log : _log
        }
}) ();

monster.modules.app.log("lol");
monster.modules.app.log("top");

window.onload = monster.modules.app.run;
