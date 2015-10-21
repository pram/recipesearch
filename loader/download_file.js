var fs = require('fs'),
    request = require('request');

var download = function(uri, filename, callback){
  request.head(uri, function(err, res, body){
    request(uri).pipe(fs.createWriteStream(filename)).on('close', callback);
  });
};

download('http://openrecipes.s3.amazonaws.com/recipeitems-latest.json.gz', 'recipeitems-latest.json.gz', function(){
  console.log('done');
});