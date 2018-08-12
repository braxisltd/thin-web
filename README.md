thin-web
========

This project is the result of a spike into web technologies and the testing of them
-----------------------------------------------------------------------------------

We are undertaking a new rich web application and wanted to spike out some ideas. This project contains the current sweet-spot of technologies. It's domain is a little contrived but it gets the point across.

We have decided on a Scala backend running though [Unfiltered](http://github.com/unfiltered/unfiltered). Unfiltered wraps up the essence of an http application in a really pleasing api. The server will mainly just provide resources over json. [lift-json](http://github.com/lift/lift/tree/master/framework/lift-base/lift-json/) will be used for json marshalling/unmarshalling.

In the browser we intend to use a combination of [jQuery](http://jquery.com/), [Backbone.js](http://backbonejs.org) & [Require.js](http://requirejs.org/).

Web testing will be provided by the [Selenium](http://seleniumhq.org/) java api for web flow and [Jasmine](https://jasmine.github.io/) for js unit tests.


We like to develop with well focused best-of-breed libraries and feel that these choices fit this criteria well.


We welcome your comments.
