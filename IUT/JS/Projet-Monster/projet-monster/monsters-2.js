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
            monster.modules.app.displayStatus(life,money,awake);
            monster.modules.app.log(name +" is alive !!");
        };

    var _init = function( n,l,m){
        name = n;
        life = l;
        money = m;
        awake = true;
    };

    var _fight = function(){
        if(_isavailable() == true ){
            life = life - 3;
            monster.modules.app.log(name + " se bat !! Il perd 3 points de vie ...\n");
            if(life <= 0){
                monster.modules.app.log(" ... et il meurt dans la bataille. RIP brave soldier");
                awake = false;
                life = 0;
            }
            monster.modules.app.displayStatus(life,money,awake);
        }else{
            monster.modules.app.log(name + " n'est pas disponible pour se battre.");
        }
    }

    var _run = function(){
        if(_isavailable() == true ){
            life = life - 1;
            monster.modules.app.log(name + " fait son running !! Il perd 1 points de vie ...\n");
            if(life <= 0){
                monster.modules.app.log(" ... et il meurt de son diabète.");
                awake = false;
                life = 0;
            }
            monster.modules.app.displayStatus(life,money,awake);
        }else{
            monster.modules.app.log(name + " n'est pas disponible pour son jogging quotidien.");
        }
    }

    var _work = function(){
        if(_isavailable() == true ){
            life -= 1;
            money += 2;
            monster.modules.app.log(name + " travaille dur dans son atelier ! Il perd 1 points de vie ...\n");
            if(life <= 0){
                monster.modules.app.log(" ... et il meurt d'épuisement au travail.");
                awake = false;
                life = 0;
            }
            monster.modules.app.displayStatus(life,money,awake);
        }else{
            monster.modules.app.log(name + " n'est pas disponible pour bosser.");
        }
    }

    var _eat = function(){
        if(_isavailable() == true ){
            if(money >= 3){
                life += 2;
                money -= 3;
                monster.modules.app.log(name + " mange comme un cochon ! Il gagne 2 points de vie et perd 3 unités d'argent ...\n");
                monster.modules.app.displayStatus(life,money,awake);
            }else{
                monster.modules.app.log(name + "ne peut pas se payer à manger :( ");
            }
        }else{
            monster.modules.app.log(name + " n'est pas disponible pour manger.");
        }
    }

    var _sleep = function(){
        if(_isavailable() == true ){
            setTimeout(monster.modules.app.log(name +" s'endort"), 3000);
        }
    }

    /*J'ai rajouté cette petite fonction pour faciliter les vérifications
    de la disponibilité du monstre */
    var _isavailable = function(){
        if(life > 0){
            if(awake == true){
                return true;
            }
        }else{
            return false;
        }
    }

    return {
        showme : _showme,
        init : _init,
        isavailable : _isavailable,
        fight : _fight,
        run : _run,
        work : _work,
        eat : _eat,
        sleep : _sleep
    };
}) ();




monster.modules.app = (function () {

    let newy = document.getElementById("b1");
    let runny = document.getElementById("b2");
    let fighting = document.getElementById("b3");
    let dodo = document.getElementById("b4");
    let nomnom = document.getElementById("b5");
    let showb = document.getElementById("b6");
    let working = document.getElementById("b7");
    let dead = document.getElementById("k");



    var _run = function () {
        let actions = monster.modules.actions;
        actions.init('Lolo',12,10);
        showb.onclick = actions.showme;
        fighting.onclick = actions.fight;
        dodo.onclick = actions.sleep;
        nomnom.onclick = actions.eat;
        runny.onclick = actions.run;
        working.onclick = actions.work;

    }

    var _log = function(message) {
        let elm = document.getElementById("actionbox");
        let item = document.createElement('p');
        let t =document.createTextNode(message);

        item.appendChild(t);
        elm.insertBefore(item,elm.firstChild);
    }

    var _displayStatus = function( life, money, awake){
        let elm = document.getElementById("status");
        let item = elm.childNodes;
        item[1].innerHTML = "life:"+life;
        item[2].innerHTML = "money"+money;
        item[3].innerHTML = "awake: "+ awake;
    }

        return {
            run : _run,
            log : _log,
            displayStatus : _displayStatus
        }
}) ();

window.onload = monster.modules.app.run;
