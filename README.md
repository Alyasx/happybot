# happybot [![Travis](https://img.shields.io/travis/JRoy/happybot.svg?style=for-the-badge)](https://travis-ci.org/JRoy/happybot) [![Jenkins Download](https://img.shields.io/badge/jenkins-download-blue.svg?style=for-the-badge)](http://142.44.162.101:8080/job/happybot//)  [![Codacy grade](https://img.shields.io/codacy/grade/8c61619d7c67461083fc9386bd5b6c87.svg?style=for-the-badge)]()
The moderation bot used on the happyheart discord server.
# Dependencies
We handle all dependencies via gradle but if you must have all of them here they are:
* [JDA](https://github.com/DV8FromTheWorld/JDA)
* [JDA-Utilities](https://github.com/JDA-Applications/JDA-Utilities)
* [Hypixel4J](https://github.com/KevinPriv/HypixelApi4J)
* [SLF4J](https://www.slf4j.org/)
* [Apache Commons Lang3](https://github.com/apache/commons-lang)
* [Twitter4J](https://github.com/yusuke/twitter4j)
* [gson](https://github.com/google/gson)
* [JUnit 4](https://github.com/junit-team/junit4/)
* [EvalEx](https://github.com/uklimaschewski/EvalEx)
* [riot-api-java](https://github.com/taycaldwell/riot-api-java)
* [YouTube Data API](https://developers.google.com/api-client-library/java/apis/youtube/v3)
* [Simple-YAML](https://github.com/Carleslc/Simple-YAML)
* [JRAW](https://github.com/mattbdean/JRAW)
* [~~Shitlin~~Kotlin](https://github.com/JetBrains/kotlin)
* [discord-themer](https://github.com/JRoy/discord-themer)

# Setup
Now this bot is made to only work with one guild, as we depend on very specific roles/channels and their respective ids.
If you still would like to use this bot, despite you needing to basically copy exactly how happyheart's guild looks and works follow these steps:
* Pretty much change all of the util package. This is where most of the ids are exposed, especially the C class. If you enjoy stack traces but also enjoy basic function, I suggest you inspect and change the classes: Constants and Roles for any exposed ids and replace them for your own use case. The bot will still not work 100% but will at least run and not break.
* Run the bot once, and allow for its files to be created and follow the configuration section below.
* Restart the bot and watch as it creates many stack traces in your console.

Some things may not still work such as the gamble system, as the create table statement is not provided with this code, that may change in the future but that's how it is now.

# Configuration
All of the config options are stored inside of a yml file called: "setting.yml" All the settings in there must be set if you want the bot to load. The options will generate on the bot's first run.
# Building
To make sure all of our dependencies get included in our jar files, we use @johnrengelman's shadow plugin for gradle. Here are the commands you would use to build this yourself:

* Windows: ```gradlew.bat shawdowJar```
* Linux/Mac (Any UNIX-Based OS): ```./gradlew shadowJar```

# Exit Codes
This program uses System.exit() to use custom exit codes. While this is not recommended for people to use, (with non-java compliant codes), we did it anyway.
Our bash script that manages this bot uses the following exit codes to decide how to take action upon the program exiting.
* 10 - Download Update from a Testing Point (I use Dropbox)
* 20 - Download Update from a Jenkins Server (Grabs the latest artifact)
* 30 - Stop the loop of the boot script.

# Note
You are free to make pull requests and/or report issues here, and reuse the code at your own will, just please provide credit back to me!
# 
[![forthebadge](http://forthebadge.com/images/badges/built-with-love.svg)](http://forthebadge.com)[![forthebadge](http://forthebadge.com/images/badges/60-percent-of-the-time-works-every-time.svg)](http://forthebadge.com)
