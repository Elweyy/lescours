'use strict'

var photobox ={
    modules : { }
};

photobox.modules.photoloader =  function(){


    var url ;

    var _init = function(host){

        var url = host;

        }

    var uri
    var _load_objects_liste = function(uri){

        var urn =url + uri;

        var pr = $.ajax(host,{
            type : "GET",
            context : this,
            xhrFields : {withCredentials: true}
        });

        pr.done(function(data,status,jqXHR){
            alert("Oui");
        });
        pr.fail(function(jqXHR,status,error){
            alert("error loading data : "+ error);
    });
    }

    return {
        init : _init,
        load_objects_liste : _load_objects_liste,

    }
}

photobox.modules.photoloader.init("https://webetu.iutnc.univ-lorraine.fr");
photobox.modules.load_objects_liste("/www/canals5/photobox/photos/?offset=8&size=12");
