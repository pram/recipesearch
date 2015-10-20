# RecipeSearch #

## Build & Run ##

```sh
$ cd RecipeSearch
$ ./sbt
> container:start
> browse
```

## Standalone Elastic search

### Install ES Plugins

#### Windows
    bin\plugin --install mobz/elasticsearch-head
    bin\plugin --install lmenezes/elasticsearch-kopf/1.5.8
    bin\plugin --install elasticsearch/marvel/latest
    
#### Unix
    ./bin/plugin --install mobz/elasticsearch-head
    ./bin/plugin --install lmenezes/elasticsearch-kopf/1.5.8
    ./bin/plugin --install elasticsearch/marvel/latest

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.

## Todo

 * Move ES data to somewhere not temp
 

