define(['persons','jquery', 'underscore', 'backbone', 'mustache'], function (domain, $, _, Backbone) {

    $.fn.persons = function () {
        this.find("#submit").click(function () {
            domain.person.save({
                "firstname":$("#firstName").val(),
                "lastname":$("#lastName").val()
            });
        });
    };

    domain.persons.on("reset", function (collection) {
        $("#persons tbody").empty();
        var view = {"rows":collection.toJSON()};
        var renderedRows = Mustache.render("{{#rows}}<tr><td>{{id}}</td><td class='firstName'>{{firstname}}</td><td class='lastName'>{{lastname}}</td></tr>{{/rows}}", view);
        $("#persons tbody").html(renderedRows);
    });

    domain.persons.fetch({error:function () {
        console.log(arguments);
    }});

});