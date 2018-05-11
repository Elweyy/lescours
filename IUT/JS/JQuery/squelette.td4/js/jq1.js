'use strict'

var jql ={
    modules : { }
};

jql.modules.texte = function() {

    var _init = function(){
        $("#changingText").click(jql.modules.texte.changeStyle);
    };

    var _changeStyle = function(){
            $(this).toggleClass('hop');
            $(this).toggleClass('zap');

        };
    return {
        changeStyle : _changeStyle,
        init : _init
    };
}();




jql.modules.boites = function(){

    var _init = function(){
        $("#square").children().mouseover(jql.modules.boites.largeurPlus);
        $("#square").children().click(jql.modules.boites.largeurInit);
        $("#one").click(jql.modules.boites.addBoite);
        $("#two").click(jql.modules.boites.changeStyleAgain);
        $("#three").click(jql.modules.boites.fadeToggle);
    };
    var _largeurPlus = function(){
        $(this).css("width","+=10");
    };

    var _largeurInit = function(){
        $(this).css("width","100");
    };

    var _addBoite = function(){
        $("#square").append('<div class="boite_orange"></div>');
    };

    var _changeStyleAgain = function(){
        $("#square").children().toggleClass('boite_orange');
        $("#square").children().toggleClass('boite_verte');

    };

    var _fadeToggle = function(){
        $("#square").children().fadeToggle();
    };

    return {
        init : _init,
        largeurPlus : _largeurPlus,
        largeurInit : _largeurInit,
        addBoite : _addBoite,
        changeStyleAgain : _changeStyleAgain,
        fadeToggle : _fadeToggle
    }
}();



jql.modules.slider = function(){

    var _init = function(){
        $("#showContent").click(jql.modules.slider.sliding);

    };

    var _sliding = function(){

        $("p.slidingContent").slideToggle();
    };


    var _modiftexte = function(texte){
        $("p.slidingContent").contents().replaceWith(texte);

    };

    return {
        init : _init,
        sliding : _sliding,
        modiftexte : _modiftexte

    }
}();


jql.modules.menu = function(){

    var _init = function(){
        $(".sub").click(jql.modules.menu.showMenu);
    };

    var _showMenu = function(){
        if($(this).next("ul:visible").length !=0){
            $(this).next("ul").slideUp("normal");
        }else{
            $(".menu ul").slideUp("normal");
            $(this).next("ul").slideDown("normal");
        }
    };

    return {
        init : _init,
        showMenu : _showMenu
    }
}();



jql.modules.modale = function(){

    var _init = function(){

    };

    
    return {
        init : _init
    }
}();


$(function(){
    jql.modules.texte.init();
    jql.modules.boites.init();
    jql.modules.slider.init();
    jql.modules.menu.init();
    jql.modules.modale.init();
});
