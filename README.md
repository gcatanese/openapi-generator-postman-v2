# OpenAPI Generator for Postman v2

## Overview
Implementation of the OpenAPI generator for Postman format v2.1.

From an OpenAPI file it generates a Postman collection in the Postman V2 json format.

See available [options](#config-options) to customise the generation.

## Usage

* [Run with Docker](#run-with-docker)
* [Create a test](#create-a-test)
* [Build from source](#run-from-source)

### Run with Docker

Run with pre-built image passing `inputFile` (path of the OpenAPI spec file) and `outputFolder` (location 
of the generated file i.e ./postman/gen).

It supports the following commands:
* `generate`: create the postman.json file
* `push`: create postman.json and push to your postman.com default workspace

```docker
# generate only
docker run -v $(pwd):/usr/src/app \ 
   -e inputFile=src/test/resources/SampleProject.yaml \ 
   -e outputFolder=tmp \ 
   -it --rm --name postmanv2-container gcatanese/openapi-generator-postman-v2 generate  

# generate and push to Postman.com
docker run -v $(pwd):/usr/src/app \ 
   -e inputFile=src/test/resources/SampleProject.yaml \ 
   -e outputFolder=tmp \ 
   -e postmanApiKey=YOUR_POSTMAN_API_KEY \
   -it --rm --name postmanv2-container gcatanese/openapi-generator-postman-v2 push  
```

### Create a test

The easiest way to run the `postman-v2` OpenAPI generator is to create a custom unit test.
The postman.json will be created in the specified `outputDir`.

```java
    // configure generator
    final CodegenConfigurator configurator = new CodegenConfigurator()
            .setGeneratorName("postman-v2")
            .setInputSpec("/path/to/openapifile.json")
            .setOutputDir("/output");
    
    final ClientOptInput clientOptInput = configurator.toClientOptInput();
    // generate
    DefaultGenerator generator = new DefaultGenerator();
    List<File> files = generator.opts(clientOptInput).generate();

```

### Run from source

Clone and build [OpenAPI Generator](https://github.com/OpenAPITools/openapi-generator) CLI

Build `postman-v2` from source

Run OpenAPI Generator adding `postman-v2` jar file in the class path and specifying the `PostmanV2Generator` generator:
```shell
java -cp target/openapi-generator-postman-v2.jar:/openapi-generator/modules/openapi-generator-cli/target/openapi-generator-cli.jar \
  org.openapitools.codegen.OpenAPIGenerator generate -g com.tweesky.cloudtools.codegen.PostmanV2Generator \
  -i src/test/resources/BasicJson.json -o output
```
## METADATA

| Property | Value     | Notes |
| -------- |-----------|---|
| generator name | postman-v2 | pass this to the generate command after -g |
| generator stability | DEVELOPMENT |   |
| generator type | DOCUMENTATION |   |
| generator default templating engine | mustache  |   |
| helpTxt | Creates a Postman json file (v2.1.0) | Schema https://schema.postman.com/collection/json/v2.1.0/draft-07/collection.json |

## CONFIG OPTIONS
These options may be applied as additional-properties (cli) or configOptions (plugins). 

| Option | Description                                                      | Values          | Default      |
| ------ |------------------------------------------------------------------|-----------------|--------------|
|folderStrategy| whether to create folders according to the spec???s paths or tags  | Paths, Tags     | Paths        |
|pathParamsAsVariables| boolean, whether to create Postman variables for path parameters | true, false     | true         |
|postmanFile| name of the generated Postman file  |                 | postman.json |
|namingRequests| how the requests inside the generated collection will be named. If ???Fallback??? is selected, the request will be named after one of the following schema values: description, operationid, url  | Fallback, URL   | Fallback     |
|postmanVariables| csv list of Postman variables to be created during the generation. Matching placeholders in request bodies will be defined as Postman variables                                              |                 |       |
|requestParameterGeneration| whether to generate the request parameters based on the schema or the examples  | Example, Schema | Example      |
