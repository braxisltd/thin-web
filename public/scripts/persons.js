define(['underscore', 'backbone'], function (_, Backbone) {
    var persons;
    var Person = Backbone.Model.extend({
        firstname:"",
        lastname:"",
        url:function () {
            return this.id ? "/persons/" + this.id : "/persons";
        },
        initialize:function () {
            this.on("sync", function () {
                console.log("saved");
                persons.fetch({error:function () {
                    console.log(arguments);
                }});
            });
        }
    });

    var Persons = Backbone.Collection.extend({
        model:Person,
        url:"/persons"
    });
    persons = new Persons([]);
    var person = new Person();
    return {
        "person":person,
        "persons":persons
    }
});