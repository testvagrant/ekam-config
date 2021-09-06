# Ekam Config ![Ekam Config](https://github.com/testvagrant/ekam-config/actions/workflows/ekam-config.yml/badge.svg)
[Ekam home](https://ekam.testvagrant.ai/) | [Documentation](https://ekam.testvagrant.ai/docs/setup/ekam_setup/)

Ekam Config as the name suggests is a core configuration library for ekam.

The core functionalities include
* Default Properties
* Override Default Properties using file`config/<file>.properties`
* Override properties with system property. Eg: `-DpropKey=value`

## Configurations

### Web
|**Property Key**| **Default Value** | **Supported Values** | **Description** |
|------------|---------------|------------------|--------------|
| **web.feed**   | empty string            | Any custom file name| Feed file having desiredCapabilities, arguments etc|
| **web.target** | chrome | chrome, firefox, msedge, responsive | Web target, where to run tests. Choose responsive for responsive test execution (default browser chrome)|
| **web.hub** | empty string | Any cloud provider browserstack, saucelabs etc| A file where remote cloud provider details are stored | 
|**web.headless**| false| true, false|Runs tests in headless mode. Set true to execute tests in headless mode|
|**web.url**| empty string | Any web url | Web url of web application under test| 
|**web.console.log**| false | true, false| Captures web console logs |

### Mobile
|**Property Key**| **Default Value** | **Supported Values** | **Description** |
|------------|---------------|------------------|--------------|
| **mobile.feed**   | empty string            | Any custom file name| Feed file having desiredCapabilities, arguments etc|
| **mobile.target** | android | android, ios | Mobile target, where to run tests.|
| **mobile.hub** | empty string | Any cloud provider browserstack, saucelabs etc| A file where remote cloud provider details are stored | 
| **mobile.filters** | empty string |Any custom file name | Device filters file name to run tests on specific devices | 
|**mobile.server.args**| empty string | Any custom file name| A file name with [Appium Server Arguments](https://appium.io/docs/en/writing-running-appium/server-args/) |
|**mobile.executables**| empty string | Any custom file name| A file name appium main.js and node path. Use this if the installation path is not default |
|**mobile.remote.uploadapp**| false | true, false | Upload app to remote cloud, before running test suite|
|**mobile.app.name**| empty string | any app name | Provide app name when mobile.feed is not created |

### Api
|**Property Key**| **Default Value** | **Supported Values** | **Description** |
|------------|---------------|------------------|--------------|
| **api.hosts**   | hosts            | Any custom file name| A file name where hosts are defined|

### DB
|**Property Key**| **Default Value** | **Supported Values** | **Description** |
|------------|---------------|------------------|--------------|
| **db.drivers**   | drivers            | Any custom file name| A file name where DB driver connection details are defined|


### DataSets
|**Property Key**| **Default Value** | **Supported Values** | **Description** |
|------------|---------------|------------------|--------------|
| **datasets.dir**   | empty string            | Any custom directory name| Directory name where datasets are stored |
| **cache.size**   | 10000          | 1-N| Cache size to store data keys |

### Locale
|**Property Key**| **Default Value** | **Supported Values** | **Description** |
|------------|---------------|------------------|--------------|
| **locale.dir**   | empty string            | Any custom directory name| Directory name where locale strings are stored |
| **locale**   | empty string          | en,fr etc| Target locale for tests. en, fr etc |

### Cloud
|**Property Key**| **Default Value** | **Supported Values** | **Description** |
|------------|---------------|------------------|--------------|
| **cloud.config.dir**   | cloud_config            | Any custom directory name| Directory name where cloud configuration are created|

### Dashboard
|**Property Key**| **Default Value** | **Supported Values** | **Description** |
|------------|---------------|------------------|--------------|
| **dashboard.url**   | empty string            | URL| URL of Ekam Dashboard. Results get published to dashboard if the url is defined |

### Env
|**Property Key**| **Default Value** | **Supported Values** | **Description** |
|------------|---------------|------------------|--------------|
| **env**   | empty string            | Any custom env string| Base env for all layers of automation. |
| **web.env**   | empty string            | Any custom env string| Env for web tests |
| **mobile.env**   | empty string            | Any custom env string| Env for mobile tests |
| **api.env**   | empty string            | Any custom env string| Env for api hosts |
| **db.env**   | empty string            | Any custom env string| Env for db driver connections |
| **locale.env**   | empty string            | Any custom env string| Env for locale data |
| **datasets.env**   | empty string            | Any custom env string| Env for datasets data |

## Building

```shell
./gradlew clean build
```

