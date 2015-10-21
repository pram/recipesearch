# RecipeSearch
[![Build Status](https://travis-ci.org/pram/recipesearch.svg?branch=master)](https://travis-ci.org/pram/recipesearch)

Download file from [OpenRecipes](http://openrecip.es/). [Direct link](http://openrecipes.s3.amazonaws.com/recipeitems-latest.json.gz)

start the server using

    cd server
    sbt  
    > container:start

start the client using

    cd client

To run the loader - If you just want to get some data into the system. Make sure an external elastic search is running

    cd loader
    npm install elasticsearch request
    node download_file.js
    //TODO extract the file. Do it manually for now
    node load_recipes.js

 
