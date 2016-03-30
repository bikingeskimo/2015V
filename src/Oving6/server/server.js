var express = require('express');
var app = express();

//This resource makes it possible to download and start the Angular 2 client
app.use(express.static(__dirname + "/../client"));

//Additional resources can be defined, for instance this test-resource that is not used in this standalone client example
app.get('/test', function (req, res) {
    res.send("hello");
});

//Start the web server serving the Angular 2 standalone client
//Open for instance http://localhost:3000 in a web browser
var server = app.listen(3000, function () {
    var host = server.address().address;
    var port = server.address().port;
    console.log('Example app listening at http://%s:%s', host, port);
});
//# sourceMappingURL=server.js.map