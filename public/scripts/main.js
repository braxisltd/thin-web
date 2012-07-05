require.config({

    baseUrl:"/public/",

    paths:{
        "jquery":'lib/jquery',
        "jquery-lib":'lib/jquery-lib',
        "backbone":'lib/backbone',
        "backbone-lib":'lib/backbone-lib',
        "underscore":'lib/underscore',
        "underscore-lib":'lib/underscore-lib',
        "mustache":"lib/mustache-lib",
        "app":'scripts/app',
        "persons":"scripts/persons"
    },

    shim:{
        "app":["jquery"],
        "backbone":["underscore"]
    }

});

require(['jquery','app'], function ($) {
    $("body").persons();
});