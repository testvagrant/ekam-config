# Ekam Config ![Ekam Config](https://github.com/testvagrant/ekam-config/actions/workflows/ekam-config.yml/badge.svg)
[Ekam home](https://ekam.testvagrant.ai/) | [Documentation](https://ekam.testvagrant.ai/docs/setup/ekam_setup/)

Ekam Config as the name sugges is a core configuration library for ekam.

The core functionalities include
* Default Properties
* Override Default Properties using file`config/<file>.properties`
* Override properties with system property. Eg: `-DpropKey=value`

## Configurations

### Web
|Property Key| Default Value | Supported Values | Description |
|------------|---------------|------------------|--------------|
| web.feed   | empty string            | Any custom file name| Feed file having desiredCapabilities, arguments etc|
| web.target | chrome | chrome, firefox, msedge, responsive | Web target, where to run tests. Choose responsive for responsive test execution (default browser chrome)|
| web.hub | empty string | Any cloud provider browserstack, saucelabs etc| A file where remote cloud provider details are stored | 

## Language Coverage
* Java

## Licence

Ekam Config is licensed under a MIT LICENSE

## Building

```shell
./gradlew clean build
```

