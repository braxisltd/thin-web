define(['jquery', 'persons'], function ($, domain) {

    beforeEach(function () {
        //mocking ajax call with Jasmine Spies
        var fakeData = [
            {"id":"0f60e8c8-422f-4952-a743-60ecb5c34016", "firstName":"Gemma", "lastName":"Ballinger"}
        ];
        spyOn($, "ajax").andCallFake(function (params) {
            params.success(fakeData);
        });
    });

    describe('When saving a Person', function () {
        it ('the Persons collection should get updated', function () {
            var name = "";
            domain.persons.on("reset", function (collection) {
                name = collection.at(0).get("firstName") + " " + collection.at(0).get("lastName");
            });
            domain.person.save({firstName:"Darren", lastName:"Ballinger"});

            expect(name).toBe("Gemma Ballinger");
        });
    });
});